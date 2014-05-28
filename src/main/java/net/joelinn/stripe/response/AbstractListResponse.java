package net.joelinn.stripe.response;

import java.util.List;

/**
 * User: Joe Linn
 * Date: 5/21/2014
 * Time: 4:05 PM
 */
abstract public class AbstractListResponse<T> {
    protected String object;

    protected String url;

    protected int totalCount;

    protected List<T> data;

    protected boolean hasMore;

    public String getObject() {
        return object;
    }

    public String getUrl() {
        return url;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public List<T> getData() {
        return data;
    }

    public boolean isHasMore() {
        return hasMore;
    }
}
