package net.joelinn.stripe.request.invoiceitems;

import net.joelinn.stripe.request.Request;

import java.util.Map;

/**
 * User: Joe Linn
 * Date: 5/23/2014
 * Time: 2:33 PM
 */
public class CreateInvoiceItemRequest extends Request{
    protected String customer;

    protected Integer amount;

    protected String currency;

    protected String invoice;

    protected String subscription;

    protected String description;

    protected Map<String, Object> metadata;

    public CreateInvoiceItemRequest(String customer, Integer amount, String currency) {
        this.customer = customer;
        this.amount = amount;
        this.currency = currency;
    }

    public CreateInvoiceItemRequest setInvoice(String invoice) {
        this.invoice = invoice;
        return this;
    }

    public CreateInvoiceItemRequest setSubscription(String subscription) {
        this.subscription = subscription;
        return this;
    }

    public CreateInvoiceItemRequest setDescription(String description) {
        this.description = description;
        return this;
    }

    public CreateInvoiceItemRequest setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
        return this;
    }
}
