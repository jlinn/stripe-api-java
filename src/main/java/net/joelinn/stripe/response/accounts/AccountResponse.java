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

    protected boolean chargeEnabled;

    protected boolean transferEnabled;

    protected List<String> currenciesSupported;

    protected String defaultCurrency;

    protected String country;

    protected String object;

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

    public boolean isChargeEnabled() {
        return chargeEnabled;
    }

    public boolean isTransferEnabled() {
        return transferEnabled;
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
}
