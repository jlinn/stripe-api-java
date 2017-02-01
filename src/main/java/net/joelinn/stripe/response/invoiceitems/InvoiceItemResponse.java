package net.joelinn.stripe.response.invoiceitems;

import net.joelinn.stripe.response.plans.ListPlansResponse;
import net.joelinn.stripe.response.plans.PlanResponse;

import java.util.Date;
import java.util.Map;

/**
 * User: Joe Linn
 * Date: 5/23/2014
 * Time: 2:37 PM
 */
public class InvoiceItemResponse {
    protected String id;

    protected String object;

    protected int amount;

    protected boolean livemode;

    protected String currency;

    protected String customer;

    protected Date date;

    protected boolean proration;

    protected boolean discountable;

    protected String description;

    protected String invoice;

    protected Map<String, Object> metadata;

    protected Map<String, Object> period;

    protected Map<String, Object> source;

    protected String subscription;

    protected ListPlansResponse items;

    protected PlanResponse plan;

    protected int quantity;

    public int getQuantity() {
        return quantity;
    }

    public PlanResponse getPlan() {
        return plan;
    }

    public ListPlansResponse getItems() {
        return items;
    }

    public Map<String, Object> getPeriod() {
        return period;
    }

    public Map<String, Object> getSource() {
        return source;
    }

    public String getId() {
        return id;
    }

    public String getObject() {
        return object;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isLivemode() {
        return livemode;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCustomer() {
        return customer;
    }

    public Date getDate() {
        return date;
    }

    public boolean isProration() {
        return proration;
    }

    public String getDescription() {
        return description;
    }

    public String getInvoice() {
        return invoice;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public String getSubscription() {
        return subscription;
    }

    public boolean isDiscountable() {
        return discountable;
    }
}
