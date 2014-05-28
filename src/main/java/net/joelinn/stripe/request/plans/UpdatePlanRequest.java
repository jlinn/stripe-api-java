package net.joelinn.stripe.request.plans;

import net.joelinn.stripe.request.Request;

import java.util.Map;

/**
 * User: Joe Linn
 * Date: 5/25/2014
 * Time: 5:31 PM
 */
public class UpdatePlanRequest extends Request{
    protected String name;

    protected Map<String, Object> metadata;

    public UpdatePlanRequest setName(String name) {
        this.name = name;
        return this;
    }

    public UpdatePlanRequest setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
        return this;
    }
}
