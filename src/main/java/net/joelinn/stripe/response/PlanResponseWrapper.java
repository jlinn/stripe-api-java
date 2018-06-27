package net.joelinn.stripe.response;

import net.joelinn.stripe.response.plans.PlanResponse;

import java.util.Date;

/**
 * Created by veliko on 2/1/17.
 */
public class PlanResponseWrapper {
    protected String id;

    protected String object;

    protected Date created;

    protected PlanResponse plan;

    protected int quantity;

    public String getId() {
        return id;
    }

    public String getObject() {
        return object;
    }

    public Date getCreated() {
        return created;
    }

    public PlanResponse getPlan() {
        return plan;
    }

    public int getQuantity() {
        return quantity;
    }
}
