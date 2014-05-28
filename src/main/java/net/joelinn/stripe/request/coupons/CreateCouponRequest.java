package net.joelinn.stripe.request.coupons;

import net.joelinn.stripe.request.Request;

import java.util.Date;
import java.util.Map;

/**
 * User: Joe Linn
 * Date: 5/23/2014
 * Time: 12:50 PM
 */
public class CreateCouponRequest extends Request{
    protected String id;

    protected String duration;

    protected Integer amountOff;

    protected String currency;

    protected Integer durationInMonths;

    protected Integer maxRedemptions;

    protected Map<String, Object> metadata;

    protected Integer percentOff;

    protected Date redeemBy;

    public CreateCouponRequest(String duration) {
        this.duration = duration;
    }

    public CreateCouponRequest setAmountOff(Integer amountOff) {
        this.amountOff = amountOff;
        return this;
    }

    public CreateCouponRequest setId(String id) {
        this.id = id;
        return this;
    }

    public CreateCouponRequest setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public CreateCouponRequest setDurationInMonths(Integer durationInMonths) {
        this.durationInMonths = durationInMonths;
        return this;
    }

    public CreateCouponRequest setMaxRedemptions(Integer maxRedemptions) {
        this.maxRedemptions = maxRedemptions;
        return this;
    }

    public CreateCouponRequest setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
        return this;
    }

    public CreateCouponRequest setPercentOff(Integer percentOff) {
        this.percentOff = percentOff;
        return this;
    }

    public CreateCouponRequest setRedeemBy(Date redeemBy) {
        this.redeemBy = redeemBy;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getDuration() {
        return duration;
    }

    public Integer getAmountOff() {
        return amountOff;
    }

    public String getCurrency() {
        return currency;
    }

    public Integer getDurationInMonths() {
        return durationInMonths;
    }

    public Integer getMaxRedemptions() {
        return maxRedemptions;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public Integer getPercentOff() {
        return percentOff;
    }

    public Date getRedeemBy() {
        return redeemBy;
    }
}
