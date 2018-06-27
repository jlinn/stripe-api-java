package net.joelinn.stripe.response.customers;

/**
 * Created by veliko on 1/29/17.
 */
public class Shipping {
    protected Address address;

    protected String carrier;

    protected String name;

    protected String phone;

    protected String trackingNumber;

    public Address getAddress() {
        return address;
    }

    public String getCarrier() {
        return carrier;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }
}
