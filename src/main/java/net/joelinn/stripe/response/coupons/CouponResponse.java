package net.joelinn.stripe.response.coupons;

import java.util.Map;

/**
 * User: Joe Linn
 * Date: 5/21/2014
 * Time: 4:08 PM
 */
public class CouponResponse {
    protected String id;

    protected String object;

    protected boolean livemode;

    protected long created; //TODO: deserialize to Date

    protected String duration;

    protected int amountOff;

    protected String currency;

    protected short durationInMonths;

    protected int maxRedemptions;

    protected Map<String, Object> metadata;

    protected short percentOff;

    protected int redeemBy;

    protected int timesRedeemed;

    protected boolean valid;

    public String getId() {
        return id;
    }

    public String getObject() {
        return object;
    }

    public boolean isLivemode() {
        return livemode;
    }

    public long getCreated() {
        return created;
    }

    public String getDuration() {
        return duration;
    }

    public int getAmountOff() {
        return amountOff;
    }

    public String getCurrency() {
        return currency;
    }

    public short getDurationInMonths() {
        return durationInMonths;
    }

    public int getMaxRedemptions() {
        return maxRedemptions;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public short getPercentOff() {
        return percentOff;
    }

    public int getRedeemBy() {
        return redeemBy;
    }

    public int getTimesRedeemed() {
        return timesRedeemed;
    }

    public boolean isValid() {
        return valid;
    }
}
