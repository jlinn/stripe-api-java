package net.joelinn.stripe.error.card;

import net.joelinn.stripe.error.StripeApiException;
import net.joelinn.stripe.response.ErrorResponse;

/**
 * User: Joe Linn
 * Date: 5/22/2014
 * Time: 3:15 PM
 */
public class InvalidCvcException extends CardException{
    public InvalidCvcException(ErrorResponse response, int code) {
        super(response, code);
    }

    public InvalidCvcException(StripeApiException e) {
        super(e);
    }
}
