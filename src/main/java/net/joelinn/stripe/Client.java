package net.joelinn.stripe;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import net.joelinn.stripe.error.StripeApiException;
import net.joelinn.stripe.error.card.*;
import net.joelinn.stripe.json.StripeModule;
import net.joelinn.stripe.response.ErrorResponse;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.PropertyNamingStrategy;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;

/**
 * User: Joe Linn
 * Date: 5/21/2014
 * Time: 2:31 PM
 */
public class Client {
    protected static final String BASE_URL = "https://api.stripe.com/";
    protected static final String VERSION = "v1";

    protected WebResource service;

    /**
     * @param apiKey your Stripe api key
     */
    public Client(String apiKey){
        this(apiKey, false);
    }

    /**
     * @param apiKey your Stripe api key
     * @param failOnUnknownProperties If true, a {@link org.codehaus.jackson.map.JsonMappingException} is thrown when
     *                                unknown Stripe response object properties are encountered. This is primarily used for
     *                                testing / debugging purposes.
     */
    public Client(String apiKey, boolean failOnUnknownProperties) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
        mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, failOnUnknownProperties);
        mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
        mapper.registerModule(new StripeModule());

        DefaultClientConfig config = new DefaultClientConfig();
        config.getSingletons().add(new JacksonJsonProvider(mapper));
        com.sun.jersey.api.client.Client client = com.sun.jersey.api.client.Client.create(config);
        client.addFilter(new HTTPBasicAuthFilter(apiKey, ""));
        service = client.resource(UriBuilder.fromUri(BASE_URL + VERSION + "/").build());
    }

    public  <T> T get(String url, Class<T> cls){
        return get(url, cls, null);
    }

    public  <T> T get(String url, Class<T> cls, MultivaluedMap<String, String> body){
        return request("GET", url, cls, body, null);
    }

    public  <T> T get(String url, Class<T> cls, MultivaluedMap<String, String> body, MultivaluedMap<String, String> queryParams){
        return request("GET", url, cls, body, queryParams);
    }

    public <T> T post(String url, Class<T> cls){
        return request("POST", url, cls);
    }

    public <T> T post(String url, Class<T> cls, MultivaluedMap<String, String> body){
        return request("POST", url, cls, body);
    }

    public <T> T delete(String url, Class<T> cls){
        return delete(url, cls, null, null);
    }

    public <T> T delete(String url, Class<T> cls, MultivaluedMap<String, String> body, MultivaluedMap<String, String> queryParams){
        return request("DELETE", url, cls, body, queryParams);
    }

    public  <T> T request(String method, String url, Class<T> cls){
        return request(method, url, cls, null, null);
    }

    public  <T> T request(String method, String url, Class<T> cls, MultivaluedMap body){
        return request(method, url, cls, body, null);
    }

    public  <T> T request(String method, String url, Class<T> cls, Object body, MultivaluedMap<String, String> queryParams){
        ClientResponse clientResponse = getResourceBuilder(url, queryParams).method(method, ClientResponse.class, body);
        final int status = clientResponse.getStatus();
        if(status >= 300){
            handleError(clientResponse.getEntity(ErrorResponse.class), status);
        }
        return clientResponse.getEntity(cls);
    }

    protected WebResource.Builder getResourceBuilder(String url, MultivaluedMap<String, String> queryParams){
        WebResource webResource = service.path(url);
        if(queryParams != null){
            webResource = webResource.queryParams(queryParams);
        }
        return webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_FORM_URLENCODED);
    }

    protected void handleError(final ErrorResponse error, final int status){
        StripeApiException apiException = new StripeApiException(error, status);
        if(error.getType().equals("card_error")){
            final String code = error.getCode();
            if(code.equals("incorrect_number")){
                throw new IncorrectNumberException(apiException);
            }
            if(code.equals("card_declined")){
                throw new CardDeclinedException(apiException);
            }
            if(code.equals("invalid_expiry_month")){
                throw new InvalidExpiryMonthException(apiException);
            }
            if(code.equals("invalid_expiry_year")){
                throw new InvalidExpiryYearException(apiException);
            }
            if(code.equals("invalid_cvc")){
                throw new InvalidCvcException(apiException);
            }
        }
        throw apiException;
    }
}
