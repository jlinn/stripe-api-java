package net.joelinn.stripe.api;

import net.joelinn.stripe.Client;
import net.joelinn.stripe.request.events.ListEventsRequest;
import net.joelinn.stripe.response.events.EventResponse;
import net.joelinn.stripe.response.events.ListEventsResponse;

/**
 * User: Joe Linn
 * Date: 5/24/2014
 * Time: 3:30 PM
 */
public class Events extends AbstractApi{
    public Events(Client client) {
        super(client);
    }

    /**
     * Retrieve an event
     * <a href="https://stripe.com/docs/api#retrieve_event">https://stripe.com/docs/api#retrieve_event</a>
     * @param eventId the id of the event to retrieve
     */
    public EventResponse getEvent(String eventId){
        return client.get(buildUrl(eventId), EventResponse.class);
    }

    /**
     * Retrieve multiple events
     * <a href="https://stripe.com/docs/api#list_events">https://stripe.com/docs/api#list_events</a>
     */
    public ListEventsResponse listEvents(ListEventsRequest request){
        return client.get(buildUrl(), ListEventsResponse.class, null, request.toRequest());
    }

    protected String buildUrl(){
        return buildUrl(null);
    }

    protected String buildUrl(String eventId){
        String url = "events";
        if(eventId != null){
            url += "/" + eventId;
        }
        return url;
    }
}
