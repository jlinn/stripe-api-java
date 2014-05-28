package net.joelinn.stripe.test.api;

import net.joelinn.stripe.api.Accounts;
import net.joelinn.stripe.response.accounts.AccountResponse;
import net.joelinn.stripe.test.StripeTestCase;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

/**
 * User: Joe Linn
 * Date: 5/21/2014
 * Time: 3:35 PM
 */
public class AccountsTest extends StripeTestCase{
    protected Accounts accounts;

    @Before
    public void setUp(){
        accounts = new Accounts(client);
    }

    @Test
    public void testGetAccount(){
        AccountResponse account = accounts.getAccount();
        MatcherAssert.assertThat(account.getCurrenciesSupported(), Matchers.hasSize(Matchers.greaterThan(0)));
    }
}
