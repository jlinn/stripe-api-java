package net.joelinn.stripe.request.refunds;

import net.joelinn.stripe.request.Request;

import java.util.Map;

/**
 * User: Joe Linn
 * Date: 7/28/2014
 * Time: 12:08 PM
 */
public class CreateRefundRequest extends Request{
    protected Integer amount;

    protected Boolean refundApplicationFee;

    protected Map<String, Object> metadata;

    public Integer getAmount() {
        return amount;
    }

    public CreateRefundRequest setAmount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public Boolean getRefundApplicationFee() {
        return refundApplicationFee;
    }

    public CreateRefundRequest setRefundApplicationFee(Boolean refundApplicationFee) {
        this.refundApplicationFee = refundApplicationFee;
        return this;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public CreateRefundRequest setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
        return this;
    }
}
