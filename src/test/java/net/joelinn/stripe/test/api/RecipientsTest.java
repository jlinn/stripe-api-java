package net.joelinn.stripe.test.api;

import net.joelinn.stripe.api.Recipients;
import net.joelinn.stripe.request.recipients.CreateRecipientRequest;
import net.joelinn.stripe.request.recipients.ListRecipientsRequest;
import net.joelinn.stripe.request.recipients.UpdateRecipientRequest;
import net.joelinn.stripe.response.DeleteResponse;
import net.joelinn.stripe.response.recipients.ListRecipientsResponse;
import net.joelinn.stripe.response.recipients.RecipientResponse;
import net.joelinn.stripe.test.StripeTestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RecipientsTest extends StripeTestCase {

    protected Recipients recipients;

    @Before
    public void setUp() {
        recipients = new Recipients(client);
    }

    @Test
    public void testCreateRecipient() {
        String name = "Robert Loblaw";
        String type = "individual";
        RecipientResponse createResponse = recipients.createRecipient(new CreateRecipientRequest(name, type)
                .setBankAccount("US", ROUTING_NUMBER, ACCOUNT_NUMBER));

        assertEquals(name, createResponse.getName());
        assertEquals(type, createResponse.getType());

        deleteRecipient(createResponse.getId());
    }

    @Test
    public void testGetRecipient(){
        RecipientResponse createResponse = createRecipient();

        RecipientResponse getResponse = recipients.getRecipient(createResponse.getId());

        assertEquals(createResponse.getId(), getResponse.getId());

        deleteRecipient(getResponse.getId());
    }

    @Test
    public void testUpdateRecipient(){
        RecipientResponse createResponse = createRecipient();

        String email = "bob@loblaw.com";
        RecipientResponse updateResponse = recipients.updateRecipient(createResponse.getId(),
                new UpdateRecipientRequest().setEmail(email));

        assertEquals(email, updateResponse.getEmail());

        deleteRecipient(updateResponse.getId());
    }

    @Test
    public void testDeleteRecipient(){
        RecipientResponse createResponse = createRecipient();

        DeleteResponse deleteResponse = recipients.deleteRecipient(createResponse.getId());

        assertEquals(createResponse.getId(), deleteResponse.getId());
        assertTrue(deleteResponse.isDeleted());
    }

    @Test
    public void testListRecipients(){
        RecipientResponse createResponse = createRecipient();

        ListRecipientsResponse list = recipients.listRecipients(new ListRecipientsRequest());

        boolean found = false;
        for (RecipientResponse recipient : list.getData()) {
            if(recipient.getId().equals(createResponse.getId())){
                found = true;
            }
        }

        assertTrue(found);

        deleteRecipient(createResponse.getId());
    }

    protected RecipientResponse createRecipient(){
        String name = "Robert Loblaw";
        String type = "individual";
        return recipients.createRecipient(new CreateRecipientRequest(name, type)
                .setBankAccount("US", ROUTING_NUMBER, ACCOUNT_NUMBER));
    }

    protected DeleteResponse deleteRecipient(String recipientId){
        return client.delete("recipients/" + recipientId, DeleteResponse.class);
    }
}