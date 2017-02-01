package net.joelinn.stripe.response.accounts;

import java.util.List;

/**
 * User: Joe Linn
 * Date: 5/21/2014
 * Time: 3:26 PM
 */
public class AccountResponse {
    protected String id;

    protected String email;

    protected String statementDescriptor;

    protected String displayName;

    protected String timezone;

    protected boolean detailsSubmitted;

    protected boolean chargesEnabled;

    protected boolean transfersEnabled;

    protected boolean managed;

    protected List<String> currenciesSupported;

    protected String defaultCurrency;

    protected String businessLogo;

    protected String businessName;

    protected String businessUrl;

    protected String country;

    protected String object;

    protected String supportEmail;

    protected String supportPhone;

    public String getSupportEmail() {
        return supportEmail;
    }

    public String getSupportPhone() {
        return supportPhone;
    }

    public String getBusinessUrl() {
        return businessUrl;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getStatementDescriptor() {
        return statementDescriptor;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getTimezone() {
        return timezone;
    }

    public boolean isDetailsSubmitted() {
        return detailsSubmitted;
    }

    public boolean isChargesEnabled() {
        return chargesEnabled;
    }

    public boolean isTransfersEnabled() {
        return transfersEnabled;
    }

    public List<String> getCurrenciesSupported() {
        return currenciesSupported;
    }

    public String getDefaultCurrency() {
        return defaultCurrency;
    }

    public String getCountry() {
        return country;
    }

    public String getObject() {
        return object;
    }

    public String getBusinessLogo() {
        return businessLogo;
    }

    public String getBusinessName() {
        return businessName;
    }

    public boolean isManaged() {
        return managed;
    }
}
