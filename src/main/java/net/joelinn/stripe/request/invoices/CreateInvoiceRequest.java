package net.joelinn.stripe.request.invoices;

import net.joelinn.stripe.request.Request;

import java.util.Map;

/**
 * User: Joe Linn
 * Date: 5/24/2014
 * Time: 3:42 PM
 */
public class CreateInvoiceRequest extends Request{
    protected String customer;
    
    protected Integer applicationFee;
    
    protected String description;
    
    protected Map<String, Object> metadata;
    
    protected String subscription;

    public CreateInvoiceRequest(String customer) {
        this.customer = customer;
    }

    public CreateInvoiceRequest setApplicationFee(Integer applicationFee) {
        this.applicationFee = applicationFee;
        return this;
    }

    public CreateInvoiceRequest setDescription(String description) {
        this.description = description;
        return this;
    }

    public CreateInvoiceRequest setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
        return this;
    }

    public CreateInvoiceRequest setSubscription(String subscription) {
        this.subscription = subscription;
        return this;
    }
}
