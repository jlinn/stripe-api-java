package net.joelinn.stripe.request.cards;

import net.joelinn.stripe.request.Request;

/**
 * User: Joe Linn
 * Date: 5/21/2014
 * Time: 3:45 PM
 */
public class UpdateCardRequest extends Request{
    protected String addressCity;

    protected String addressCounty;

    protected String addressLine1;

    protected String addressLine2;

    protected String addressState;

    protected String addressZip;

    protected Short expMonth;

    protected Short expYear;

    protected String name;

    public UpdateCardRequest setAddressCity(String addressCity) {
        this.addressCity = addressCity;
        return this;
    }

    public UpdateCardRequest setAddressCounty(String addressCounty) {
        this.addressCounty = addressCounty;
        return this;
    }

    public UpdateCardRequest setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
        return this;
    }

    public UpdateCardRequest setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
        return this;
    }

    public UpdateCardRequest setAddressState(String addressState) {
        this.addressState = addressState;
        return this;
    }

    public UpdateCardRequest setAddressZip(String addressZip) {
        this.addressZip = addressZip;
        return this;
    }

    public UpdateCardRequest setExpMonth(short expMonth) {
        this.expMonth = expMonth;
        return this;
    }

    public UpdateCardRequest setExpYear(short expYear) {
        this.expYear = expYear;
        return this;
    }

    public UpdateCardRequest setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public String getAddressCounty() {
        return addressCounty;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getAddressState() {
        return addressState;
    }

    public String getAddressZip() {
        return addressZip;
    }

    public Short getExpMonth() {
        return expMonth;
    }

    public Short getExpYear() {
        return expYear;
    }

    public String getName() {
        return name;
    }

}
