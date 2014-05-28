package net.joelinn.stripe.test.api;

import net.joelinn.stripe.api.Balance;
import net.joelinn.stripe.response.balance.BalanceResponse;
import net.joelinn.stripe.response.balance.ListBalanceTransactionsResponse;
import net.joelinn.stripe.test.StripeTestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: Joe Linn
 * Date: 5/22/2014
 * Time: 2:56 PM
 */
public class BalanceTest extends StripeTestCase{
    protected Balance balance;

    //TODO: transfers

    @Before
    public void setUp(){
        balance = new Balance(client);
    }

    @Test
    public void testGetBalance(){
        BalanceResponse getResponse = balance.getBalance();

        assertEquals("balance", getResponse.getObject());
    }

    //TODO: testGetBalanceTransaction

    @Test
    public void testListBalanceHistory(){
        ListBalanceTransactionsResponse list = balance.listBalanceHistory(null);

        assertEquals("list", list.getObject());
    }
}
