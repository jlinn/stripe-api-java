package net.joelinn.stripe.request.customers;

import java.util.Date;

/**
 * User: Joe Linn
 * Date: 5/21/2014
 * Time: 3:56 PM
 */
public class CreateCustomerRequest extends AbstractCustomerRequest<CreateCustomerRequest>{
    protected String plan;

    protected Integer quantity;

    protected Date trialEnd;

    public CreateCustomerRequest setPlan(String plan) {
        this.plan = plan;
        return this;
    }

    public CreateCustomerRequest setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public CreateCustomerRequest setTrialEnd(Date trialEnd) {
        this.trialEnd = trialEnd;
        return this;
    }

    public String getPlan() {
        return plan;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Date getTrialEnd() {
        return trialEnd;
    }
}
