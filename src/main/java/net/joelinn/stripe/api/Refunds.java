package net.joelinn.stripe.api;

import com.sun.jersey.core.util.MultivaluedMapImpl;
import net.joelinn.stripe.Client;
import net.joelinn.stripe.request.ListRequest;
import net.joelinn.stripe.request.refunds.CreateRefundRequest;
import net.joelinn.stripe.response.refunds.ListRefundsResponse;
import net.joelinn.stripe.response.refunds.RefundResponse;

import java.util.Map;

import static net.joelinn.stripe.request.RequestUtil.mapToRequest;

/**
 * User: Joe Linn
 * Date: 7/28/2014
 * Time: 11:50 AM
 */
public class Refunds extends AbstractApi{
    public Refunds(Client client) {
        super(client);
    }

    /**
     * Create a refund (refund a charge)
     * <a href="https://stripe.com/docs/api#create_refund">https://stripe.com/docs/api#create_refund</a>
     * @param chargeId the id of the charge to refund
     * @return the results of the refund operation
     */
    public RefundResponse createRefund(String chargeId){
        return client.post(buildUrl(chargeId), RefundResponse.class);
    }

    /**
     * Create a refund (refund a charge)
     * <a href="https://stripe.com/docs/api#create_refund">https://stripe.com/docs/api#create_refund</a>
     * @param chargeId the id of the charge to refund
     * @param request optional refund request parameters
     * @return the results of the refund operation
     */
    public RefundResponse createRefund(String chargeId, CreateRefundRequest request){
        return client.post(buildUrl(chargeId), RefundResponse.class, request.toRequest());
    }

    /**
     * Retrieve a refund
     * <a href="https://stripe.com/docs/api#retrieve_refund">https://stripe.com/docs/api#retrieve_refund</a>
     * @param chargeId the id of the refunded charge
     * @param refundId the id of the refund to be retrieved
     * @return details regarding the requested refund
     */
    public RefundResponse getRefund(String chargeId, String refundId){
        return client.get(buildUrl(chargeId, refundId), RefundResponse.class);
    }

    /**
     * Update the metadata of a refund
     * <a href="https://stripe.com/docs/api#update_refund">https://stripe.com/docs/api#update_refund</a>
     * @param chargeId the id of the refunded charge
     * @param refundId the id of the refund to be updated
     * @param metadata new metadata for this refund
     * @return the updated refund
     */
    public RefundResponse updateRefund(String chargeId, String refundId, Map<String, Object> metadata){
        MultivaluedMapImpl request = new MultivaluedMapImpl();
        if(metadata != null){
            request.putAll(mapToRequest(metadata, "metadata"));
        }
        return client.post(buildUrl(chargeId, refundId), RefundResponse.class, request);
    }

    /**
     * List all refunds associated with the given charge
     * <a href="https://stripe.com/docs/api#list_refunds">https://stripe.com/docs/api#list_refunds</a>
     * @param chargeId the id of the refunded charge
     * @param listRequest optional list request parameters
     * @return a list of refunds
     */
    public ListRefundsResponse listRefunds(String chargeId, ListRequest listRequest){
        return client.get(buildUrl(chargeId), ListRefundsResponse.class, listRequest.toRequest());
    }

    protected String buildUrl(final String chargeId){
        return buildUrl(chargeId, null);
    }

    protected String buildUrl(final String chargeId, final String refundId){
        String url = "charges/" + chargeId + "/refunds";
        if(refundId != null){
            url += "/" + refundId;
        }
        return url;
    }
}
