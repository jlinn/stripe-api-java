package net.joelinn.stripe.response.balance;

import net.joelinn.stripe.response.transfers.ListTransfersResponse;
import net.joelinn.stripe.response.transfers.TransferResponse;

import java.util.Date;
import java.util.List;

/**
 * User: Joe Linn
 * Date: 5/22/2014
 * Time: 2:50 PM
 */
public class BalanceTransactionResponse {
    protected String id;

    protected String object;

    protected int amount;

    protected Date availableOn;

    protected Date created;

    protected String currency;

    protected int fee;

    protected List<FeeDetailsResponse> feeDetails;

    protected ListTransfersResponse sourcedTransfers;

    protected int net;

    protected String type;

    protected String status;

    protected String description;

    protected String source;

    public ListTransfersResponse getSourcedTransfers() {
        return sourcedTransfers;
    }

    public String getId() {
        return id;
    }

    public String getObject() {
        return object;
    }

    public int getAmount() {
        return amount;
    }

    public Date getAvailableOn() {
        return availableOn;
    }

    public Date getCreated() {
        return created;
    }

    public String getCurrency() {
        return currency;
    }

    public int getFee() {
        return fee;
    }

    public List<FeeDetailsResponse> getFeeDetails() {
        return feeDetails;
    }

    public int getNet() {
        return net;
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public String getSource() {
        return source;
    }

    public String getType() {
        return type;
    }
}
