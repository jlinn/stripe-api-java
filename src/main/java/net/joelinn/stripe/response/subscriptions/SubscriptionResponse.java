package net.joelinn.stripe.response.subscriptions;

import net.joelinn.stripe.response.discounts.DiscountResponse;
import net.joelinn.stripe.response.plans.ListPlansResponse;
import net.joelinn.stripe.response.plans.ListPlansResponseWrapper;
import net.joelinn.stripe.response.plans.PlanResponse;

import java.util.Date;
import java.util.Map;

/**
 * User: Joe Linn
 * Date: 5/21/2014
 * Time: 4:17 PM
 */
public class SubscriptionResponse {
    protected String id;

    protected PlanResponse plan;

    protected ListPlansResponseWrapper items;

    protected String object;

    protected boolean cancelAtPeriodEnd;

    protected String customer;

    protected int quantity;

    protected Date start;

    protected String status;

    protected float applicationFeePercent;

    protected Date canceledAt;

    protected Date currentPeriodEnd;

    protected Date currentPeriodStart;

    protected DiscountResponse discount;

    protected Date endedAt;

    protected Date trialEnd;

    protected Date trialStart;

    protected Date created;

    protected boolean livemode;

    protected double taxPercent;

    public Date getCreated() {
        return created;
    }

    protected Map<String, Object> metadata;

    public String getId() {
        return id;
    }

    public PlanResponse getPlan() {
        return plan;
    }

    public ListPlansResponseWrapper getItems() {
        return items;
    }

    public String getObject() {
        return object;
    }

    public boolean isCancelAtPeriodEnd() {
        return cancelAtPeriodEnd;
    }

    public String getCustomer() {
        return customer;
    }

    public int getQuantity() {
        return quantity;
    }

    public Date getStart() {
        return start;
    }

    public String getStatus() {
        return status;
    }

    public float getApplicationFeePercent() {
        return applicationFeePercent;
    }

    public Date getCanceledAt() {
        return canceledAt;
    }

    public Date getCurrentPeriodEnd() {
        return currentPeriodEnd;
    }

    public Date getCurrentPeriodStart() {
        return currentPeriodStart;
    }

    public DiscountResponse getDiscount() {
        return discount;
    }

    public Date getEndedAt() {
        return endedAt;
    }

    public Date getTrialEnd() {
        return trialEnd;
    }

    public Date getTrialStart() {
        return trialStart;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public boolean isLivemode() {
        return livemode;
    }

    public double getTaxPercent() {
        return taxPercent;
    }
}
