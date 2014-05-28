package net.joelinn.stripe.api;

import com.sun.jersey.core.util.MultivaluedMapImpl;
import net.joelinn.stripe.Client;
import net.joelinn.stripe.request.cards.CreateCardRequest;
import net.joelinn.stripe.request.cards.UpdateCardRequest;
import net.joelinn.stripe.response.DeleteResponse;
import net.joelinn.stripe.response.cards.CardResponse;
import net.joelinn.stripe.response.cards.ListCardsResponse;

import javax.ws.rs.core.MultivaluedMap;

/**
 * User: Joe Linn
 * Date: 5/22/2014
 * Time: 3:02 PM
 */
public class Cards extends AbstractApi{
    public Cards(Client client) {
        super(client);
    }

    /**
     * Create a credit card record using a card token
     * <a href="https://stripe.com/docs/api/curl#create_card">https://stripe.com/docs/api/curl#create_card</a>
     * @param customerId the id of the customer with which to associate the card
     * @param token the card token string
     */
    public CardResponse createCard(String customerId, String token){
        MultivaluedMap<String, String> request = new MultivaluedMapImpl();
        request.add("card", token);
        return client.post(buildUrl(customerId), CardResponse.class, request);
    }

    /**
     * Create a credit card record
     * <a href="https://stripe.com/docs/api/curl#create_card">https://stripe.com/docs/api/curl#create_card</a>
     * @param customerId the id of the customer with which to associate the card
     * @param request the card creation request
     */
    public CardResponse createCard(String customerId, CreateCardRequest request){
        return client.post(buildUrl(customerId), CardResponse.class, request.toRequest());
    }

    /**
     * Update a credit card record
     * <a href="https://stripe.com/docs/api/curl#retrieve_card">https://stripe.com/docs/api/curl#retrieve_card</a>
     * @param customerId the id of the customer with which the card record is associated
     * @param cardId the id of the card to be updated
     * @param request the update request data
     */
    public CardResponse updateCard(String customerId, String cardId, UpdateCardRequest request){
        return client.post(buildUrl(customerId, cardId), CardResponse.class, request);
    }

    /**
     * Retrieve a card
     * <a href="https://stripe.com/docs/api/curl#retrieve_card">https://stripe.com/docs/api/curl#retrieve_card</a>
     * @param customerId the id of the customer with which the card record is associated
     * @param cardId the id of the card to be retrieved
     */
    public CardResponse getCard(String customerId, String cardId){
        return client.get(buildUrl(customerId, cardId), CardResponse.class);
    }

    /**
     * Delete a credit card record
     * <a href="https://stripe.com/docs/api#delete_card">https://stripe.com/docs/api#delete_card</a>
     * @param customerId the id of the customer with which the card record is associated
     * @param cardId the id of the card to be deleted
     */
    public DeleteResponse deleteCard(String customerId, String cardId){
        return client.delete(buildUrl(customerId, cardId), DeleteResponse.class);
    }

    /**
     * List credit card records for the given customer
     * <a href="https://stripe.com/docs/api/curl#list_cards">https://stripe.com/docs/api/curl#list_cards</a>
     * @param customerId the id of the customer for which to list cards
     */
    public ListCardsResponse listCards(String customerId){
        return listCards(customerId, null);
    }

    /**
     * List credit card records for the given customer
     * <a href="https://stripe.com/docs/api/curl#list_cards">https://stripe.com/docs/api/curl#list_cards</a>
     * @param customerId the id of the customer for which to list cards
     * @param limit optionally limit the number of card records returned
     */
    public ListCardsResponse listCards(String customerId, Integer limit){
        MultivaluedMap<String, String> request = new MultivaluedMapImpl();
        if(limit != null){
            request.add("limit", String.valueOf(limit));
        }
        return client.get(buildUrl(customerId), ListCardsResponse.class, null, request);
    }

    protected String buildUrl(String customerId){
        return buildUrl(customerId, null);
    }

    protected String buildUrl(String customerId, String cardId){
        String url = "customers/" + customerId + "/cards";
        if(cardId != null){
            url += "/" + cardId;
        }
        return url;
    }
}
