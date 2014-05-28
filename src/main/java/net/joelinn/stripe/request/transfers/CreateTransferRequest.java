package net.joelinn.stripe.request.transfers;

import net.joelinn.stripe.request.Request;

import java.util.Map;

/**
 * User: Joe Linn
 * Date: 5/26/2014
 * Time: 9:03 PM
 */
public class CreateTransferRequest extends Request{
    protected Integer amount;
    
    protected String currency;
    
    protected String recipient;
    
    protected String description;
    
    protected String statementDescription;
    
    protected Map<String, Object> metadata;

    public CreateTransferRequest(Integer amount, String currency, String recipient) {
        this.amount = amount;
        this.currency = currency;
        this.recipient = recipient;
    }

    public CreateTransferRequest setDescription(String description) {
        this.description = description;
        return this;
    }

    public CreateTransferRequest setStatementDescription(String statementDescription) {
        this.statementDescription = statementDescription;
        return this;
    }

    public CreateTransferRequest setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
        return this;
    }
}
