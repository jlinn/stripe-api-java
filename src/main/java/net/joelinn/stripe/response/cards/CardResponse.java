package net.joelinn.stripe.response.cards;

import java.util.Map;

/**
 * User: Joe Linn
 * Date: 5/21/2014
 * Time: 4:03 PM
 */
public class CardResponse {
    protected String id;

    protected String object;

    protected String last4;

    protected String dynamicLast4;

    protected String brand;

    protected String funding;

    protected short expMonth;

    protected short expYear;

    protected String fingerprint;

    protected String customer;

    protected String country;

    protected String name;

    protected String addressLine1;

    protected String addressLine2;

    protected String addressCity;

    protected String addressState;

    protected String addressZip;

    protected String addressCountry;

    protected String cvcCheck;

    protected String addressLine1Check;

    protected String addressZipCheck;

    protected String recipient;

    protected String tokenizationMethod;

    protected boolean active;

    protected int amount;

    protected int amountReceived;

    protected String accountHolderName;

    protected Map<String, Object> metadata;

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public String getTokenizationMethod() {
        return tokenizationMethod;
    }

    public String getDynamicLast4() {
        return dynamicLast4;
    }

    public String getId() {
        return id;
    }

    public String getObject() {
        return object;
    }

    public String getLast4() {
        return last4;
    }

    public short getExpMonth() {
        return expMonth;
    }

    public short getExpYear() {
        return expYear;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public String getCustomer() {
        return customer;
    }

    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public String getAddressState() {
        return addressState;
    }

    public String getAddressZip() {
        return addressZip;
    }

    public String getAddressCountry() {
        return addressCountry;
    }

    public String getCvcCheck() {
        return cvcCheck;
    }

    public String getAddressLine1Check() {
        return addressLine1Check;
    }

    public String getAddressZipCheck() {
        return addressZipCheck;
    }

    public String getBrand() {
        return brand;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getFunding() {
        return funding;
    }

    public boolean isActive() {
        return active;
    }

    public int getAmount() {
        return amount;
    }

    public int getAmountReceived() {
        return amountReceived;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }
}
