package net.joelinn.stripe.request.charges;

import net.joelinn.stripe.request.Request;
import net.joelinn.stripe.request.cards.CreateCardRequest;

import java.util.Map;

/**
 * User: Joe Linn
 * Date: 5/23/2014
 * Time: 9:31 AM
 */
public class CreateChargeRequest extends Request{
    protected int amount;

    protected String currency;

    protected String customer;

    protected Object card;

    protected String description;

    protected Map<String, Object> metadata;

    protected Boolean capture;

    protected String statementDescription;

    protected Integer applicationFee;

    public CreateChargeRequest(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public CreateChargeRequest setCustomer(String customer) {
        this.customer = customer;
        return this;
    }

    public CreateChargeRequest setDescription(String description) {
        this.description = description;
        return this;
    }

    public CreateChargeRequest setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
        return this;
    }

    public CreateChargeRequest setCapture(Boolean capture) {
        this.capture = capture;
        return this;
    }

    public CreateChargeRequest setStatementDescription(String statementDescription) {
        this.statementDescription = statementDescription;
        return this;
    }

    public CreateChargeRequest setApplicationFee(Integer applicationFee) {
        this.applicationFee = applicationFee;
        return this;
    }

    public CreateChargeRequest setCard(String card){
        this.card = card;
        return this;
    }

    public CreateChargeRequest setCard(CreateCardRequest request){
        card = request;
        return this;
    }

    public int getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCustomer() {
        return customer;
    }

    public Object getCard() {
        return card;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public Boolean getCapture() {
        return capture;
    }

    public String getStatementDescription() {
        return statementDescription;
    }

    public Integer getApplicationFee() {
        return applicationFee;
    }
}
