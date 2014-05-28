package net.joelinn.stripe.api;

import net.joelinn.stripe.Client;
import net.joelinn.stripe.request.customers.CreateCustomerRequest;
import net.joelinn.stripe.request.customers.UpdateCustomerRequest;
import net.joelinn.stripe.response.DeleteResponse;
import net.joelinn.stripe.response.customers.CustomerResponse;
import net.joelinn.stripe.response.customers.ListCustomersResponse;

import javax.ws.rs.core.MultivaluedMap;

/**
 * User: Joe Linn
 * Date: 5/21/2014
 * Time: 4:01 PM
 */
public class Customers extends AbstractApi{
    public Customers(Client client) {
        super(client);
    }

    /**
     * Create a customer
     * <a href="https://stripe.com/docs/api/curl#create_customer">https://stripe.com/docs/api/curl#create_customer</a>
     */
    public CustomerResponse createCustomer(){
        return client.post("customers", CustomerResponse.class);
    }

    /**
     * Create a customer
     * <a href="https://stripe.com/docs/api/curl#create_customer">https://stripe.com/docs/api/curl#create_customer</a>
     */
    public CustomerResponse createCustomer(CreateCustomerRequest request){
        return client.post("customers", CustomerResponse.class, request.toRequest());
    }

    /**
     * Retrieve a customer
     * <a href="https://stripe.com/docs/api/curl#retrieve_customer">https://stripe.com/docs/api/curl#retrieve_customer</a>
     * @param customerId the id of the customer to retrieve
     */
    public CustomerResponse getCustomer(String customerId){
        return client.get(buildUrl(customerId), CustomerResponse.class);
    }

    /**
     * Update a customer
     * <a href="https://stripe.com/docs/api/curl#update_customer">https://stripe.com/docs/api/curl#update_customer</a>
     * @param customerId the id of the customer to update
     */
    public CustomerResponse updateCustomer(String customerId, UpdateCustomerRequest request){
        return client.post(buildUrl(customerId), CustomerResponse.class, request.toRequest());
    }

    /**
     * Delete a customer
     * <a href="https://stripe.com/docs/api/curl#delete_customer">https://stripe.com/docs/api/curl#delete_customer</a>
     * @param customerId the id of the customer to delete
     */
    public DeleteResponse deleteCustomer(String customerId){
        return client.delete(buildUrl(customerId), DeleteResponse.class);
    }

    /**
     * List customers
     * <a href="https://stripe.com/docs/api/curl#list_customers">https://stripe.com/docs/api/curl#list_customers</a>
     */
    public ListCustomersResponse listCustomers(){
        return client.get("customers", ListCustomersResponse.class);
    }

    /**
     * List customers
     * <a href="https://stripe.com/docs/api/curl#list_customers">https://stripe.com/docs/api/curl#list_customers</a>
     * @param queryParams querystring parameters to control listing
     */
    public ListCustomersResponse listCustomers(MultivaluedMap<String, String> queryParams){
        return client.get("customers", ListCustomersResponse.class, queryParams);
    }

    protected String buildUrl(String customerId){
        return "customers/" + customerId;
    }
}
