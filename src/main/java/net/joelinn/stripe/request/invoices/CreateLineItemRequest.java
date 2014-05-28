package net.joelinn.stripe.request.invoices;

import net.joelinn.stripe.request.Request;

import java.util.Map;

/**
 * User: Joe Linn
 * Date: 5/24/2014
 * Time: 3:44 PM
 */
public class CreateLineItemRequest extends Request{
    protected String customer;
    
    protected Integer amount;
    
    protected String currency;
    
    protected String invoice;
    
    protected String subscription;
    
    protected Map<String, Object> metadata;

    public CreateLineItemRequest(String customer, Integer amount, String currency) {
        this.customer = customer;
        this.amount = amount;
        this.currency = currency;
    }

    public CreateLineItemRequest setInvoice(String invoice) {
        this.invoice = invoice;
        return this;
    }

    public CreateLineItemRequest setSubscription(String subscription) {
        this.subscription = subscription;
        return this;
    }

    public CreateLineItemRequest setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
        return this;
    }
}
