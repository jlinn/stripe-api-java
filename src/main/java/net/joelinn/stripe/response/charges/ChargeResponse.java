package net.joelinn.stripe.response.charges;

import net.joelinn.stripe.response.cards.CardResponse;
import net.joelinn.stripe.response.disputes.DisputeResponse;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * User: Joe Linn
 * Date: 5/23/2014
 * Time: 12:00 PM
 */
public class ChargeResponse {
    protected String id;

    protected String object;

    protected boolean livemode;

    protected int amount;

    protected boolean captured;

    protected CardResponse card;

    protected Date created;

    protected String currency;

    protected boolean paid;

    protected boolean refunded;

    protected List<RefundResponse> refunds;

    protected int amountRefunded;

    protected String balanceTransaction;

    protected String customer;

    protected String description;

    protected DisputeResponse dispute;

    protected String failureCode;

    protected String failureMessage;

    protected String invoice;

    protected Map<String, Object> metadata;

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

    public boolean isCaptured() {
        return captured;
    }

    public CardResponse getCard() {
        return card;
    }

    public Date getCreated() {
        return created;
    }

    public String getCurrency() {
        return currency;
    }

    public boolean isPaid() {
        return paid;
    }

    public boolean isRefunded() {
        return refunded;
    }

    public List<RefundResponse> getRefunds() {
        return refunds;
    }

    public int getAmountRefunded() {
        return amountRefunded;
    }

    public String getBalanceTransaction() {
        return balanceTransaction;
    }

    public String getCustomer() {
        return customer;
    }

    public String getDescription() {
        return description;
    }

    public String getFailureCode() {
        return failureCode;
    }

    public String getFailureMessage() {
        return failureMessage;
    }

    public String getInvoice() {
        return invoice;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public String getStatementDescription() {
        return statementDescription;
    }

    public DisputeResponse getDispute() {
        return dispute;
    }
}
