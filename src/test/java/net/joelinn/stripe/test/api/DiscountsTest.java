package net.joelinn.stripe.test.api;

import net.joelinn.stripe.api.*;
import net.joelinn.stripe.request.cards.CreateCardRequest;
import net.joelinn.stripe.request.coupons.CreateCouponRequest;
import net.joelinn.stripe.request.customers.CreateCustomerRequest;
import net.joelinn.stripe.request.customers.UpdateCustomerRequest;
import net.joelinn.stripe.request.plans.CreatePlanRequest;
import net.joelinn.stripe.request.subscriptions.CreateSubscriptionRequest;
import net.joelinn.stripe.response.DeleteResponse;
import net.joelinn.stripe.response.customers.CustomerResponse;
import net.joelinn.stripe.response.subscriptions.SubscriptionResponse;
import net.joelinn.stripe.test.StripeTestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * User: Joe Linn
 * Date: 5/26/2014
 * Time: 9:28 PM
 */
public class DiscountsTest extends StripeTestCase{
    protected Discounts discounts;

    protected Customers customers;

    protected Subscriptions subscriptions;

    protected Plans plans;

    protected Coupons coupons;

    protected String customerId;

    protected String couponId;

    protected String planId;

    @Before
    public void setUp(){
        discounts = new Discounts(client);
        customers = new Customers(client);
        subscriptions = new Subscriptions(client);
        plans = new Plans(client);
        coupons = new Coupons(client);

        couponId = coupons.createCoupon(new CreateCouponRequest("forever").setPercentOff(50)).getId();
        customerId = customers.createCustomer(new CreateCustomerRequest().setCard(new CreateCardRequest(VISA_1, 1, 2020))).getId();
        planId = plans.createPlan(new CreatePlanRequest("test_plan" + Math.random(), 350, "usd", "month", "test plan")).getId();
    }

    @After
    public void tearDown(){
        customers.deleteCustomer(customerId);
        coupons.deleteCoupon(couponId);
        plans.deletePlan(planId);
    }

    @Test
    public void testDeleteCustomerDiscount(){
        customers.updateCustomer(customerId, new UpdateCustomerRequest().setCoupon(couponId));
        CustomerResponse getResponse = customers.getCustomer(customerId);

        assertEquals(couponId, getResponse.getDiscount().getCoupon().getId());

        DeleteResponse deleteResponse = discounts.deleteCustomerDiscount(customerId);

        assertTrue(deleteResponse.isDeleted());
    }

    @Test
    public void testDeleteSubscriptionDiscount(){
        SubscriptionResponse subscriptionResponse = subscriptions.createSubscription(customerId,
                new CreateSubscriptionRequest(planId).setCoupon(couponId));

        assertEquals(couponId, subscriptionResponse.getDiscount().getCoupon().getId());

        DeleteResponse deleteResponse = discounts.deleteSubscriptionDiscount(customerId, subscriptionResponse.getId());

        assertTrue(deleteResponse.isDeleted());
    }
}
