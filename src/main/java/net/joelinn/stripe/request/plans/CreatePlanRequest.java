package net.joelinn.stripe.request.plans;

import net.joelinn.stripe.request.Request;

import java.util.Map;

/**
 * User: Joe Linn
 * Date: 5/25/2014
 * Time: 5:23 PM
 */
public class CreatePlanRequest extends Request{
    protected String id;
    
    protected Integer amount;
    
    protected String currency;
    
    protected String interval;
    
    protected Integer intervalCount;
    
    protected String name;
    
    protected Integer trialPeriodDays;
    
    protected Map<String, Object> metadata;
    
    protected String statementDescription;

    public CreatePlanRequest(String id, Integer amount, String currency, String interval, String name) {
        this.id = id;
        this.amount = amount;
        this.currency = currency;
        this.interval = interval;
        this.name = name;
    }

    public CreatePlanRequest setIntervalCount(Integer intervalCount) {
        this.intervalCount = intervalCount;
        return this;
    }

    public CreatePlanRequest setTrialPeriodDays(Integer trialPeriodDays) {
        this.trialPeriodDays = trialPeriodDays;
        return this;
    }

    public CreatePlanRequest setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
        return this;
    }

    public CreatePlanRequest setStatementDescription(String statementDescription) {
        this.statementDescription = statementDescription;
        return this;
    }
}
