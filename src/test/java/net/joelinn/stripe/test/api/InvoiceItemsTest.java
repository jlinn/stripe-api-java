package net.joelinn.stripe.test.api;

import net.joelinn.stripe.api.Customers;
import net.joelinn.stripe.api.InvoiceItems;
import net.joelinn.stripe.request.invoiceitems.CreateInvoiceItemRequest;
import net.joelinn.stripe.request.invoiceitems.ListInvoiceItemsRequest;
import net.joelinn.stripe.request.invoiceitems.UpdateInvoiceItemRequest;
import net.joelinn.stripe.response.DeleteResponse;
import net.joelinn.stripe.response.invoiceitems.InvoiceItemResponse;
import net.joelinn.stripe.response.invoiceitems.ListInvoiceItemsResponse;
import net.joelinn.stripe.test.StripeTestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * User: Joe Linn
 * Date: 5/23/2014
 * Time: 3:38 PM
 */
public class InvoiceItemsTest extends StripeTestCase{
    protected InvoiceItems invoiceItems;

    protected Customers customers;

    protected String customerId;

    @Before
    public void setUp(){
        invoiceItems = new InvoiceItems(client);
        customers = new Customers(client);
        customerId = customers.createCustomer().getId();
    }

    @After
    public void tearDown(){
        customers.deleteCustomer(customerId);
    }

    @Test
    public void testCreateInvoiceItem() {
        Map<String, Object> metadata = new HashMap<String, Object>();
        metadata.put("foo", 18);
        InvoiceItemResponse createResponse = invoiceItems.createInvoiceItem(new CreateInvoiceItemRequest(customerId, 350, "usd")
                .setMetadata(metadata));

        assertEquals(350, createResponse.getAmount());
        assertEquals("18", createResponse.getMetadata().get("foo"));
    }

    @Test
    public void testGetInvoiceItem(){
        InvoiceItemResponse createResponse = invoiceItems.createInvoiceItem(new CreateInvoiceItemRequest(customerId, 350, "usd"));

        InvoiceItemResponse getResponse = invoiceItems.getInvoiceItem(createResponse.getId());

        assertEquals(createResponse.getId(), getResponse.getId());
    }

    @Test
    public void testUpdateInvoiceItem(){
        InvoiceItemResponse createResponse = invoiceItems.createInvoiceItem(new CreateInvoiceItemRequest(customerId, 350, "usd"));

        InvoiceItemResponse updateResponse = invoiceItems.updateInvoiceItem(createResponse.getId(), new UpdateInvoiceItemRequest().setAmount(500));

        assertEquals(500, updateResponse.getAmount());
    }

    @Test
    public void testDeleteInvoiceItem(){
        InvoiceItemResponse createResponse = invoiceItems.createInvoiceItem(new CreateInvoiceItemRequest(customerId, 350, "usd"));

        DeleteResponse deleteResponse = invoiceItems.deleteInvoiceItem(createResponse.getId());

        assertTrue(deleteResponse.isDeleted());
        assertEquals(createResponse.getId(), deleteResponse.getId());
    }

    @Test
    public void testListInvoiceItems(){
        invoiceItems.createInvoiceItem(new CreateInvoiceItemRequest(customerId, 350, "usd"));
        invoiceItems.createInvoiceItem(new CreateInvoiceItemRequest(customerId, 550, "usd"));

        ListInvoiceItemsRequest request = new ListInvoiceItemsRequest().setCustomer(customerId);
        ListInvoiceItemsResponse listResponse = invoiceItems.listInvoiceItems(request);

        assertThat(listResponse.getData(), hasSize(2));
        for (InvoiceItemResponse invoiceItem : listResponse.getData()) {
            assertEquals(customerId, invoiceItem.getCustomer());
        }
    }
}
