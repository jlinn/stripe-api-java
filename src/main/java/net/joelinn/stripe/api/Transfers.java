package net.joelinn.stripe.api;

import net.joelinn.stripe.Client;
import net.joelinn.stripe.request.transfers.CreateTransferRequest;
import net.joelinn.stripe.request.transfers.ListTransfersRequest;
import net.joelinn.stripe.request.transfers.UpdateTransferRequest;
import net.joelinn.stripe.response.transfers.ListTransfersResponse;
import net.joelinn.stripe.response.transfers.TransferResponse;

/**
 * User: Joe Linn
 * Date: 5/26/2014
 * Time: 9:07 PM
 */
public class Transfers extends AbstractApi{
    public Transfers(Client client) {
        super(client);
    }

    /**
     * Create a transfer
     * <a href="https://stripe.com/docs/api#create_transfer">https://stripe.com/docs/api#create_transfer</a>
     */
    public TransferResponse createTransfer(CreateTransferRequest request){
        return client.post(buildUrl(), TransferResponse.class, request.toRequest());
    }

    /**
     * Retrieve a transfer
     * <a href="https://stripe.com/docs/api#retrieve_transfer">https://stripe.com/docs/api#retrieve_transfer</a>
     * @param transferId the id of the transfer to retrieve
     */
    public TransferResponse getTransfer(String transferId){
        return client.get(buildUrl(transferId), TransferResponse.class);
    }

    /**
     * Update a transfer record
     * <a href="https://stripe.com/docs/api#update_transfer">https://stripe.com/docs/api#update_transfer</a>
     * @param transferId the id of the transfer to update
     */
    public TransferResponse updateTransfer(String transferId, UpdateTransferRequest request){
        return client.post(buildUrl(transferId), TransferResponse.class, request.toRequest());
    }

    /**
     * Cancel a transfer
     * <a href="https://stripe.com/docs/api#cancel_transfer">https://stripe.com/docs/api#cancel_transfer</a>
     * @param transferId the id of the transfer to cancel
     */
    public TransferResponse cancelTransfer(String transferId){
        return client.post(buildUrl(transferId) + "/cancel", TransferResponse.class);
    }

    /**
     * List transfer records
     * <a href="https://stripe.com/docs/api#list_transfers">https://stripe.com/docs/api#list_transfers</a>
     */
    public ListTransfersResponse listTransfers(ListTransfersRequest request){
        return client.get(buildUrl(), ListTransfersResponse.class, null, request.toRequest());
    }

    protected String buildUrl(){
        return buildUrl(null);
    }

    protected String buildUrl(String transferId){
        String url = "transfers";
        if(transferId != null){
            url += "/" + transferId;
        }
        return url;
    }
}
