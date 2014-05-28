package net.joelinn.stripe.api;

import net.joelinn.stripe.Client;
import net.joelinn.stripe.request.invoiceitems.CreateInvoiceItemRequest;
import net.joelinn.stripe.request.invoiceitems.ListInvoiceItemsRequest;
import net.joelinn.stripe.request.invoiceitems.UpdateInvoiceItemRequest;
import net.joelinn.stripe.response.DeleteResponse;
import net.joelinn.stripe.response.invoiceitems.InvoiceItemResponse;
import net.joelinn.stripe.response.invoiceitems.ListInvoiceItemsResponse;

/**
 * User: Joe Linn
 * Date: 5/23/2014
 * Time: 2:39 PM
 */
public class InvoiceItems extends AbstractApi{
    public InvoiceItems(Client client) {
        super(client);
    }

    /**
     * Create an invoice item
     * <a href="https://stripe.com/docs/api#create_invoiceitem">https://stripe.com/docs/api#create_invoiceitem</a>
     */
    public InvoiceItemResponse createInvoiceItem(CreateInvoiceItemRequest request){
        return client.post(buildUrl(), InvoiceItemResponse.class, request.toRequest());
    }

    /**
     * Retrieve an invoice item
     * <a href="https://stripe.com/docs/api#retrieve_invoiceitem">https://stripe.com/docs/api#retrieve_invoiceitem</a>
     * @param invoiceItemId the id of the invoice item to retrieve
     */
    public InvoiceItemResponse getInvoiceItem(String invoiceItemId){
        return client.get(buildUrl(invoiceItemId), InvoiceItemResponse.class);
    }

    /**
     * Update an invoice item
     * <a href="https://stripe.com/docs/api#update_invoiceitem">https://stripe.com/docs/api#update_invoiceitem</a>
     * @param invoiceItemId the id of the invoice item to update
     */
    public InvoiceItemResponse updateInvoiceItem(String invoiceItemId, UpdateInvoiceItemRequest request){
        return client.post(buildUrl(invoiceItemId), InvoiceItemResponse.class, request.toRequest());
    }

    /**
     * Delete an invoice item
     * <a href="https://stripe.com/docs/api#delete_invoiceitem">https://stripe.com/docs/api#delete_invoiceitem</a>
     * @param invoiceItemId the id of the invoice item to delete
     */
    public DeleteResponse deleteInvoiceItem(String invoiceItemId){
        return client.delete(buildUrl(invoiceItemId), DeleteResponse.class);
    }

    /**
     * List invoice items
     * <a href="https://stripe.com/docs/api#list_invoiceitems">https://stripe.com/docs/api#list_invoiceitems</a>
     */
    public ListInvoiceItemsResponse listInvoiceItems(ListInvoiceItemsRequest request){
        return client.get(buildUrl(), ListInvoiceItemsResponse.class, null, request.toRequest());
    }

    protected String buildUrl(){
        return buildUrl(null);
    }

    protected String buildUrl(String invoiceItemId){
        String url = "invoiceitems";
        if(invoiceItemId != null){
            url += "/" + invoiceItemId;
        }
        return url;
    }
}
