package net.joelinn.stripe.test.api;

import net.joelinn.stripe.api.Events;
import net.joelinn.stripe.request.CreatedRequest;
import net.joelinn.stripe.request.events.ListEventsRequest;
import net.joelinn.stripe.response.events.EventResponse;
import net.joelinn.stripe.response.events.ListEventsResponse;
import net.joelinn.stripe.test.StripeTestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class EventsTest extends StripeTestCase {
    protected Events events;

    @Before
    public void setUp(){
        events = new Events(client);
    }

    @Test
    public void testListEvents(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        events.listEvents(new ListEventsRequest().setCreated(new CreatedRequest().setGte(calendar.getTime())));
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