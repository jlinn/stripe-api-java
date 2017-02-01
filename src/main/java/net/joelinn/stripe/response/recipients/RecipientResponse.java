package net.joelinn.stripe.response.recipients;

import net.joelinn.stripe.response.cards.ListCardsResponse;

import java.util.Date;
import java.util.Map;

/**
 * User: Joe Linn
 * Date: 5/25/2014
 * Time: 7:12 PM
 */
public class RecipientResponse {
    protected String id;

    protected String object;
    
    protected boolean livemode;

    protected Date created;

    protected String type;

    protected BankAccountResponse activeAccount;

    protected String description;

    protected String email;

    protected Map<String, Object> metadata;

    protected ListCardsResponse cards;

    protected String name;

    protected boolean verified;

    protected String defaultCard;

    protected String migratedTo;

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

    public String getType() {
        return type;
    }

    public BankAccountResponse getActiveAccount() {
        return activeAccount;
    }

    public String getDescription() {
        return description;
    }

    public String getEmail() {
        return email;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public String getName() {
        return name;
    }

    public ListCardsResponse getCards() {
        return cards;
    }

    public boolean isVerified() {
        return verified;
    }

    public String getDefaultCard() {
        return defaultCard;
    }

    public String getMigratedTo() {
        return migratedTo;
    }
}
