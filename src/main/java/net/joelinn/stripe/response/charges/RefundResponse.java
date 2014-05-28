package net.joelinn.stripe.response.charges;

import java.util.Date;

/**
 * User: Joe Linn
 * Date: 5/22/2014
 * Time: 2:25 PM
 */
public class RefundResponse {
    protected String object;

    protected int amount;

    protected Date created;

    protected String currency;

    protected String balanceTransaction;

    public String getObject() {
        return object;
    }

    public int getAmount() {
        return amount;
    }

    public Date getCreated() {
        return created;
    }

    public String getCurrency() {
        return currency;
    }

    public String getBalanceTransaction() {
        return balanceTransaction;
    }
}
