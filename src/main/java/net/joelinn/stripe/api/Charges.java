package net.joelinn.stripe.api;

import com.sun.jersey.core.util.MultivaluedMapImpl;
import net.joelinn.stripe.Client;
import net.joelinn.stripe.request.charges.CreateChargeRequest;
import net.joelinn.stripe.response.charges.ChargeResponse;
import net.joelinn.stripe.response.charges.ListChargesResponse;

import javax.ws.rs.core.MultivaluedMap;
import java.util.Map;

import static net.joelinn.stripe.request.RequestUtil.mapToRequest;

/**
 * User: Joe Linn
 * Date: 5/23/2014
 * Time: 12:08 PM
 */
public class Charges extends AbstractApi{
    public Charges(Client client) {
        super(client);
    }

    /**
     * Create a charge
     * <a href="https://stripe.com/docs/api#create_charge">https://stripe.com/docs/api#create_charge</a>
     */
    public ChargeResponse createCharge(CreateChargeRequest request){
        MultivaluedMap<String, String> body = request.toRequest();
        return client.post(buildUrl(), ChargeResponse.class, body);
    }

    /**
     * Retrieve a charge
     * <a href="https://stripe.com/docs/api#retrieve_charge">https://stripe.com/docs/api#retrieve_charge</a>
     * @param chargeId the id of the charge to retrieve
     */
    public ChargeResponse getCharge(String chargeId){
        return client.get(buildUrl(chargeId), ChargeResponse.class);
    }

    /**
     * Update a charge
     * <a href="https://stripe.com/docs/api#update_charge">https://stripe.com/docs/api#update_charge</a>
     * @param chargeId the id of the charge to update
     * @param description optional updated description
     * @param metadata optional updated metadata
     */
    public ChargeResponse updateCharge(String chargeId, String description, Map<String, Object> metadata){
        MultivaluedMapImpl request = new MultivaluedMapImpl();
        if(description != null){
            request.add("description", description);
        }
        if(metadata != null){
            request.putAll(mapToRequest(metadata, "metadata"));
        }
        return client.post(buildUrl(chargeId), ChargeResponse.class, request);
    }

    /**
     * Refund the full amount of a charge
     * <a href="https://stripe.com/docs/api#refund_charge">https://stripe.com/docs/api#refund_charge</a>
     * @param chargeId the id of the charge to refund
     */
    public ChargeResponse refundCharge(String chargeId){
        return refundCharge(chargeId, null, null);
    }

    /**
     * Refund a charge
     * <a href="https://stripe.com/docs/api#refund_charge">https://stripe.com/docs/api#refund_charge</a>
     * @param chargeId the id of the charge to refund
     * @param amount optional amount to refund
     * @param refundApplicationFee optional refund application fee
     */
    public ChargeResponse refundCharge(String chargeId, Integer amount, Integer refundApplicationFee){
        MultivaluedMapImpl request = new MultivaluedMapImpl();
        if(amount != null){
            request.add("amount", String.valueOf(amount));
        }
        if(refundApplicationFee != null){
            request.add("refund_application_fee", String.valueOf(refundApplicationFee));
        }
        return client.post(buildUrl(chargeId) + "/refund", ChargeResponse.class, request);
    }

    /**
     * Capture a charge for the full amount
     * <a href="https://stripe.com/docs/api#charge_capture">https://stripe.com/docs/api#charge_capture</a>
     * @param chargeId the id of the charge to capture
     */
    public ChargeResponse captureCharge(String chargeId){
        return captureCharge(chargeId, null, null);
    }

    /**
     * Capture a charge
     * <a href="https://stripe.com/docs/api#charge_capture">https://stripe.com/docs/api#charge_capture</a>
     * @param chargeId the id of the charge to capture
     * @param amount optional amount to capture
     * @param applicationFee optional application fee
     */
    public ChargeResponse captureCharge(String chargeId, Integer amount, Integer applicationFee){
        MultivaluedMapImpl request = new MultivaluedMapImpl();
        if(amount != null){
            request.add("amount", String.valueOf(amount));
        }
        if(applicationFee != null){
            request.add("application_fee", String.valueOf(applicationFee));
        }
        return client.post(buildUrl(chargeId) + "/capture", ChargeResponse.class, request);
    }

    /**
     * Retrieve a list of charges
     * <a href="https://stripe.com/docs/api#list_charges">https://stripe.com/docs/api#list_charges</a>
     * @param limit optional number of charges to return
     */
    public ListChargesResponse listCharges(Integer limit){
        MultivaluedMapImpl request = new MultivaluedMapImpl();
        if(limit != null){
            request.add("limit", String.valueOf(limit));
        }
        return client.get(buildUrl(), ListChargesResponse.class, null, request);
    }

    protected String buildUrl(){
        return buildUrl(null);
    }

    protected String buildUrl(String chargeId){
        String url = "charges";
        if(chargeId != null){
            url += "/" + chargeId;
        }
        return url;
    }
}
