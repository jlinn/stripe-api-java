package net.joelinn.stripe.api;

import com.sun.jersey.core.util.MultivaluedMapImpl;
import net.joelinn.stripe.Client;
import net.joelinn.stripe.request.invoices.CreateInvoiceRequest;
import net.joelinn.stripe.request.invoices.ListInvoiceLineItemsRequest;
import net.joelinn.stripe.request.invoices.ListInvoicesRequest;
import net.joelinn.stripe.request.invoices.UpdateInvoiceRequest;
import net.joelinn.stripe.response.invoices.InvoiceResponse;
import net.joelinn.stripe.response.invoices.ListInvoicesResponse;
import net.joelinn.stripe.response.invoices.ListLineItemsResponse;

/**
 * User: Joe Linn
 * Date: 5/24/2014
 * Time: 3:48 PM
 */
public class Invoices extends AbstractApi{
    public Invoices(Client client) {
        super(client);
    }

    /**
     * Create an invoice
     * <a href="https://stripe.com/docs/api/curl#create_plan">https://stripe.com/docs/api/curl#create_plan</a>
     */
    public InvoiceResponse createInvoice(CreateInvoiceRequest request){
        return client.post(buildUrl(), InvoiceResponse.class, request.toRequest());
    }

    /**
     * Retrieve an invoice
     * <a href="https://stripe.com/docs/api/curl#retrieve_plan">https://stripe.com/docs/api/curl#retrieve_plan</a>
     * @param invoiceId the id of the invoice to retrieve
     */
    public InvoiceResponse getInvoice(String invoiceId){
        return client.get(buildUrl(invoiceId), InvoiceResponse.class);
    }

    /**
     * Update an invoice
     * <a href="https://stripe.com/docs/api/curl#update_plan">https://stripe.com/docs/api/curl#update_plan</a>
     * @param invoiceId the id of the invoice to update
     */
    public InvoiceResponse updateInvoice(String invoiceId, UpdateInvoiceRequest request){
        return client.post(buildUrl(invoiceId), InvoiceResponse.class, request.toRequest());
    }

    /**
     * Pay an invoice
     * <a href="https://stripe.com/docs/api/curl#delete_plan">https://stripe.com/docs/api/curl#delete_plan</a>
     * @param invoiceId the id of the invoice to pay
     */
    public InvoiceResponse payInvoice(String invoiceId){
        return client.post(buildUrl(invoiceId) + "/pay", InvoiceResponse.class);
    }

    /**
     * List invoices
     * <a href="https://stripe.com/docs/api/curl#list_plans">https://stripe.com/docs/api/curl#list_plans</a>
     */
    public ListInvoicesResponse listInvoices(ListInvoicesRequest request){
        return client.get(buildUrl(), ListInvoicesResponse.class, null, request.toRequest());
    }

    /**
     * List an invoice's line items
     * <a href="https://stripe.com/docs/api/curl#invoice_lines">https://stripe.com/docs/api/curl#invoice_lines</a>
     * @param invoiceId the id of the invoice for which to retrieve line items
     */
    public ListLineItemsResponse listInvoiceLineItems(String invoiceId, ListInvoiceLineItemsRequest request){
        return client.get(buildUrl(invoiceId) + "/lines", ListLineItemsResponse.class, null, request.toRequest());
    }

    /**
     * Retrieve a customer's upcoming invoice
     * <a href="https://stripe.com/docs/api/curl#retrieve_customer_invoice">https://stripe.com/docs/api/curl#retrieve_customer_invoice</a>
     * @param customerId the id of the customer for which to retrieve the upcoming invoice
     */
    public InvoiceResponse getUpcomingInvoice(String customerId){
        return getUpcomingInvoice(customerId, null);
    }

    /**
     * Retrieve a customer's upcoming invoice for a specific subscription
     * <a href="https://stripe.com/docs/api/curl#retrieve_customer_invoice">https://stripe.com/docs/api/curl#retrieve_customer_invoice</a>
     * @param customerId the id of the customer for which to retrieve the upcoming invoice
     * @param subscriptionId the id of the subscription for which to retrieve the customer's upcoming invoice
     */
    public InvoiceResponse getUpcomingInvoice(String customerId, String subscriptionId){
        MultivaluedMapImpl params = new MultivaluedMapImpl();
        params.add("customer", customerId);
        if(subscriptionId != null){
            params.add("subscription", subscriptionId);
        }
        return client.get("invoices/upcoming", InvoiceResponse.class, null, params);
    }

    protected String buildUrl(){
        return buildUrl(null);
    }

    protected String buildUrl(String invoiceId){
        String url = "invoices";
        if(invoiceId != null){
            url += "/" + invoiceId;
        }
        return url;
    }
}
