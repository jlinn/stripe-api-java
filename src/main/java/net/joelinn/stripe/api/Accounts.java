package net.joelinn.stripe.api;

import net.joelinn.stripe.Client;
import net.joelinn.stripe.response.accounts.AccountResponse;

/**
 * User: Joe Linn
 * Date: 5/21/2014
 * Time: 3:25 PM
 */
public class Accounts extends AbstractApi{
    public Accounts(Client client) {
        super(client);
    }

    /**
     * <a href="https://stripe.com/docs/api/curl#retrieve_account">https://stripe.com/docs/api/curl#retrieve_account</a>
     * @return Stripe account information
     */
    public AccountResponse getAccount(){
        return client.get("account", AccountResponse.class);
    }
}
