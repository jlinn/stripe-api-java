package net.joelinn.stripe.test.api;

import net.joelinn.stripe.api.Charges;
import net.joelinn.stripe.api.Refunds;
import net.joelinn.stripe.request.ListRequest;
import net.joelinn.stripe.request.cards.CreateCardRequest;
import net.joelinn.stripe.request.charges.CreateChargeRequest;
import net.joelinn.stripe.request.refunds.CreateRefundRequest;
import net.joelinn.stripe.response.charges.ChargeResponse;
import net.joelinn.stripe.response.refunds.ListRefundsResponse;
import net.joelinn.stripe.response.refunds.RefundResponse;
import net.joelinn.stripe.test.StripeTestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasSize;

/**
 * User: Joe Linn
 * Date: 7/28/2014
 * Time: 12:03 PM
 */
public class RefundsTest extends StripeTestCase{
    protected Refunds refunds;

    protected Charges charges;

    protected ChargeResponse createChargeResponse;

    @Before
    public void setUp(){
        refunds = new Refunds(client);
        charges = new Charges(client);

        // create a charge
        CreateChargeRequest createChargeRequest = new CreateChargeRequest(350, "usd").setCard(new CreateCardRequest(VISA_1, 1, 2020));
        createChargeResponse = charges.createCharge(createChargeRequest);
    }

    @Test
    public void testGetRefund(){
        // refund the charge
        Map<String, Object> metadata = new HashMap<String, Object>();
        metadata.put("foo", "bar");
        RefundResponse createRefundResponse = refunds.createRefund(createChargeResponse.getId(), new CreateRefundRequest().setMetadata(metadata));

        assertEquals(createChargeResponse.getAmount(), createRefundResponse.getAmount());

        // retrieve the refund
        RefundResponse getRefundResponse = refunds.getRefund(createRefundResponse.getCharge(), createRefundResponse.getId());

        assertEquals(createRefundResponse.getAmount(), getRefundResponse.getAmount());
        assertThat(getRefundResponse.getMetadata(), hasKey("foo"));
        assertEquals("bar", getRefundResponse.getMetadata().get("foo"));
    }

    @Test
    public void testUpdateRefund(){
        // create a refund
        RefundResponse createRefundResponse = refunds.createRefund(createChargeResponse.getId());

        assertEquals(0, createRefundResponse.getMetadata().size());

        // modify the refund
        Map<String, Object> metadata = new HashMap<String, Object>();
        metadata.put("foo", "bar");
        RefundResponse updateRefundResponse = refunds.updateRefund(createRefundResponse.getCharge(), createRefundResponse.getId(), metadata);

        assertThat(updateRefundResponse.getMetadata(), hasKey("foo"));
        assertEquals("bar", updateRefundResponse.getMetadata().get("foo"));
    }

    @Test
    public void testListRefunds(){
        // create a refund
        RefundResponse createRefundResponse = refunds.createRefund(createChargeResponse.getId());

        // list refunds
        ListRefundsResponse listRefundsResponse = refunds.listRefunds(createRefundResponse.getCharge(), new ListRequest());

        assertThat(listRefundsResponse.getData(), hasSize(1));
    }
}
