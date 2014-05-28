package net.joelinn.stripe.request.transfers;

import net.joelinn.stripe.request.Request;

import java.util.Map;

/**
 * User: Joe Linn
 * Date: 5/26/2014
 * Time: 9:11 PM
 */
public class UpdateTransferRequest extends Request{
    protected String description;
    
    protected Map<String, Object> metadata;

    public UpdateTransferRequest setDescription(String description) {
        this.description = description;
        return this;
    }

    public UpdateTransferRequest setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
        return this;
    }
}
