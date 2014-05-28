package net.joelinn.stripe.request.customers;

import net.joelinn.stripe.request.Request;
import net.joelinn.stripe.request.cards.CreateCardRequest;

import java.util.Map;

/**
 * User: Joe Linn
 * Date: 5/21/2014
 * Time: 3:51 PM
 */
@SuppressWarnings("unchecked")
abstract public class AbstractCustomerRequest<T extends AbstractCustomerRequest> extends Request{
    protected Integer accountBalance;

    protected Object card;

    protected String coupon;

    protected String description;

    protected String email;

    protected Map<String, Object> metadata;

    public T setAccountBalance(Integer accountBalance) {
        this.accountBalance = accountBalance;
        return (T) this;
    }

    public T setCard(Object card) {
        if(!(card instanceof String) && !(card instanceof CreateCardRequest)){
            throw new IllegalArgumentException("card must be either a String or a CreateCardRequest");
        }
        this.card = card;
        return (T) this;
    }

    public T setCoupon(String coupon) {
        this.coupon = coupon;
        return (T) this;
    }

    public T setDescription(String description) {
        this.description = description;
        return (T) this;
    }

    public T setEmail(String email) {
        this.email = email;
        return (T) this;
    }

    public T setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
        return (T) this;
    }

    public Integer getAccountBalance() {
        return accountBalance;
    }

    public Object getCard() {
        return card;
    }

    public String getCoupon() {
        return coupon;
    }

    public String getDescription() {
        return description;
    }

    public String getEmail() {
        return email;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }
}
