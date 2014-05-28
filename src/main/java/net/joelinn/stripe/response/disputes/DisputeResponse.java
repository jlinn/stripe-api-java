package net.joelinn.stripe.response.disputes;

import java.util.Date;

/**
 * User: Joe Linn
 * Date: 5/23/2014
 * Time: 12:38 PM
 */
public class DisputeResponse {
    protected String object;

    protected boolean livemode;

    protected int amount;

    protected String charge;

    protected Date created;

    protected String currency;

    protected String reason;

    protected String status;

    protected String balanceTransaction;

    protected String evidence;

    protected Date evidenceDueBy;

    public String getObject() {
        return object;
    }

    public boolean isLivemode() {
        return livemode;
    }

    public int getAmount() {
        return amount;
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

    public String getReason() {
        return reason;
    }

    public String getStatus() {
        return status;
    }

    public String getBalanceTransaction() {
        return balanceTransaction;
    }

    public String getEvidence() {
        return evidence;
    }

    public Date getEvidenceDueBy() {
        return evidenceDueBy;
    }
}
