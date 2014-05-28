package net.joelinn.stripe.api;

import net.joelinn.stripe.Client;

/**
 * User: Joe Linn
 * Date: 5/21/2014
 * Time: 3:24 PM
 */
abstract public class AbstractApi {
    protected final Client client;

    public AbstractApi(Client client) {
        this.client = client;
    }
}
