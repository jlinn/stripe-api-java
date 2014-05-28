package net.joelinn.stripe.request.invoices;

import net.joelinn.stripe.request.CreatedRequest;
import net.joelinn.stripe.request.Request;

import java.util.Date;

/**
 * User: Joe Linn
 * Date: 5/24/2014
 * Time: 7:13 PM
 */
@SuppressWarnings("unchecked")
public class ListInvoicesRequest<T extends ListInvoicesRequest> extends Request{
    protected String customer;
    
    protected Object date;
    
    protected String endingBefore;
    
    protected Integer limit;
    
    protected String startingAfter;

    public T setCustomer(String customer) {
        this.customer = customer;
        return (T) this;
    }
    
    public T setDate(Date date){
        this.date = date;
        return (T) this;
    }
    
    public T setDate(CreatedRequest date){
        this.date = date;
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
