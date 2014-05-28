package net.joelinn.stripe.test.api;

import net.joelinn.stripe.api.Charges;
import net.joelinn.stripe.request.cards.CreateCardRequest;
import net.joelinn.stripe.request.charges.CreateChargeRequest;
import net.joelinn.stripe.response.charges.ChargeResponse;
import net.joelinn.stripe.response.charges.ListChargesResponse;
import net.joelinn.stripe.test.StripeTestCase;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChargesTest extends StripeTestCase{
    protected Charges charges;

    @Before
    public void setUp(){
        charges = new Charges(client);
    }

    @Test
    public void testCreateCharge(){
        CreateChargeRequest request = new CreateChargeRequest(350, "usd").setCard(new CreateCardRequest(VISA_1, 1, 2020));
        ChargeResponse response = charges.createCharge(request);

        assertEquals("usd", response.getCurrency());
        assertEquals(350, response.getAmount());
        assertEquals(1, response.getCard().getExpMonth());
    }

    @Test
    public void testGetCharge(){
        CreateChargeRequest request = new CreateChargeRequest(350, "usd").setCard(new CreateCardRequest(DISCOVER_1, 1, 2020));
        ChargeResponse createResponse = charges.createCharge(request);

        ChargeResponse getResponse = charges.getCharge(createResponse.getId());

        assertEquals(createResponse.getId(), getResponse.getId());
        assertEquals(createResponse.getAmount(), getResponse.getAmount());
    }

    @Test
    public void testUpdateCharge(){
        CreateChargeRequest request = new CreateChargeRequest(350, "usd").setCard(new CreateCardRequest(DISCOVER_1, 1, 2020));
        ChargeResponse createResponse = charges.createCharge(request);

        ChargeResponse refundResponse = charges.refundCharge(createResponse.getId());

        assertEquals(createResponse.getAmount(), refundResponse.getAmountRefunded());
    }

    @Test
    public void testCaptureCharge(){
        CreateChargeRequest request = new CreateChargeRequest(350, "usd").setCard(new CreateCardRequest(DISCOVER_1, 1, 2020))
                .setCapture(false);
        ChargeResponse createResponse = charges.createCharge(request);

        assertFalse(createResponse.isCaptured());

        ChargeResponse captureResponse = charges.captureCharge(createResponse.getId());

        assertTrue(captureResponse.isCaptured());
    }

    @Test
    public void testListCharges(){
        ListChargesResponse listResponse = charges.listCharges(null);

        assertThat(listResponse.getData(), Matchers.hasSize(Matchers.greaterThan(1)));
    }
}