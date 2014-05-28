package net.joelinn.stripe.request.transfers;

import net.joelinn.stripe.request.CreatedRequest;
import net.joelinn.stripe.request.ListRequest;

import java.util.Date;

/**
 * User: Joe Linn
 * Date: 5/26/2014
 * Time: 9:14 PM
 */
public class ListTransfersRequest extends ListRequest<ListTransfersRequest>{
    protected Object date;
    
    protected String recipient;
    
    protected String status;
    
    protected ListTransfersRequest setDate(Date date){
        this.date = date;
        return this;
    }
    
    protected ListTransfersRequest setDate(CreatedRequest request){
        this.date = request;
        return this;
    }

    public ListTransfersRequest setRecipient(String recipient) {
        this.recipient = recipient;
        return this;
    }

    public ListTransfersRequest setStatus(String status) {
        this.status = status;
        return this;
    }
}
