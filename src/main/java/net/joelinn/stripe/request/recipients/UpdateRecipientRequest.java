package net.joelinn.stripe.request.recipients;

import net.joelinn.stripe.request.Request;
import net.joelinn.stripe.request.cards.CreateCardRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Joe Linn
 * Date: 5/25/2014
 * Time: 7:02 PM
 */
@SuppressWarnings("unchecked")
public class UpdateRecipientRequest<T extends UpdateRecipientRequest> extends Request{
    protected String name;
    
    protected String taxId;
    
    protected Map<String, Object> bankAccount;
    
    protected Object card;
    
    protected String defaultCard;
    
    protected String email;
    
    protected String description;
    
    protected Map<String, Object> metadata;
    
    public T setBankAccount(String country, String routingNumber, String accountNumber){
        Map<String, Object> account = new HashMap<String, Object>();
        account.put("country", country);
        account.put("routing_number", routingNumber);
        account.put("account_number", accountNumber);
        bankAccount = account;
        return (T) this;
    }
    
    protected T setCard(String token){
        card = token;
        return (T) this;
    }
    
    protected T setCard(CreateCardRequest request){
        card = request;
        return (T) this;
    }

    public T setName(String name) {
        this.name = name;
        return (T) this;
    }

    public T setTaxId(String taxId) {
        this.taxId = taxId;
        return (T) this;
    }

    public T setDefaultCard(String defaultCard) {
        this.defaultCard = defaultCard;
        return (T) this;
    }

    public T setEmail(String email) {
        this.email = email;
        return (T) this;
    }

    public T setDescription(String description) {
        this.description = description;
        return (T) this;
    }

    public T setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
        return (T) this;
    }
}
