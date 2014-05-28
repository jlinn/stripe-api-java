package net.joelinn.stripe.api;

import net.joelinn.stripe.Client;
import net.joelinn.stripe.response.DeleteResponse;

/**
 * User: Joe Linn
 * Date: 5/23/2014
 * Time: 3:57 PM
 */
public class Discounts extends AbstractApi{
    public Discounts(Client client) {
        super(client);
    }

    /**
     * Delete a discount
     * <a href="https://stripe.com/docs/api#delete_discount">https://stripe.com/docs/api#delete_discount</a>
     * @param customerId the id of the customer whose discount should be deleted
     */
    public DeleteResponse deleteCustomerDiscount(String customerId){
        return client.delete("customers/" + customerId + "/discount", DeleteResponse.class);
    }

    /**
     * Delete a subscription-specific discount
     * <a href="https://stripe.com/docs/api#delete_subscription_discount">https://stripe.com/docs/api#delete_subscription_discount</a>
     * @param customerId the id of the customer tho whom the subscription belongs
     * @param subscriptionId the id of the subscription from which to remove the discount
     */
    public DeleteResponse deleteSubscriptionDiscount(String customerId, String subscriptionId){
        return client.delete("customers/" + customerId + "/subscriptions/" + subscriptionId + "/discount", DeleteResponse.class);
    }
}
