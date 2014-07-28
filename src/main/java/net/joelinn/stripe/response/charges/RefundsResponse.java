package net.joelinn.stripe.response.charges;

import net.joelinn.stripe.response.refunds.RefundResponse;

import java.util.List;

/**
 * User: Joe Linn
 * Date: 5/22/2014
 * Time: 2:25 PM
 */
public class RefundsResponse {
    protected String object;

    protected int totalCount;

    protected boolean hasMore;

    protected String url;

    protected List<RefundResponse> data;

    public String getObject() {
        return object;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public boolean getHasMore() {
        return hasMore;
    }

    public String getUrl() {
        return url;
    }

    public List<RefundResponse> getData() {
        return data;
    }
}
