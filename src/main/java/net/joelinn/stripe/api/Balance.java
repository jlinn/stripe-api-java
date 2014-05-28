package net.joelinn.stripe.api;

import net.joelinn.stripe.Client;
import net.joelinn.stripe.response.balance.BalanceResponse;
import net.joelinn.stripe.response.balance.BalanceTransactionResponse;
import net.joelinn.stripe.response.balance.ListBalanceTransactionsResponse;

import javax.ws.rs.core.MultivaluedMap;

/**
 * User: Joe Linn
 * Date: 5/22/2014
 * Time: 2:53 PM
 */
public class Balance extends AbstractApi{
    public Balance(Client client) {
        super(client);
    }

    /**
     * <a href="https://stripe.com/docs/api#retrieve_balance">https://stripe.com/docs/api#retrieve_balance</a>
     */
    public BalanceResponse getBalance(){
        return client.get("balance", BalanceResponse.class);
    }

    /**
     * <a href="https://stripe.com/docs/api#retrieve_balance_transaction">https://stripe.com/docs/api#retrieve_balance_transaction</a>
     * @param transactionId the id of the transaction for which to retrieve balance information
     */
    public BalanceTransactionResponse getBalanceTransaction(String transactionId){
        return client.get("balance/history" + transactionId, BalanceTransactionResponse.class);
    }

    /**
     * <a href="https://stripe.com/docs/api#balance_history">https://stripe.com/docs/api#balance_history</a>
     */
    public ListBalanceTransactionsResponse listBalanceHistory(MultivaluedMap<String, String> request){
        return client.get("balance/history", ListBalanceTransactionsResponse.class, null, request);
    }
}
