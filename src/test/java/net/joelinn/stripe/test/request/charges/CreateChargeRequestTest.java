package net.joelinn.stripe.test.request.charges;

import com.sun.jersey.core.util.MultivaluedMapImpl;
import net.joelinn.stripe.request.charges.CreateChargeRequest;
import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsIn;
import org.hamcrest.core.Every;
import org.junit.Test;

import javax.ws.rs.core.MultivaluedMap;
import java.util.HashMap;
import java.util.Map;

public class CreateChargeRequestTest {
    @Test
    public void testToRequest(){
        MultivaluedMap<String, String> expected = new MultivaluedMapImpl();
        expected.add("amount", "350");
        expected.add("currency", "USD");
        expected.add("metadata[foo]", "28");
        expected.add("metadata[isMeta]", "true");


        CreateChargeRequest chargeRequest = new CreateChargeRequest(350, "USD");
        Map<String, Object> metadata = new HashMap<String, Object>();
        metadata.put("foo", 28);
        metadata.put("isMeta", true);
        chargeRequest.setMetadata(metadata);

        MultivaluedMap<String, String> request = chargeRequest.toRequest();

        MatcherAssert.assertThat(request.entrySet(), Every.everyItem(IsIn.isIn(expected.entrySet())));
        MatcherAssert.assertThat(expected.entrySet(), Every.everyItem(IsIn.isIn(request.entrySet())));
    }
}