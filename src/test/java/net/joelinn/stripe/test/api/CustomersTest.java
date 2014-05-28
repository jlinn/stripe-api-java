package net.joelinn.stripe.test.api;

import junit.framework.TestCase;
import net.joelinn.stripe.api.Customers;
import net.joelinn.stripe.error.StripeApiException;
import net.joelinn.stripe.request.customers.CreateCustomerRequest;
import net.joelinn.stripe.request.customers.UpdateCustomerRequest;
import net.joelinn.stripe.response.DeleteResponse;
import net.joelinn.stripe.response.customers.CustomerResponse;
import net.joelinn.stripe.response.customers.ListCustomersResponse;
import net.joelinn.stripe.test.StripeTestCase;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * User: Joe Linn
 * Date: 5/21/2014
 * Time: 4:00 PM
 */
public class CustomersTest extends StripeTestCase{
    protected Customers customers;

    @Before
    public void setUp(){
        customers = new Customers(client);
    }

    @Test
    public void testCreateCustomerWithoutRequest(){
        CustomerResponse customer = customers.createCustomer();

        TestCase.assertNotNull(customer.getId());

        // cleanup
        DeleteResponse delete = deleteCustomer(customer.getId());
        TestCase.assertTrue(delete.isDeleted());
    }

    @Test
    public void testCreateCustomerWithRequest(){
        int balance = -500;
        String description = "testing";
        CreateCustomerRequest request = new CreateCustomerRequest().setAccountBalance(balance).setDescription(description);
        CustomerResponse response = customers.createCustomer(request);

        assertEquals(balance, response.getAccountBalance());
        assertEquals(description, response.getDescription());

        deleteCustomer(response.getId());
    }

    @Test
    public void testGetCustomer(){
        CustomerResponse createResponse = customers.createCustomer();
        CustomerResponse getResponse = customers.getCustomer(createResponse.getId());

        assertEquals(createResponse.getId(), getResponse.getId());


        deleteCustomer(getResponse.getId());
    }

    @Test(expected = StripeApiException.class)
    public void testGetBogusCustomer(){
        customers.getCustomer("foobar");
    }

    @Test
    public void testUpdateCustomer(){
        CustomerResponse createResponse = customers.createCustomer();

        String email = "foo@bar.com";
        String description = "a test client";
        UpdateCustomerRequest request = new UpdateCustomerRequest().setDescription(description).setEmail(email);
        CustomerResponse updateResponse = customers.updateCustomer(createResponse.getId(), request);

        assertEquals(email, updateResponse.getEmail());
        assertEquals(description, updateResponse.getDescription());

        deleteCustomer(createResponse.getId());
    }

    @Test
    public void testDeleteCustomer(){
        CustomerResponse createResponse = customers.createCustomer();
        DeleteResponse deleteResponse = customers.deleteCustomer(createResponse.getId());

        assertTrue(deleteResponse.isDeleted());
        assertEquals(createResponse.getId(), deleteResponse.getId());
    }

    @Test
    public void testListCustomers(){
        CustomerResponse customer1 = customers.createCustomer();
        CustomerResponse customer2 = customers.createCustomer();

        ListCustomersResponse list = customers.listCustomers();

        assertThat(list.getData(), Matchers.hasSize(Matchers.greaterThan(1)));

        deleteCustomer(customer1.getId());
        deleteCustomer(customer2.getId());
    }

    protected DeleteResponse deleteCustomer(String customerId){
        return client.delete("customers/" + customerId, DeleteResponse.class);
    }
}
