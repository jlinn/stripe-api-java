package net.joelinn.stripe.request.subscriptions;

import net.joelinn.stripe.request.Request;

/**
 * User: Joe Linn
 * Date: 5/25/2014
 * Time: 7:57 PM
 */
public class ListSubscriptionsRequest extends Request{
    protected String endingBefore;

    protected Integer limit;

    protected String startingAfter;

    public void setEndingBefore(String endingBefore) {
        this.endingBefore = endingBefore;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public void setStartingAfter(String startingAfter) {
        this.startingAfter = startingAfter;
    }
}
