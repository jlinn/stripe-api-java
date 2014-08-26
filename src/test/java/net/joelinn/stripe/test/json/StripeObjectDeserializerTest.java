package net.joelinn.stripe.test.json;

import net.joelinn.stripe.json.StripeObjectDeserializer;
import net.joelinn.stripe.response.customers.CustomerResponse;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.deser.StdDeserializerProvider;
import org.codehaus.jackson.map.module.SimpleDeserializers;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class StripeObjectDeserializerTest {
    protected ObjectMapper mapper;

    @Before
    public void setUp(){
        mapper = new ObjectMapper();
        SimpleDeserializers deserializers = new SimpleDeserializers();
        deserializers.addDeserializer(Map.class, new StripeObjectDeserializer());
        mapper.setDeserializerProvider(new StdDeserializerProvider().withAdditionalDeserializers(deserializers));
    }

    @Test
    public void testDeserializeCustomerObject() throws IOException {
        final String json = "{ \"object\": { \"object\": \"customer\", \"created\": 1408733152, \"id\": \"cus_4deLKMCtm2gAXe\", \"livemode\": false, \"description\": \"virtumedix+jo88@gmail.com\", \"email\": null, \"delinquent\": false, \"metadata\": {}, \"subscriptions\": { \"object\": \"list\", \"total_count\": 0, \"has_more\": false, \"url\": \"/v1/customers/cus_4deLKMCtm2gAXe/subscriptions\", \"data\": [] }, \"discount\": null, \"account_balance\": 0, \"currency\": null, \"cards\": { \"object\": \"list\", \"total_count\": 1, \"has_more\": false, \"url\": \"/v1/customers/cus_4deLKMCtm2gAXe/cards\", \"data\": [ { \"id\": \"card_14UN2q2eZvKYlo2CgtDItKuE\", \"object\": \"card\", \"last4\": \"4242\", \"brand\": \"Visa\", \"funding\": \"credit\", \"exp_month\": 3, \"exp_year\": 2016, \"fingerprint\": \"Xt5EWLLDS7FJjR1c\", \"country\": \"US\", \"name\": null, \"address_line1\": null, \"address_line2\": null, \"address_city\": null, \"address_state\": null, \"address_zip\": null, \"address_country\": null, \"cvc_check\": \"pass\", \"address_line1_check\": null, \"address_zip_check\": null, \"customer\": \"cus_4deLKMCtm2gAXe\" } ] }, \"default_card\": \"card_14UN2q2eZvKYlo2CgtDItKuE\" }, \"foo\": [\"bar\"], \"baz\": {\"a\": 3} }";

        Map<String, Object> convertedValue = mapper.readValue(json, new TypeReference<Map<String, Object>>() {});
        assertThat(convertedValue, hasKey("object"));
        assertThat(convertedValue.get("object"), instanceOf(CustomerResponse.class));

        assertThat(convertedValue, hasKey("foo"));
        assertThat(convertedValue.get("foo"), instanceOf(List.class));
        @SuppressWarnings("unchecked")
        List<Object> foo = (List) convertedValue.get("foo");
        assertThat(foo, hasSize(1));
        assertThat((String) foo.get(0), equalTo("bar"));

        assertThat(convertedValue, hasKey("baz"));
        assertThat(convertedValue.get("baz"), instanceOf(Map.class));
        @SuppressWarnings("unchecked")
        Map<String, Object> baz = (Map<String, Object>) convertedValue.get("baz");
        assertThat(baz, hasKey("a"));
        assertThat((Integer) baz.get("a"), equalTo(3));
    }
}