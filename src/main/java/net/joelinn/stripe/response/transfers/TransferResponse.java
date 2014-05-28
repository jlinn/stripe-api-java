package net.joelinn.stripe.response.transfers;

import net.joelinn.stripe.response.recipients.BankAccountResponse;

import java.util.Date;
import java.util.Map;

/**
 * User: Joe Linn
 * Date: 5/26/2014
 * Time: 9:05 PM
 */
public class TransferResponse {
    protected String id;

    protected String object;

    protected boolean livemode;

    protected int amount;

    protected Date created;

    protected String currency;

    protected Date date;

    protected String status;

    protected String type;

    protected BankAccountResponse bankAccount;

    protected String balanceTransaction;

    protected String description;

    protected Map<String, Object> metadata;

    protected String recipient;

    protected String statementDescription;

    public String getId() {
        return id;
    }

    public String getObject() {
        return object;
    }

    public boolean isLivemode() {
        return livemode;
    }

    public int getAmount() {
        return amount;
    }

    public Date getCreated() {
        return created;
    }

    public String getCurrency() {
        return currency;
    }

    public Date getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public BankAccountResponse getBankAccount() {
        return bankAccount;
    }

    public String getBalanceTransaction() {
        return balanceTransaction;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getStatementDescription() {
        return statementDescription;
    }

    public String getType() {
        return type;
    }
}
