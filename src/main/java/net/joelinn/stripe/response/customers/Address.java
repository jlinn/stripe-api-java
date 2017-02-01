package net.joelinn.stripe.response.customers;

/**
 * Created by veliko on 1/29/17.
 */
public class Address {
    protected String city;

    protected String country;

    protected String line1;

    protected String line2;

    protected String postalCode;

    protected String state;

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getLine1() {
        return line1;
    }

    public String getLine2() {
        return line2;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getState() {
        return state;
    }
}
