package net.joelinn.stripe.response;

/**
 * User: Joe Linn
 * Date: 5/22/2014
 * Time: 11:36 AM
 */
public class DeleteResponse {
    protected boolean deleted;

    protected String id;

    public boolean isDeleted() {
        return deleted;
    }

    public String getId() {
        return id;
    }
}
