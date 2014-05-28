package net.joelinn.stripe.response.balance;

import java.util.List;
import java.util.Map;

/**
 * User: Joe Linn
 * Date: 5/22/2014
 * Time: 2:48 PM
 */
public class BalanceResponse {
    protected String object;

    protected boolean livemode;

    protected List<Map<String, Object>> available;

    protected List<Map<String, Object>> pending;

    public String getObject() {
        return object;
    }

    public boolean isLivemode() {
        return livemode;
    }

    public List<Map<String, Object>> getAvailable() {
        return available;
    }

    public List<Map<String, Object>> getPending() {
        return pending;
    }
}
