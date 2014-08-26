package net.joelinn.stripe.response.events;

import net.joelinn.stripe.json.StripeObjectDeserializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import java.util.Date;
import java.util.Map;

/**
 * User: Joe Linn
 * Date: 5/24/2014
 * Time: 3:28 PM
 */
public class EventResponse {
    protected String id;

    protected String object;

    protected boolean livemode;

    protected Date created;

    @JsonDeserialize(using = StripeObjectDeserializer.class)
    protected Map<String, Object> data;

    protected int pendingWebhooks;

    protected String type;

    protected String request;

    public String getId() {
        return id;
    }

    public String getObject() {
        return object;
    }

    public boolean isLivemode() {
        return livemode;
    }

    public Date getCreated() {
        return created;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public int getPendingWebhooks() {
        return pendingWebhooks;
    }

    public String getType() {
        return type;
    }

    public String getRequest() {
        return request;
    }
}
