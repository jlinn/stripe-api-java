package net.joelinn.stripe.response.customers;

import net.joelinn.stripe.response.cards.ListCardsResponse;
import net.joelinn.stripe.response.discounts.DiscountResponse;
import net.joelinn.stripe.response.subscriptions.ListSubscriptionsResponse;

import java.util.Date;
import java.util.Map;

/**
 * User: Joe Linn
 * Date: 5/21/2014
 * Time: 4:02 PM
 */
public class CustomerResponse {
    protected String id;

    protected String object;

    protected boolean livemode;

    protected ListCardsResponse sources;

    protected Date created;

    protected int accountBalance;

    protected String currency;

    protected String defaultSource;

    protected Shipping shipping;

    public Shipping getShipping() {
        return shipping;
    }

    public String getDefaultSource() {
        return defaultSource;
    }

    public CustomerResponse setDefaultSource(String defaultSource) {
        this.defaultSource = defaultSource;
        return this;
    }

    protected boolean delinquent;

    protected String description;

    protected DiscountResponse discount;

    protected String email;

    protected Map<String, Object> metadata;

    protected ListSubscriptionsResponse subscriptions;

    public String getId() {
        return id;
    }

    public String getObject() {
        return object;
    }

    public boolean isLivemode() {
        return livemode;
    }

    public ListCardsResponse getSources() {
        return sources;
    }

    public Date getCreated() {
        return created;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public String getCurrency() {
        return currency;
    }

    public boolean isDelinquent() {
        return delinquent;
    }

    public String getDescription() {
        return description;
    }

    public DiscountResponse getDiscount() {
        return discount;
    }

    public String getEmail() {
        return email;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public ListSubscriptionsResponse getSubscriptions() {
        return subscriptions;
    }
}
