package net.joelinn.stripe.response.invoices;

import net.joelinn.stripe.response.plans.PlanResponse;
import net.joelinn.stripe.response.subscriptions.SubscriptionResponse;

import java.util.Map;

/**
 * User: Joe Linn
 * Date: 5/24/2014
 * Time: 7:02 PM
 */
public class LineItemResponse {
    protected String id;
    
    protected String object;

    protected boolean livemode;

    protected int amount;

    protected String currency;

    protected Map<String, Object> period;

    protected boolean proration;

    protected boolean discountable;

    protected String type;

    protected String description;

    protected Map<String, Object> metadata;

    protected PlanResponse plan;

    protected int quantity;

    protected String subscription;

    public String getId() {
        return id;
    }

    public String getObject() {
        return object;
    }

    public boolean isLivemode() {
        return livemode;
    }

    public int getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public Map<String, Object> getPeriod() {
        return period;
    }

    public boolean isProration() {
        return proration;
    }

    public boolean isDiscountable() {
        return discountable;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public PlanResponse getPlan() {
        return plan;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getSubscription() {
        return subscription;
    }
}
