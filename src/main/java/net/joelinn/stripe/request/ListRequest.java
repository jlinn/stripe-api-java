package net.joelinn.stripe.request;

import java.util.Date;

/**
 * User: Joe Linn
 * Date: 5/23/2014
 * Time: 2:46 PM
 */
@SuppressWarnings("unchecked")
public class ListRequest<T extends ListRequest> extends Request{
    protected Object created;

    protected String endingBefore;

    protected Integer limit;

    protected String startingAfter;

    public T setCreated(Date created){
        this.created = created;
        return (T) this;
    }

    public T setCreated(CreatedRequest request){
        this.created = request;
        return (T) this;
    }

    public T setEndingBefore(String endingBefore) {
        this.endingBefore = endingBefore;
        return (T) this;
    }

    public T setLimit(Integer limit) {
        this.limit = limit;
        return (T) this;
    }

    public T setStartingAfter(String startingAfter) {
        this.startingAfter = startingAfter;
        return (T) this;
    }
}
