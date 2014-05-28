package net.joelinn.stripe.api;

import com.sun.jersey.core.util.MultivaluedMapImpl;
import net.joelinn.stripe.Client;
import net.joelinn.stripe.request.subscriptions.CreateSubscriptionRequest;
import net.joelinn.stripe.request.subscriptions.ListSubscriptionsRequest;
import net.joelinn.stripe.request.subscriptions.UpdateSubscriptionRequest;
import net.joelinn.stripe.response.subscriptions.ListSubscriptionsResponse;
import net.joelinn.stripe.response.subscriptions.SubscriptionResponse;

/**
 * User: Joe Linn
 * Date: 5/25/2014
 * Time: 7:47 PM
 */
public class Subscriptions extends AbstractApi{
    public Subscriptions(Client client) {
        super(client);
    }

    /**
     * Create a subscription
     * <a href="https://stripe.com/docs/api/curl#create_subscription">https://stripe.com/docs/api/curl#create_subscription</a>
     * @param customerId the id of the customer for whom to create a subscription
     */
    public SubscriptionResponse createSubscription(String customerId, CreateSubscriptionRequest request){
        return client.post(buildUrl(customerId), SubscriptionResponse.class, request.toRequest());
    }

    /**
     * Retrieve a subscription
     * <a href="https://stripe.com/docs/api/curl#retrieve_subscription">https://stripe.com/docs/api/curl#retrieve_subscription</a>
     * @param customerId the id of the customer to which the subscription belongs
     * @param subscriptionId the id of the subscription to retrieve
     */
    public SubscriptionResponse getSubscription(String customerId, String subscriptionId){
        return client.get(buildUrl(customerId, subscriptionId), SubscriptionResponse.class);
    }

    /**
     * Update a subscription
     * <a href="https://stripe.com/docs/api/curl#update_subscription">https://stripe.com/docs/api/curl#update_subscription</a>
     * @param customerId the id of the customer to which the subscription belongs
     * @param subscriptionId the id of the subscription to update
     */
    public SubscriptionResponse updateSubscription(String customerId, String subscriptionId, UpdateSubscriptionRequest request){
        return client.post(buildUrl(customerId, subscriptionId), SubscriptionResponse.class, request.toRequest());
    }

    /**
     * Cancel a subscription
     * <a href="https://stripe.com/docs/api#cancel_subscription">https://stripe.com/docs/api#cancel_subscription</a>
     * @param customerId the id of the customer to which the subscription belongs
     * @param subscriptionId the id of the subscription to cancel
     */
    public SubscriptionResponse cancelSubscription(String customerId, String subscriptionId){
        return cancelSubscription(customerId, subscriptionId, null);
    }

    /**
     * Cancel a subscription
     * <a href="https://stripe.com/docs/api#cancel_subscription">https://stripe.com/docs/api#cancel_subscription</a>
     * @param customerId the id of the customer to which the subscription belongs
     * @param subscriptionId the id of the subscription to cancel
     * @param atPeriodEnd if true, cancellation will be delayed until the end of the current period
     */
    public SubscriptionResponse cancelSubscription(String customerId, String subscriptionId, Boolean atPeriodEnd){
        MultivaluedMapImpl params = new MultivaluedMapImpl();
        if(atPeriodEnd != null){
            params.add("at_period_end", String.valueOf(atPeriodEnd));
        }
        return client.delete(buildUrl(customerId, subscriptionId), SubscriptionResponse.class, null, params);
    }

    /**
     * List subscriptions
     * <a href="https://stripe.com/docs/api#list_subscriptions">https://stripe.com/docs/api#list_subscriptions</a>
     * @param customerId the id of the customer to which the subscriptions belong
     */
    public ListSubscriptionsResponse listSubscriptions(String customerId, ListSubscriptionsRequest request){
        return client.get(buildUrl(customerId), ListSubscriptionsResponse.class, null, request.toRequest());
    }

    protected String buildUrl(String customerId){
        return buildUrl(customerId, null);
    }

    protected String buildUrl(String customerId, String subscriptionId){
        String url = "customers/" + customerId + "/subscriptions";
        if(subscriptionId != null){
            url += "/" + subscriptionId;
        }
        return url;
    }
}
