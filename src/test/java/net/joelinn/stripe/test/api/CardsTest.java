package net.joelinn.stripe.test.api;

import net.joelinn.stripe.api.Cards;
import net.joelinn.stripe.api.Tokens;
import net.joelinn.stripe.error.card.*;
import net.joelinn.stripe.request.cards.CreateCardRequest;
import net.joelinn.stripe.request.cards.UpdateCardRequest;
import net.joelinn.stripe.request.tokens.CreateCardTokenRequest;
import net.joelinn.stripe.response.DeleteResponse;
import net.joelinn.stripe.response.cards.CardResponse;
import net.joelinn.stripe.response.cards.ListCardsResponse;
import net.joelinn.stripe.response.customers.CustomerResponse;
import net.joelinn.stripe.response.tokens.TokenResponse;
import net.joelinn.stripe.test.StripeTestCase;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * User: Joe Linn
 * Date: 5/22/2014
 * Time: 3:40 PM
 */
public class CardsTest extends StripeTestCase{
    protected Cards cards;

    protected String customerId;

    @Before
    public void setUp(){
        cards = new Cards(client);
        customerId = client.post("customers", CustomerResponse.class).getId();
    }

    @After
    public void tearDown(){
        client.delete("customers/" + customerId, DeleteResponse.class);
    }

    @Test
    public void testCreateCard(){
        String cardNumber = VISA_1;
        CreateCardRequest request = new CreateCardRequest(cardNumber, 1, 2020);
        CardResponse response = cards.createCard(customerId, request);

        assertEquals(cardNumber.substring(cardNumber.length() - 4), response.getLast4());
    }

    @Test
    public void testCreateCardFromToken(){
        TokenResponse token = new Tokens(client).createToken(new CreateCardTokenRequest()
                .setCard(new CreateCardRequest(VISA_1, 1, 2020)));

        CardResponse createResponse = cards.createCard(customerId, token.getId());

        assertEquals(1, createResponse.getExpMonth());
        assertEquals(2020, createResponse.getExpYear());
    }

    @Test(expected = IncorrectNumberException.class)
    public void testCreateCardIncorrectNumber(){
        String cardNumber = INCORRECT_NUMBER;
        CreateCardRequest request = new CreateCardRequest(cardNumber, 1, 2020);
        cards.createCard(customerId, request);
    }

    @Test(expected = CardDeclinedException.class)
    public void testCreateCardDeclined(){
        String cardNumber = CARD_DECLINED;
        CreateCardRequest request = new CreateCardRequest(cardNumber, 1, 2020);
        cards.createCard(customerId, request);
    }

    @Test(expected = InvalidExpiryMonthException.class)
    public void testCreateCardInvalidExpiryMonth(){
        String cardNumber = VISA_1;
        CreateCardRequest request = new CreateCardRequest(cardNumber, 13, 2020);
        cards.createCard(customerId, request);
    }

    @Test(expected = InvalidExpiryYearException.class)
    public void testCreateCardInvalidExpiryYear(){
        String cardNumber = VISA_1;
        CreateCardRequest request = new CreateCardRequest(cardNumber, 1, 1984);
        cards.createCard(customerId, request);
    }

    @Test(expected = InvalidCvcException.class)
    public void testCreateCardInvalidCvc(){
        String cardNumber = VISA_1;
        CreateCardRequest request = new CreateCardRequest(cardNumber, 1, 2020).setCvc(29);
        cards.createCard(customerId, request);
    }

    @Test
    public void testUpdateCard(){
        CardResponse createResponse = cards.createCard(customerId, new CreateCardRequest(VISA_1, 1, 2020));
        UpdateCardRequest request = new UpdateCardRequest().setExpYear((short) 2021);
        CardResponse updateResponse = cards.updateCard(customerId, createResponse.getId(), request);

        assertEquals(createResponse.getId(), updateResponse.getId());
        assertEquals(2021, updateResponse.getExpYear());
    }

    @Test
    public void testGetCard(){
        CardResponse createResponse = cards.createCard(customerId, new CreateCardRequest(VISA_1, 1, 2020));
        CardResponse card = cards.getCard(customerId, createResponse.getId());

        assertEquals(createResponse.getId(), card.getId());
    }

    @Test
    public void testListCards(){
        CardResponse card1 = cards.createCard(customerId, new CreateCardRequest(VISA_1, 1, 2020));
        CardResponse card2 = cards.createCard(customerId, new CreateCardRequest(MASTERCARD_1, 1, 2020));
        ListCardsResponse list = cards.listCards(customerId);

        assertThat(list.getData(), Matchers.hasSize(2));
        short cardsFound = 0;
        for (CardResponse cardResponse : list.getData()) {
            if(card1.getId().equals(cardResponse.getId()) || card2.getId().equals(cardResponse.getId())){
                cardsFound++;
            }
        }
        assertEquals(2, cardsFound);
    }

    @Test
    public void testDeleteCard(){
        CardResponse card = cards.createCard(customerId, new CreateCardRequest(VISA_1, 1, 2020));
        DeleteResponse deleteResponse = cards.deleteCard(customerId, card.getId());

        assertTrue(deleteResponse.isDeleted());
        assertEquals(card.getId(), deleteResponse.getId());
    }
}
