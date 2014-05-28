package net.joelinn.stripe.api;

import com.sun.jersey.core.util.MultivaluedMapImpl;
import net.joelinn.stripe.Client;
import net.joelinn.stripe.response.disputes.DisputeResponse;

/**
 * User: Joe Linn
 * Date: 5/23/2014
 * Time: 4:04 PM
 */
public class Disputes extends AbstractApi{
    public Disputes(Client client) {
        super(client);
    }

    /**
     * Update a dispute
     * <a href="https://stripe.com/docs/api#update_dispute">https://stripe.com/docs/api#update_dispute</a>
     * @param chargeId the id of the dispute to update
     * @param evidence updated dispute evidence
     */
    public DisputeResponse updateDispute(String chargeId, String evidence){
        MultivaluedMapImpl params = new MultivaluedMapImpl();
        params.add("evidence", evidence);
        return client.post(buildUrl(chargeId), DisputeResponse.class, params);
    }

    /**
     * Close a dispute
     * <a href="https://stripe.com/docs/api#close_dispute">https://stripe.com/docs/api#close_dispute</a>
     * @param chargeId the id of the charge on which to close the dispute
     */
    public DisputeResponse closeDispute(String chargeId){
        return client.post(buildUrl(chargeId) + "/close", DisputeResponse.class);
    }

    protected String buildUrl(String chargeId){
        return "charges/" + chargeId + "/dispute";
    }
}
