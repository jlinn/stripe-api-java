package net.joelinn.stripe.request.subscriptions;

import net.joelinn.stripe.request.Request;
import net.joelinn.stripe.request.cards.CreateCardRequest;

import java.util.Date;
import java.util.Map;

/**
 * User: Joe Linn
 * Date: 5/25/2014
 * Time: 7:40 PM
 */
@SuppressWarnings("unchecked")
public class CreateSubscriptionRequest<T extends CreateSubscriptionRequest> extends Request{
    protected String plan;
    
    protected String coupon;
    
    protected Date trialEnd;
    
    protected Object card;
    
    protected Integer quantity;
    
    protected Float applicationFeePercent;
    
    protected Map<String, Object> metadata;

    public CreateSubscriptionRequest(String plan) {
        this.plan = plan;
    }
    
    public T setCard(String token){
        card = token;
        return (T) this;
    }
    
    public T setCard(CreateCardRequest request){
        card = request;
        return (T) this;
    }

    public T setCoupon(String coupon) {
        this.coupon = coupon;
        return (T) this;
    }

    public T setTrialEnd(Date trialEnd) {
        this.trialEnd = trialEnd;
        return (T) this;
    }

    public T setQuantity(Integer quantity) {
        this.quantity = quantity;
        return (T) this;
    }

    public T setApplicationFeePercent(Float applicationFeePercent) {
        this.applicationFeePercent = applicationFeePercent;
        return (T) this;
    }

    public T setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
        return (T) this;
    }
}
