package net.joelinn.stripe.request.customers;

/**
 * User: Joe Linn
 * Date: 5/22/2014
 * Time: 11:41 AM
 */
public class UpdateCustomerRequest extends AbstractCustomerRequest<UpdateCustomerRequest>{
    protected String defaultCard;

    public String getDefaultCard() {
        return defaultCard;
    }

    public void setDefaultCard(String defaultCard) {
        this.defaultCard = defaultCard;
    }
}
