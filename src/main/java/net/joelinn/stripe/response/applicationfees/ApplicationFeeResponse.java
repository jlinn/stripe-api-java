package net.joelinn.stripe.response.applicationfees;

import net.joelinn.stripe.response.charges.RefundResponse;

import java.util.Date;
import java.util.List;

/**
 * User: Joe Linn
 * Date: 5/22/2014
 * Time: 2:23 PM
 */
public class ApplicationFeeResponse {
    protected String id;

    protected String object;

    protected boolean livemode;

    protected String account;

    protected int amount;

    protected String application;

    protected String balanceTransaction;

    protected String charge;

    protected Date created;

    protected String currency;

    protected boolean refunded;

    protected List<RefundResponse> refunds;

    protected int amountRefunded;

    public String getId() {
        return id;
    }

    public String getObject() {
        return object;
    }

    public boolean isLivemode() {
        return livemode;
    }

    public String getAccount() {
        return account;
    }

    public int getAmount() {
        return amount;
    }

    public String getApplication() {
        return application;
    }

    public String getBalanceTransaction() {
        return balanceTransaction;
    }

    public String getCharge() {
        return charge;
    }

    public Date getCreated() {
        return created;
    }

    public String getCurrency() {
        return currency;
    }

    public boolean isRefunded() {
        return refunded;
    }

    public List<RefundResponse> getRefunds() {
        return refunds;
    }

    public int getAmountRefunded() {
        return amountRefunded;
    }
}
