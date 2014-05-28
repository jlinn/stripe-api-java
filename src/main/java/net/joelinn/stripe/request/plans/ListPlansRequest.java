package net.joelinn.stripe.request.plans;

import net.joelinn.stripe.request.Request;

/**
 * User: Joe Linn
 * Date: 5/25/2014
 * Time: 5:35 PM
 */
public class ListPlansRequest extends Request{
    protected String endingBefore;
    
    protected Integer limit;
    
    protected String startingAfter;

    public ListPlansRequest setEndingBefore(String endingBefore) {
        this.endingBefore = endingBefore;
        return this;
    }

    public ListPlansRequest setLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public ListPlansRequest setStartingAfter(String startingAfter) {
        this.startingAfter = startingAfter;
        return this;
    }
}
