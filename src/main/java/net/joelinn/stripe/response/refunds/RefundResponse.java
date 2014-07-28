package net.joelinn.stripe.response.refunds;

import java.util.Date;
import java.util.Map;

/**
 * User: Joe Linn
 * Date: 7/28/2014
 * Time: 11:31 AM
 */
public class RefundResponse {
    protected String id;

    protected String object;

    protected int amount;

    protected Date created;

    protected String currency;

    protected String balanceTransaction;

    protected String charge;

    protected Map<String, Object> metadata;

    public String getId() {
        return id;
    }

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

    public String getCharge() {
        return charge;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }
}
