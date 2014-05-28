package net.joelinn.stripe.response.invoiceitems;

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

    protected String description;

    protected String invoice;

    protected Map<String, Object> metadata;

    protected String subscription;

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
}
