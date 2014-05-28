package net.joelinn.stripe.request.invoices;

/**
 * User: Joe Linn
 * Date: 5/24/2014
 * Time: 7:20 PM
 */
public class ListInvoiceLineItemsRequest extends ListInvoicesRequest<ListInvoiceLineItemsRequest>{
    protected String subscription;

    public ListInvoiceLineItemsRequest setSubscription(String subscription) {
        this.subscription = subscription;
        return this;
    }
}
