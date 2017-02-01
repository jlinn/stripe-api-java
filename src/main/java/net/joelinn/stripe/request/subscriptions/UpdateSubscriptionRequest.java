package net.joelinn.stripe.request.subscriptions;

/**
 * User: Joe Linn
 * Date: 5/25/2014
 * Time: 7:42 PM
 */
public class UpdateSubscriptionRequest extends CreateSubscriptionRequest<UpdateSubscriptionRequest>{
    protected Boolean prorate;

    public UpdateSubscriptionRequest() {
        super(null);
    }

    public UpdateSubscriptionRequest setProrate(Boolean prorate) {
        this.prorate = prorate;
        return this;
    }

    public UpdateSubscriptionRequest setPlan(String plan) {
        this.plan = plan;
        return this;
    }
}
