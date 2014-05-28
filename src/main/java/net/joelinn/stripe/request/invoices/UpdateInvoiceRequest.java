package net.joelinn.stripe.request.invoices;

import net.joelinn.stripe.request.Request;

import java.util.Map;

/**
 * User: Joe Linn
 * Date: 5/24/2014
 * Time: 7:10 PM
 */
public class UpdateInvoiceRequest extends Request{
    protected Integer applicationFee;
    
    protected Boolean closed;
    
    protected String description;
    
    protected Map<String, Object> metadata;

    public UpdateInvoiceRequest setApplicationFee(Integer applicationFee) {
        this.applicationFee = applicationFee;
        return this;
    }

    public UpdateInvoiceRequest setClosed(Boolean closed) {
        this.closed = closed;
        return this;
    }

    public UpdateInvoiceRequest setDescription(String description) {
        this.description = description;
        return this;
    }

    public UpdateInvoiceRequest setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
        return this;
    }
}
