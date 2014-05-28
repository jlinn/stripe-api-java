package net.joelinn.stripe.test.api;

import net.joelinn.stripe.api.Customers;
import net.joelinn.stripe.api.Plans;
import net.joelinn.stripe.api.Subscriptions;
import net.joelinn.stripe.request.cards.CreateCardRequest;
import net.joelinn.stripe.request.plans.CreatePlanRequest;
import net.joelinn.stripe.request.subscriptions.CreateSubscriptionRequest;
import net.joelinn.stripe.request.subscriptions.ListSubscriptionsRequest;
import net.joelinn.stripe.request.subscriptions.UpdateSubscriptionRequest;
import net.joelinn.stripe.response.subscriptions.ListSubscriptionsResponse;
import net.joelinn.stripe.response.subscriptions.SubscriptionResponse;
import net.joelinn.stripe.test.StripeTestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SubscriptionsTest extends StripeTestCase {

    protected Customers customers;

    protected Plans plans;

    protected Subscriptions subscriptions;

    protected String customerId;

    protected String planId;

    @Before
    public void setUp() {
        subscriptions = new Subscriptions(client);
        customers = new Customers(client);
        plans = new Plans(client);

        customerId = customers.createCustomer().getId();
        planId = plans.createPlan(new CreatePlanRequest("test_plan" + Math.random(), 350, "usd", "month", "test plan")).getId();
    }

    @After
    public void tearDown() {
        customers.deleteCustomer(customerId);
        plans.deletePlan(planId);
    }

    @Test
    public void testCreateSubscription(){
        SubscriptionResponse createResponse = subscriptions.createSubscription(customerId,
                new CreateSubscriptionRequest(planId).setCard(new CreateCardRequest(VISA_1, 1, 2020)));

        assertEquals(planId, createResponse.getPlan().getId());
        assertEquals(customerId, createResponse.getCustomer());
    }

    @Test
    public void testGetSubscription(){
        SubscriptionResponse createResponse = createSubscription();

        SubscriptionResponse getResponse = subscriptions.getSubscription(customerId, createResponse.getId());

        assertEquals(createResponse.getId(), getResponse.getId());
    }

    @Test
    public void testUpdateSubscription(){
        SubscriptionResponse createResponse = createSubscription();

        SubscriptionResponse updateResponse = subscriptions.updateSubscription(customerId, createResponse.getId(),
                new UpdateSubscriptionRequest().setQuantity(2));

        assertEquals(2, updateResponse.getQuantity());
    }

    @Test
    public void testCancelSubscription(){
        SubscriptionResponse createResponse = createSubscription();

        SubscriptionResponse cancelResponse = subscriptions.cancelSubscription(customerId, createResponse.getId(), true);

        assertTrue(cancelResponse.isCancelAtPeriodEnd());
    }

    @Test
    public void testListSubscriptions(){
        SubscriptionResponse createResponse = createSubscription();

        ListSubscriptionsResponse list = subscriptions.listSubscriptions(customerId, new ListSubscriptionsRequest());

        boolean found = false;
        for (SubscriptionResponse subscription : list.getData()) {
            if(subscription.getId().equals(createResponse.getId())){
                found = true;
            }
        }
        assertTrue(found);
    }

    protected SubscriptionResponse createSubscription(){
        return subscriptions.createSubscription(customerId,
                new CreateSubscriptionRequest(planId).setCard(new CreateCardRequest(VISA_1, 1, 2020)));
    }
}