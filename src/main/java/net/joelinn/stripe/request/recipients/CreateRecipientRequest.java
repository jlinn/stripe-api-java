package net.joelinn.stripe.request.recipients;

/**
 * User: Joe Linn
 * Date: 5/25/2014
 * Time: 7:08 PM
 */
public class CreateRecipientRequest extends UpdateRecipientRequest<CreateRecipientRequest>{
    protected String type;

    public CreateRecipientRequest(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
