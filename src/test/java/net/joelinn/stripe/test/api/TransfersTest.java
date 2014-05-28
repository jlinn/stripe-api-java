package net.joelinn.stripe.test.api;

import net.joelinn.stripe.api.Transfers;
import net.joelinn.stripe.error.StripeApiException;
import net.joelinn.stripe.request.transfers.CreateTransferRequest;
import net.joelinn.stripe.request.transfers.ListTransfersRequest;
import net.joelinn.stripe.request.transfers.UpdateTransferRequest;
import net.joelinn.stripe.response.transfers.ListTransfersResponse;
import net.joelinn.stripe.response.transfers.TransferResponse;
import net.joelinn.stripe.test.StripeTestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TransfersTest extends StripeTestCase {

    protected Transfers transfers;

    @Before
    public void setUp() {
        transfers = new Transfers(client);
    }

    @Test
    public void testCreateTransfer(){
        int amount = 350;
        TransferResponse createResponse = transfers.createTransfer(new CreateTransferRequest(amount, "usd", "self"));

        assertEquals(amount, createResponse.getAmount());
    }

    @Test
    public void testGetTransfer(){
        TransferResponse createResponse = createTransfer();

        TransferResponse getResponse = transfers.getTransfer(createResponse.getId());

        assertEquals(createResponse.getId(), getResponse.getId());
        assertEquals(createResponse.getAmount(), getResponse.getAmount());
    }

    @Test
    public void testUpdateTransfer(){
        TransferResponse createResponse = createTransfer();

        String description = "updated description";
        TransferResponse updateResponse = transfers.updateTransfer(createResponse.getId(),
                new UpdateTransferRequest().setDescription(description));

        assertEquals(description, updateResponse.getDescription());
    }

    @Test(expected = StripeApiException.class)
    public void testCancelTransfer(){
        TransferResponse createResponse = createTransfer();

        // this should throw an exception because a submitted transfer cannot be canceled
        transfers.cancelTransfer(createResponse.getId());
    }

    @Test
    public void testListTransfers(){
        TransferResponse createResponse = createTransfer();

        ListTransfersResponse list = transfers.listTransfers(new ListTransfersRequest());

        boolean found = false;
        for (TransferResponse transfer : list.getData()) {
            if(transfer.getId().equals(createResponse.getId())){
                found = true;
            }
        }
        assertTrue(found);
    }

    protected TransferResponse createTransfer(){
        return transfers.createTransfer(new CreateTransferRequest(350, "usd", "self"));
    }
}