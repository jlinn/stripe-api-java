package net.joelinn.stripe.error;

import net.joelinn.stripe.response.ErrorResponse;

/**
 * User: Joe Linn
 * Date: 5/22/2014
 * Time: 12:39 PM
 */
public class StripeApiException extends StripeException{
    protected ErrorResponse response;

    protected int code;

    public StripeApiException(ErrorResponse response, int code) {
        super(response.getMessage());
        this.response = response;
        this.code = code;
    }

    public ErrorResponse getResponse() {
        return response;
    }

    public int getCode() {
        return code;
    }
}
