package net.joelinn.stripe.response.charges;

import net.joelinn.stripe.response.cards.CardResponse;
import net.joelinn.stripe.response.customers.Shipping;
import net.joelinn.stripe.response.disputes.DisputeResponse;
import net.joelinn.stripe.response.outcome.OutcomeResponse;
import net.joelinn.stripe.response.refunds.ListRefundsResponse;

import java.util.Date;
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

    protected ListRefundsResponse refunds;

    protected int amountRefunded;

    protected String balanceTransaction;

    protected String customer;

    protected String description;

    protected String destination;

    protected DisputeResponse dispute;

    protected String failureCode;

    protected String failureMessage;

    protected String invoice;

    protected String order;

    protected Map<String, Object> fraudDetails;

    protected Map<String, Object> metadata;

    protected String statementDescription;

    protected String statementDescriptor;

    protected String receiptEmail;

    protected String receiptNumber;

    protected String application;

    protected String review;

    protected String status;

    protected String sourceTransfer;

    protected String transferGroup;

    protected Map<String, Object> source;

    protected float applicationFee;

    protected OutcomeResponse outcome;

    protected Shipping shipping;

    public String getApplication() {
        return application;
    }

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

    public ListRefundsResponse getRefunds() {
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

    public String getDestination() {
        return destination;
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

    public String getOrder() {
        return order;
    }

    public Map<String, Object> getFraudDetails() {
        return fraudDetails;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public String getStatementDescription() {
        return statementDescription;
    }

    public String getStatementDescriptor() {
        return statementDescriptor;
    }

    public DisputeResponse getDispute() {
        return dispute;
    }

    public String getReceiptEmail() {
        return receiptEmail;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public String getReview() {
        return review;
    }

    public String getStatus() {
        return status;
    }

    public Map<String, Object> getSource() {
        return source;
    }

    public String getSourceTransfer() {
        return sourceTransfer;
    }

    public String getTransferGroup() {
        return transferGroup;
    }

    public float getApplicationFee() {
        return applicationFee;
    }

    public OutcomeResponse getOutcome() {
        return outcome;
    }

    public Shipping getShipping() {
        return shipping;
    }
}
