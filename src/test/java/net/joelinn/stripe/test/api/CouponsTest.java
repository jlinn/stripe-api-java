package net.joelinn.stripe.test.api;

import net.joelinn.stripe.api.Coupons;
import net.joelinn.stripe.request.coupons.CreateCouponRequest;
import net.joelinn.stripe.response.DeleteResponse;
import net.joelinn.stripe.response.coupons.CouponResponse;
import net.joelinn.stripe.test.StripeTestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CouponsTest extends StripeTestCase {
    protected Coupons coupons;

    @Before
    public void setUp(){
        coupons = new Coupons(client);
    }

    @Test
    public void testCreateCoupon(){
        String duration = "once";
        int percentOff = 50;
        CreateCouponRequest request = new CreateCouponRequest(duration).setPercentOff(percentOff);

        CouponResponse response = coupons.createCoupon(request);

        assertEquals(duration, response.getDuration());
        assertEquals(percentOff, response.getPercentOff());

        client.delete("coupons/" + response.getId(), DeleteResponse.class);
    }
}