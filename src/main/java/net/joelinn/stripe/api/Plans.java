package net.joelinn.stripe.api;

import net.joelinn.stripe.Client;
import net.joelinn.stripe.request.plans.CreatePlanRequest;
import net.joelinn.stripe.request.plans.ListPlansRequest;
import net.joelinn.stripe.request.plans.UpdatePlanRequest;
import net.joelinn.stripe.response.DeleteResponse;
import net.joelinn.stripe.response.plans.ListPlansResponse;
import net.joelinn.stripe.response.plans.PlanResponse;

/**
 * User: Joe Linn
 * Date: 5/25/2014
 * Time: 5:26 PM
 */
public class Plans extends AbstractApi{
    public Plans(Client client) {
        super(client);
    }

    /**
     * Create a plan
     * <a href="https://stripe.com/docs/api/curl#create_plan">https://stripe.com/docs/api/curl#create_plan</a>
     */
    public PlanResponse createPlan(CreatePlanRequest request){
        return client.post(buildUrl(), PlanResponse.class, request.toRequest());
    }

    /**
     * Retrieve a plan
     * <a href="https://stripe.com/docs/api/curl#retrieve_plan">https://stripe.com/docs/api/curl#retrieve_plan</a>
     * @param planId the id of the plan to retrieve
     */
    public PlanResponse getPlan(String planId){
        return client.get(buildUrl(planId), PlanResponse.class);
    }

    /**
     * Update a plan
     * <a href="https://stripe.com/docs/api/curl#update_plan">https://stripe.com/docs/api/curl#update_plan</a>
     * @param planId the id of the plan to update
     */
    public PlanResponse updatePlan(String planId, UpdatePlanRequest request){
        return client.post(buildUrl(planId), PlanResponse.class, request.toRequest());
    }

    /**
     * Delete a plan
     * <a href="https://stripe.com/docs/api/curl#delete_plan">https://stripe.com/docs/api/curl#delete_plan</a>
     * @param planId the id of the plan to delete
     */
    public DeleteResponse deletePlan(String planId){
        return client.delete(buildUrl(planId), DeleteResponse.class);
    }

    /**
     * List plans
     * <a href="https://stripe.com/docs/api/curl#list_plans">https://stripe.com/docs/api/curl#list_plans</a>
     */
    public ListPlansResponse listPlans(ListPlansRequest request){
        return client.get(buildUrl(), ListPlansResponse.class, null, request.toRequest());
    }

    protected String buildUrl(){
        return buildUrl(null);
    }

    protected String buildUrl(String planId){
        String url = "plans";
        if(planId != null){
            url += "/" + planId;
        }
        return url;
    }
}
