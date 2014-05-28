package net.joelinn.stripe.api;

import net.joelinn.stripe.Client;
import net.joelinn.stripe.request.recipients.CreateRecipientRequest;
import net.joelinn.stripe.request.recipients.ListRecipientsRequest;
import net.joelinn.stripe.request.recipients.UpdateRecipientRequest;
import net.joelinn.stripe.response.DeleteResponse;
import net.joelinn.stripe.response.recipients.ListRecipientsResponse;
import net.joelinn.stripe.response.recipients.RecipientResponse;

/**
 * User: Joe Linn
 * Date: 5/25/2014
 * Time: 7:14 PM
 */
public class Recipients extends AbstractApi{
    public Recipients(Client client) {
        super(client);
    }

    /**
     * Create a recipient
     * <a href="https://stripe.com/docs/api#create_recipient">https://stripe.com/docs/api#create_recipient</a>
     */
    public RecipientResponse createRecipient(CreateRecipientRequest request){
        return client.post(buildUrl(), RecipientResponse.class, request.toRequest());
    }

    /**
     * Retrieve a recipient
     * <a href="https://stripe.com/docs/api#retrieve_recipient">https://stripe.com/docs/api#retrieve_recipient</a>
     * @param recipientId the id of the recipient ot be retrieved
     */
    public RecipientResponse getRecipient(String recipientId){
        return client.get(buildUrl(recipientId), RecipientResponse.class);
    }

    /**
     * Update a recipient
     * <a href="https://stripe.com/docs/api#update_recipient">https://stripe.com/docs/api#update_recipient</a>
     * @param recipientId the id of the recipient ot be updated
     */
    public RecipientResponse updateRecipient(String recipientId, UpdateRecipientRequest request){
        return client.post(buildUrl(recipientId), RecipientResponse.class, request.toRequest());
    }

    /**
     * Delete a recipient
     * <a href="https://stripe.com/docs/api#delete_recipient">https://stripe.com/docs/api#delete_recipient</a>
     * @param recipientId the id of the recipient ot be deleted
     */
    public DeleteResponse deleteRecipient(String recipientId){
        return client.delete(buildUrl(recipientId), DeleteResponse.class);
    }

    /**
     * List recipients
     * <a href="https://stripe.com/docs/api#list_recipients">https://stripe.com/docs/api#list_recipients</a>
     */
    public ListRecipientsResponse listRecipients(ListRecipientsRequest request){
        return client.get(buildUrl(), ListRecipientsResponse.class, null, request.toRequest());
    }

    protected String buildUrl(){
        return buildUrl(null);
    }

    protected String buildUrl(String recipientId){
        String url = "recipients";
        if(recipientId != null){
            url += "/" + recipientId;
        }
        return url;
    }
}
