package net.joelinn.stripe.api;

import net.joelinn.stripe.Client;
import net.joelinn.stripe.request.coupons.CreateCouponRequest;
import net.joelinn.stripe.response.DeleteResponse;
import net.joelinn.stripe.response.coupons.CouponResponse;

/**
 * User: Joe Linn
 * Date: 5/23/2014
 * Time: 12:54 PM
 */
public class Coupons extends AbstractApi{
    public Coupons(Client client) {
        super(client);
    }

    /**
     * Create a coupon
     * <a href="https://stripe.com/docs/api#create_coupon">https://stripe.com/docs/api#create_coupon</a>
     */
    public CouponResponse createCoupon(CreateCouponRequest request){
        return client.post(buildUrl(), CouponResponse.class, request.toRequest());
    }

    /**
     * Retrieve a coupon
     * <a href="https://stripe.com/docs/api#retrieve_coupon">https://stripe.com/docs/api#retrieve_coupon</a>
     * @param couponId the id of the coupon to retrieve
     */
    public CouponResponse getCoupon(String couponId){
        return client.get(buildUrl(couponId), CouponResponse.class);
    }

    /**
     * Delete a coupon
     * <a href="https://stripe.com/docs/api#delete_coupon">https://stripe.com/docs/api#delete_coupon</a>
     * @param couponId the id of the coupon to be deleted
     */
    public DeleteResponse deleteCoupon(String couponId){
        return client.delete(buildUrl(couponId), DeleteResponse.class);
    }

    protected String buildUrl(){
        return buildUrl(null);
    }

    protected String buildUrl(String couponId){
        String url = "coupons";
        if(couponId != null){
            url += "/" + couponId;
        }
        return url;
    }
}
