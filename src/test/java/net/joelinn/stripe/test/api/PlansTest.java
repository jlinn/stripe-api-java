package net.joelinn.stripe.test.api;

import net.joelinn.stripe.api.Plans;
import net.joelinn.stripe.request.plans.CreatePlanRequest;
import net.joelinn.stripe.request.plans.UpdatePlanRequest;
import net.joelinn.stripe.response.DeleteResponse;
import net.joelinn.stripe.response.plans.PlanResponse;
import net.joelinn.stripe.test.StripeTestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PlansTest extends StripeTestCase {

    protected Plans plans;

    @Before
    public void setUp() throws Exception {
        plans = new Plans(client);
    }

    @Test
    public void testCreatePlan(){
        String id = "test_plan" + String.valueOf(Math.random());
        PlanResponse createResponse = plans.createPlan(new CreatePlanRequest(id, 350, "usd", "month", "test plan"));

        assertEquals(id, createResponse.getId());
        assertEquals(350, createResponse.getAmount());

        deletePlan(createResponse.getId());
    }

    @Test
    public void testGetPlan(){
        PlanResponse createResponse = createPlan();

        PlanResponse getResponse = plans.getPlan(createResponse.getId());

        assertEquals(createResponse.getId(), getResponse.getId());
        assertEquals(createResponse.getAmount(), getResponse.getAmount());

        deletePlan(getResponse.getId());
    }

    @Test
    public void testUpdatePlan(){
        PlanResponse createResponse = createPlan();

        String name = "new name";
        PlanResponse updateResponse = plans.updatePlan(createResponse.getId(), new UpdatePlanRequest().setName(name));

        assertEquals(name, updateResponse.getName());

        deletePlan(updateResponse.getId());
    }

    @Test
    public void testDeletePlan(){
        PlanResponse createResponse = createPlan();

        DeleteResponse deleteResponse = deletePlan(createResponse.getId());

        assertEquals(createResponse.getId(), deleteResponse.getId());
        assertTrue(deleteResponse.isDeleted());
    }

    protected PlanResponse createPlan(){
        String id = "test_plan" + String.valueOf(Math.random());
        return plans.createPlan(new CreatePlanRequest(id, 350, "usd", "month", "test plan"));
    }

    protected DeleteResponse deletePlan(String planId){
        return client.delete("plans/" + planId, DeleteResponse.class);
    }
}