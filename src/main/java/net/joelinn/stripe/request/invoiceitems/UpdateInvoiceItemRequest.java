package net.joelinn.stripe.request.invoiceitems;

import net.joelinn.stripe.request.Request;

import java.util.Map;

/**
 * User: Joe Linn
 * Date: 5/23/2014
 * Time: 2:43 PM
 */
public class UpdateInvoiceItemRequest extends Request{
    protected Integer amount;

    protected String description;

    protected Map<String, Object> metadata;

    public UpdateInvoiceItemRequest setAmount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public UpdateInvoiceItemRequest setDescription(String description) {
        this.description = description;
        return this;
    }

    public UpdateInvoiceItemRequest setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
        return this;
    }
}
