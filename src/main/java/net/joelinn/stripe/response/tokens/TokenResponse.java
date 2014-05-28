package net.joelinn.stripe.response.tokens;

import net.joelinn.stripe.response.cards.CardResponse;
import net.joelinn.stripe.response.recipients.BankAccountResponse;

import java.util.Date;

/**
 * User: Joe Linn
 * Date: 5/26/2014
 * Time: 12:16 AM
 */
public class TokenResponse {
    protected String id;

    protected String object;

    protected boolean livemode;

    protected Date created;

    protected String type;

    protected boolean used;

    protected BankAccountResponse bankAccount;

    protected CardResponse card;

    public String getId() {
        return id;
    }

    public String getObject() {
        return object;
    }

    public boolean isLivemode() {
        return livemode;
    }

    public Date getCreated() {
        return created;
    }

    public boolean isUsed() {
        return used;
    }

    public BankAccountResponse getBankAccount() {
        return bankAccount;
    }

    public CardResponse getCard() {
        return card;
    }

    public String getType() {
        return type;
    }
}
