package net.joelinn.stripe.request.invoiceitems;

import net.joelinn.stripe.request.ListRequest;

/**
 * User: Joe Linn
 * Date: 5/23/2014
 * Time: 2:57 PM
 */
public class ListInvoiceItemsRequest extends ListRequest<ListInvoiceItemsRequest>{
    protected String customer;

    public ListInvoiceItemsRequest setCustomer(String customer) {
        this.customer = customer;
        return this;
    }
}
