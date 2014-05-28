package net.joelinn.stripe.request.tokens;

import net.joelinn.stripe.request.cards.CreateCardRequest;

/**
 * User: Joe Linn
 * Date: 5/26/2014
 * Time: 12:14 AM
 */
public class CreateCardTokenRequest extends CreateTokenRequest{
    protected CreateCardRequest card;
    
    protected String customer;

    public CreateCardTokenRequest setCard(CreateCardRequest card) {
        this.card = card;
        return this;
    }

    public CreateCardTokenRequest setCustomer(String customer) {
        this.customer = customer;
        return this;
    }
}
