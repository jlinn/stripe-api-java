package net.joelinn.stripe.test.api;

import net.joelinn.stripe.api.Events;
import net.joelinn.stripe.request.events.ListEventsRequest;
import net.joelinn.stripe.response.events.EventResponse;
import net.joelinn.stripe.response.events.ListEventsResponse;
import net.joelinn.stripe.test.StripeTestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EventsTest extends StripeTestCase {
    protected Events events;

    @Before
    public void setUp(){
        events = new Events(client);
    }

    @Test
    public void testListEvents(){
        events.listEvents(new ListEventsRequest());

    }

    @Test
    public void testGetEvent(){
        ListEventsResponse list = events.listEvents(new ListEventsRequest());
        if(list.getData().size() > 0){
            String eventId = list.getData().get(0).getId();
            EventResponse event = events.getEvent(eventId);

            assertEquals(eventId, event.getId());
        }
    }
}