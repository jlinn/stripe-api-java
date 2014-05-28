package net.joelinn.stripe.request.events;

import net.joelinn.stripe.request.ListRequest;

/**
 * User: Joe Linn
 * Date: 5/24/2014
 * Time: 3:33 PM
 */
public class ListEventsRequest extends ListRequest<ListEventsRequest>{
    protected String type;

    public ListEventsRequest setType(String type) {
        this.type = type;
        return this;
    }
}
