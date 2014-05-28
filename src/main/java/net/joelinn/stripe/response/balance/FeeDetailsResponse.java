package net.joelinn.stripe.response.balance;

/**
 * User: Joe Linn
 * Date: 5/22/2014
 * Time: 2:51 PM
 */
public class FeeDetailsResponse {
    protected int amount;

    protected String currency;

    protected String type;

    protected String application;

    protected String description;

    public int getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getType() {
        return type;
    }

    public String getApplication() {
        return application;
    }

    public String getDescription() {
        return description;
    }
}
