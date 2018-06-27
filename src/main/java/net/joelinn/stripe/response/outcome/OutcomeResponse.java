package net.joelinn.stripe.response.outcome;

import net.joelinn.stripe.response.customers.Shipping;
import net.joelinn.stripe.response.refunds.ListRefundsResponse;

import java.util.Map;

/**
 * Created by veliko on 1/31/17.
 */
public class OutcomeResponse {
    protected String networkStatus;

    protected String reason;

    protected String riskLevel;

    protected Map<String, Object> rule;

    protected String sellerMessage;

    protected String type;

    protected boolean paid;

    protected String receiptEmail;

    protected String receiptNumber;

    protected boolean refunded;

    protected ListRefundsResponse refunds;

    protected String review;

    protected Shipping shipping;

    protected String sourceTransfer;

    protected String status;

    protected String transfer;

    public String getNetworkStatus() {
        return networkStatus;
    }

    public String getReason() {
        return reason;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public Map<String, Object> getRule() {
        return rule;
    }

    public String getSellerMessage() {
        return sellerMessage;
    }

    public String getType() {
        return type;
    }

    public boolean isPaid() {
        return paid;
    }

    public String getReceiptEmail() {
        return receiptEmail;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public boolean isRefunded() {
        return refunded;
    }

    public ListRefundsResponse getRefunds() {
        return refunds;
    }

    public String getReview() {
        return review;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public String getSourceTransfer() {
        return sourceTransfer;
    }

    public String getStatus() {
        return status;
    }

    public String getTransfer() {
        return transfer;
    }
}
