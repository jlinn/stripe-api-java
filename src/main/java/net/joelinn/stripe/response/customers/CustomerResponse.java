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

    protected ListCardsResponse cards;

    protected Date created;

    protected int accountBalance;

    protected String currency;

    protected String defaultCard;

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

    public ListCardsResponse getCards() {
        return cards;
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

    public String getDefaultCard() {
        return defaultCard;
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
