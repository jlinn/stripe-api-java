package net.joelinn.stripe;

import net.joelinn.stripe.api.*;

/**
 * User: Joe Linn
 * Date: 5/28/2014
 * Time: 11:02 AM
 */
public class Stripe {
    protected final Accounts accounts;

    protected final ApplicationFees applicationFees;

    protected final Balance balance;

    protected final Cards cards;

    protected final Charges charges;

    protected final Coupons coupons;

    protected final Customers customers;

    protected final Discounts discounts;

    protected final Disputes disputes;

    protected final Events events;

    protected final InvoiceItems invoiceItems;

    protected final Invoices invoices;

    protected final Plans plans;

    protected final Recipients recipients;

    protected final Subscriptions subscriptions;

    protected final Tokens tokens;

    protected final Transfers transfers;

    protected final Client client;

    /**
     * @param apiKey your Stripe api key
     */
    public Stripe(String apiKey){
        client = new Client(apiKey);

        accounts = new Accounts(client);
        applicationFees = new ApplicationFees(client);
        balance = new Balance(client);
        cards = new Cards(client);
        charges = new Charges(client);
        coupons = new Coupons(client);
        customers = new Customers(client);
        discounts = new Discounts(client);
        disputes = new Disputes(client);
        events = new Events(client);
        invoiceItems = new InvoiceItems(client);
        invoices = new Invoices(client);
        plans = new Plans(client);
        recipients = new Recipients(client);
        subscriptions = new Subscriptions(client);
        tokens = new Tokens(client);
        transfers = new Transfers(client);
    }

    public Accounts accounts() {
        return accounts;
    }

    public ApplicationFees applicationFees() {
        return applicationFees;
    }

    public Balance balance() {
        return balance;
    }

    public Cards cards() {
        return cards;
    }

    public Charges charges() {
        return charges;
    }

    public Coupons coupons() {
        return coupons;
    }

    public Customers customers() {
        return customers;
    }

    public Discounts discounts() {
        return discounts;
    }

    public Disputes disputes() {
        return disputes;
    }

    public Events events() {
        return events;
    }

    public InvoiceItems invoiceItems() {
        return invoiceItems;
    }

    public Invoices invoices() {
        return invoices;
    }

    public Plans plans() {
        return plans;
    }

    public Recipients recipients() {
        return recipients;
    }

    public Subscriptions subscriptions() {
        return subscriptions;
    }

    public Tokens tokens() {
        return tokens;
    }

    public Transfers transfers() {
        return transfers;
    }

    public Client getClient() {
        return client;
    }
}
