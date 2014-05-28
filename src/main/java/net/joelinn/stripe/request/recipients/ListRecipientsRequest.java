package net.joelinn.stripe.request.recipients;

import net.joelinn.stripe.request.Request;

/**
 * User: Joe Linn
 * Date: 5/25/2014
 * Time: 7:23 PM
 */
public class ListRecipientsRequest extends Request{
    protected String endingBefore;

    protected Integer limit;

    protected String startingAfter;

    protected Boolean verified;

    public void setEndingBefore(String endingBefore) {
        this.endingBefore = endingBefore;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public void setStartingAfter(String startingAfter) {
        this.startingAfter = startingAfter;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }
}
