package net.joelinn.stripe.test.api;

import net.joelinn.stripe.api.Tokens;
import net.joelinn.stripe.error.card.InvalidExpiryYearException;
import net.joelinn.stripe.request.cards.CreateCardRequest;
import net.joelinn.stripe.request.tokens.CreateBankAccountTokenRequest;
import net.joelinn.stripe.request.tokens.CreateCardTokenRequest;
import net.joelinn.stripe.response.tokens.TokenResponse;
import net.joelinn.stripe.test.StripeTestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TokensTest extends StripeTestCase {

    protected Tokens tokens;

    @Before
    public void setUp(){
        tokens = new Tokens(client);
    }

    @Test
    public void testCreateCardToken(){
        TokenResponse createResponse = tokens.createToken(new CreateCardTokenRequest()
                .setCard(new CreateCardRequest(VISA_1, 1, 2020)));

        assertEquals(1, createResponse.getCard().getExpMonth());
    }

    @Test(expected = InvalidExpiryYearException.class)
    public void testCreateCardTokenInvalidExpiryYear(){
        tokens.createToken(new CreateCardTokenRequest()
                .setCard(new CreateCardRequest(VISA_1, 1, 2000)));
    }

    @Test
    public void testCreateBankAccountToken(){
        TokenResponse createResponse = tokens.createToken(
                new CreateBankAccountTokenRequest("US", ROUTING_NUMBER, ACCOUNT_NUMBER));

        assertEquals("US", createResponse.getBankAccount().getCountry());
    }

    @Test
    public void testGetToken(){
        TokenResponse createResponse = tokens.createToken(new CreateCardTokenRequest()
                .setCard(new CreateCardRequest(VISA_1, 1, 2020)));

        TokenResponse getResponse = tokens.getToken(createResponse.getId());

        assertEquals(createResponse.getId(), getResponse.getId());
        assertEquals(1, getResponse.getCard().getExpMonth());
    }
}