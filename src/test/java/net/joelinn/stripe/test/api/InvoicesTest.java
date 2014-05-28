package net.joelinn.stripe.test.api;

import net.joelinn.stripe.api.Customers;
import net.joelinn.stripe.api.InvoiceItems;
import net.joelinn.stripe.api.Invoices;
import net.joelinn.stripe.request.cards.CreateCardRequest;
import net.joelinn.stripe.request.customers.CreateCustomerRequest;
import net.joelinn.stripe.request.invoiceitems.CreateInvoiceItemRequest;
import net.joelinn.stripe.request.invoices.CreateInvoiceRequest;
import net.joelinn.stripe.request.invoices.ListInvoiceLineItemsRequest;
import net.joelinn.stripe.request.invoices.ListInvoicesRequest;
import net.joelinn.stripe.request.invoices.UpdateInvoiceRequest;
import net.joelinn.stripe.response.invoices.InvoiceResponse;
import net.joelinn.stripe.response.invoices.LineItemResponse;
import net.joelinn.stripe.response.invoices.ListInvoicesResponse;
import net.joelinn.stripe.response.invoices.ListLineItemsResponse;
import net.joelinn.stripe.test.StripeTestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InvoicesTest extends StripeTestCase {
    protected Invoices invoices;

    protected InvoiceItems invoiceItems;

    protected Customers customers;

    protected String customerId;

    @Before
    public void setUp() {
        invoices = new Invoices(client);
        invoiceItems = new InvoiceItems(client);
        customers = new Customers(client);
        customerId = customers.createCustomer(new CreateCustomerRequest().setCard(new CreateCardRequest(VISA_1, 1, 2020)))
                .getId();
        invoiceItems.createInvoiceItem(new CreateInvoiceItemRequest(customerId, 350, "usd"));
    }

    @After
    public void tearDown() {
        customers.deleteCustomer(customerId);
    }

    @Test
    public void testCreateInvoice(){
        InvoiceResponse invoice = invoices.createInvoice(new CreateInvoiceRequest(customerId));

        assertEquals(customerId, invoice.getCustomer());
        assertEquals("usd", invoice.getCurrency());
        assertEquals(350, invoice.getAmountDue());
    }

    @Test
    public void testGetInvoice(){
        InvoiceResponse createResponse = invoices.createInvoice(new CreateInvoiceRequest(customerId));

        InvoiceResponse invoice = invoices.getInvoice(createResponse.getId());

        assertEquals(createResponse.getId(), invoice.getId());
        assertEquals(createResponse.getAmountDue(), invoice.getAmountDue());
    }

    @Test
    public void testUpdateInvoice(){
        InvoiceResponse createResponse = invoices.createInvoice(new CreateInvoiceRequest(customerId)
                .setDescription("original description"));

        String description = "new description";
        InvoiceResponse updateResponse = invoices.updateInvoice(createResponse.getId(), new UpdateInvoiceRequest().setDescription(description));

        assertEquals(description, updateResponse.getDescription());
    }

    @Test
    public void testPayInvoice(){
        InvoiceResponse createResponse = invoices.createInvoice(new CreateInvoiceRequest(customerId));

        InvoiceResponse payResponse = invoices.payInvoice(createResponse.getId());

        assertTrue(payResponse.isPaid());
    }

    @Test
    public void testListInvoices(){
        InvoiceResponse createResponse = invoices.createInvoice(new CreateInvoiceRequest(customerId));

        ListInvoicesResponse listResponse = invoices.listInvoices(new ListInvoicesRequest().setCustomer(customerId));

        boolean invoiceFound = false;
        for (InvoiceResponse invoice : listResponse.getData()) {
            assertEquals(customerId, invoice.getCustomer());
            if(invoice.getId().equals(createResponse.getId())){
                invoiceFound = true;
            }
        }
        assertTrue(invoiceFound);
    }

    @Test
    public void testListInvoiceLineItems(){
        InvoiceResponse createResponse = invoices.createInvoice(new CreateInvoiceRequest(customerId));

        ListLineItemsResponse listResponse = invoices.listInvoiceLineItems(createResponse.getId(), new ListInvoiceLineItemsRequest().setCustomer(customerId));
        for (LineItemResponse lineItem : listResponse.getData()) {
            assertEquals("usd", lineItem.getCurrency());
            assertEquals(350, lineItem.getAmount());
        }
    }

    @Test
    public void testGetUpcomingInvoice(){
        InvoiceResponse invoice = invoices.getUpcomingInvoice(customerId);

        assertEquals(customerId, invoice.getCustomer());
    }
}