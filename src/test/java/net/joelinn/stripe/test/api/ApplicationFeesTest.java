package net.joelinn.stripe.test.api;

import net.joelinn.stripe.api.ApplicationFees;
import net.joelinn.stripe.response.applicationfees.ListApplicationFeesResponse;
import net.joelinn.stripe.test.StripeTestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: Joe Linn
 * Date: 5/22/2014
 * Time: 2:39 PM
 */
public class ApplicationFeesTest extends StripeTestCase{
    protected ApplicationFees applicationFees;

    @Before
    public void setUp(){
        applicationFees = new ApplicationFees(client);
    }

    @Test
    public void testListApplicationFees(){
        ListApplicationFeesResponse list = applicationFees.listApplicationFees();

        assertEquals("list", list.getObject());
    }
}
