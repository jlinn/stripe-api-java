package net.joelinn.stripe.response.invoices;

import net.joelinn.stripe.response.disputes.DisputeResponse;

import java.util.Date;
import java.util.Map;

/**
 * User: Joe Linn
 * Date: 5/24/2014
 * Time: 3:51 PM
 */
public class InvoiceResponse {
    protected String id;

    protected String object;

    protected boolean livemode;

    protected int amountDue;

    protected int attemptCount;

    protected boolean attempted;

    protected boolean closed;

    protected String currency;

    protected String customer;

    protected String receiptNumber;

    protected Date date;

    protected boolean forgiven;

    protected ListLineItemsResponse lines;

    protected boolean paid;

    protected Date periodStart;

    protected Date periodEnd;

    protected int startingBalance;

    protected int subtotal;

    protected int total;

    protected int tax;

    protected int applicationFee;

    protected double taxPercent;

    protected String charge;

    protected String description;

    protected DisputeResponse discount;

    protected int endingBalance;

    protected Date nextPaymentAttempt;

    protected String subscription;

    protected Date webhooksDeliveredAt;

    protected Map<String, Object> metadata;

    protected String statementDescription;

    protected String statementDescriptor;

    public String getId() {
        return id;
    }

    public String getObject() {
        return object;
    }

    public boolean isLivemode() {
        return livemode;
    }

    public int getAmountDue() {
        return amountDue;
    }

    public int getAttemptCount() {
        return attemptCount;
    }

    public boolean isAttempted() {
        return attempted;
    }

    public boolean isClosed() {
        return closed;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCustomer() {
        return customer;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public Date getDate() {
        return date;
    }

    public ListLineItemsResponse getLines() {
        return lines;
    }

    public boolean isPaid() {
        return paid;
    }

    public Date getPeriodStart() {
        return periodStart;
    }

    public Date getPeriodEnd() {
        return periodEnd;
    }

    public int getStartingBalance() {
        return startingBalance;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public int getTotal() {
        return total;
    }

    public int getTax() {
        return tax;
    }

    public int getApplicationFee() {
        return applicationFee;
    }

    public String getCharge() {
        return charge;
    }

    public String getDescription() {
        return description;
    }

    public DisputeResponse getDiscount() {
        return discount;
    }

    public int getEndingBalance() {
        return endingBalance;
    }

    public Date getNextPaymentAttempt() {
        return nextPaymentAttempt;
    }

    public String getSubscription() {
        return subscription;
    }

    public Date getWebhooksDeliveredAt() {
        return webhooksDeliveredAt;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public String getStatementDescription() {
        return statementDescription;
    }

    public boolean isForgiven() {
        return forgiven;
    }

    public String getStatementDescriptor() {
        return statementDescriptor;
    }

    public double getTaxPercent() {
        return taxPercent;
    }
}
