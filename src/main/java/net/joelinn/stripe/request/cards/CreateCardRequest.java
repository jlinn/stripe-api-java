package net.joelinn.stripe.request.cards;

import javax.ws.rs.core.MultivaluedMap;

/**
 * User: Joe Linn
 * Date: 5/21/2014
 * Time: 3:48 PM
 */
public class CreateCardRequest extends UpdateCardRequest{
    protected String number;

    protected Short cvc;

    public CreateCardRequest(String number, short expMonth, short expYear) {
        this.number = number;
        this.expMonth = expMonth;
        this.expYear = expYear;
    }

    public CreateCardRequest(String number, int expMonth, int expYear){
        this(number, (short) expMonth, (short) expYear);
    }

    public CreateCardRequest setNumber(String number) {
        this.number = number;
        return this;
    }

    public CreateCardRequest setCvc(short cvc) {
        this.cvc = cvc;
        return this;
    }

    public CreateCardRequest setCvc(int cvc){
        return setCvc((short) cvc);
    }

    public String getNumber() {
        return number;
    }

    public Short getCvc() {
        return cvc;
    }

    @Override
    public MultivaluedMap<String, String> toRequest(){
        return toRequest(this, "card");
    }
}
