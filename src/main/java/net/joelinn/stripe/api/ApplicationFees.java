package net.joelinn.stripe.api;

import com.sun.jersey.core.util.MultivaluedMapImpl;
import net.joelinn.stripe.Client;
import net.joelinn.stripe.response.applicationfees.ApplicationFeeResponse;
import net.joelinn.stripe.response.applicationfees.ListApplicationFeesResponse;

import javax.ws.rs.core.MultivaluedMap;

/**
 * User: Joe Linn
 * Date: 5/22/2014
 * Time: 2:28 PM
 */
public class ApplicationFees extends AbstractApi{
    public ApplicationFees(Client client) {
        super(client);
    }

    /**
     * Retrieve an application fee
     * <a href="https://stripe.com/docs/api#retrieve_application_fee">https://stripe.com/docs/api#retrieve_application_fee</a>
     * @param applicationFeeId the id of the fee to be retrieved
     */
    public ApplicationFeeResponse getApplicationFee(String applicationFeeId){
        return client.get(buildUrl(applicationFeeId), ApplicationFeeResponse.class);
    }

    /**
     * Refund an application fee
     * <a href="https://stripe.com/docs/api#refund_application_fee">https://stripe.com/docs/api#refund_application_fee</a>
     * @param applicationFeeId the id of the application fee to refund
     */
    public ApplicationFeeResponse refundApplicationFee(String applicationFeeId){
        return refundApplicationFee(applicationFeeId, null);
    }

    /**
     * Refund an application fee
     * <a href="https://stripe.com/docs/api#refund_application_fee">https://stripe.com/docs/api#refund_application_fee</a>
     * @param applicationFeeId the id of the application fee to refund
     * @param amount the amount to refund. Pass null to refund the full amount.
     */
    public ApplicationFeeResponse refundApplicationFee(String applicationFeeId, Integer amount){
        MultivaluedMap<String, String> params = new MultivaluedMapImpl();
        if(amount != null){
            params.add("amount", String.valueOf(amount));
        }
        return client.post(buildUrl(applicationFeeId), ApplicationFeeResponse.class, params);
    }

    /**
     * List application fees
     * <a href="https://stripe.com/docs/api#list_application_fees">https://stripe.com/docs/api#list_application_fees</a>
     */
    public ListApplicationFeesResponse listApplicationFees(){
        return listApplicationFees(new MultivaluedMapImpl());
    }

    /**
     * List application fees
     * <a href="https://stripe.com/docs/api#list_application_fees">https://stripe.com/docs/api#list_application_fees</a>
     * @param queryParams querystring parameters to control listing
     */
    public ListApplicationFeesResponse listApplicationFees(MultivaluedMap<String, String> queryParams){
        return client.get(buildUrl(null), ListApplicationFeesResponse.class, queryParams);
    }

    protected String buildUrl(String applicationFeeId){
        String url = "application_fees";
        if(applicationFeeId != null){
            url += "/" + applicationFeeId;
        }
        return url;
    }
}
