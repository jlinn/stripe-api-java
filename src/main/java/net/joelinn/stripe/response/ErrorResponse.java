package net.joelinn.stripe.response;

/**
 * User: Joe Linn
 * Date: 5/22/2014
 * Time: 12:37 PM
 */
public class ErrorResponse {
    protected String type;

    protected String message;

    protected String code;

    protected String param;

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    public String getParam() {
        return param;
    }
}
