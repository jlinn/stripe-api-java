package net.joelinn.stripe.response.plans;

import java.util.Map;

/**
 * User: Joe Linn
 * Date: 5/21/2014
 * Time: 4:15 PM
 */
public class PlanResponse {
    protected String id;

    protected String object;

    protected boolean livemode;

    protected int amount;

    protected long created; //TODO: deserialize to Date

    protected String currency;

    protected String interval;

    protected int intervalCount;

    protected String name;

    protected Map<String, Object> metadata;

    protected short trialPeriodDays;

    protected String statementDescriptor;

    public String getId() {
        return id;
    }

    public String getObject() {
        return object;
    }

    public boolean isLivemode() {
        return livemode;
    }

    public int getAmount() {
        return amount;
    }

    public long getCreated() {
        return created;
    }

    public String getCurrency() {
        return currency;
    }

    public String getInterval() {
        return interval;
    }

    public int getIntervalCount() {
        return intervalCount;
    }

    public String getName() {
        return name;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public short getTrialPeriodDays() {
        return trialPeriodDays;
    }

    public String getStatementDescriptor() {
        return statementDescriptor;
    }
}
