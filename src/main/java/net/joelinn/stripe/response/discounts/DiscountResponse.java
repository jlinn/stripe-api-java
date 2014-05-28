package net.joelinn.stripe.response.discounts;

import net.joelinn.stripe.response.coupons.CouponResponse;

/**
 * User: Joe Linn
 * Date: 5/21/2014
 * Time: 4:08 PM
 */
public class DiscountResponse {
    protected String object;

    protected CouponResponse coupon;

    protected String customer;

    protected long start;   //TODO: deserialize to Date

    protected long end;     //TODO: deserialize to Date

    protected String subscription;

    public String getObject() {
        return object;
    }

    public CouponResponse getCoupon() {
        return coupon;
    }

    public String getCustomer() {
        return customer;
    }

    public long getStart() {
        return start;
    }

    public long getEnd() {
        return end;
    }

    public String getSubscription() {
        return subscription;
    }
}
