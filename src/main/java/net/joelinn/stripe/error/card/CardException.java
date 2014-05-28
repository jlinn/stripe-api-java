package net.joelinn.stripe.error.card;

import net.joelinn.stripe.error.StripeApiException;
import net.joelinn.stripe.response.ErrorResponse;

/**
 * User: Joe Linn
 * Date: 5/22/2014
 * Time: 3:13 PM
 */
abstract public class CardException extends StripeApiException{
    public CardException(ErrorResponse response, int code) {
        super(response, code);
    }

    public CardException(StripeApiException e){
        this(e.getResponse(), e.getCode());
    }
}
