package net.joelinn.stripe.response.sources;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.Date;
import java.util.Map;

/**
 * Created by veliko on 9/2/17
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SourceResponse {
    private String id;
    private String object;
    private int amount;
    private String clientSecret;
    private Date created;
    private String currency;
    private String flow;
    private boolean livemode;
    private String statementDescriptor;
    private String status;
    private String type;
    private String usage;
    private Map<String, Object> metadata;
    private Map<String, Object> owner;
    private Map<String, Object> receiver;
    private Map<String, Object> bitcoin;
    /*
    com.stripe.model.Source JSON: {
  "id": "src_1AxeeQ4yxxbz1ZGjMKgPcLOV",
  "object": "source",
  "amount": 1000,
  "client_secret": "src_client_secret_BKJGY0SYeEGN4QcwR8xMRBLq",
  "created": 1504370358,
  "currency": "usd",
  "flow": "receiver",
  "livemode": false,
  "metadata": {
  },
  "owner": {
    "address": null,
    "email": "jenny.rosen@example.com",
    "name": null,
    "phone": null,
    "verified_address": null,
    "verified_email": null,
    "verified_name": null,
    "verified_phone": null
  },
  "receiver": {
    "address": "test_1MBhWS3uv4ynCfQXF3xQjJkzFPukr4K56N",
    "amount_charged": 0,
    "amount_received": 0,
    "amount_returned": 0,
    "refund_attributes_method": "email",
    "refund_attributes_status": "missing"
  },
  "statement_descriptor": null,
  "status": "pending",
  "type": "bitcoin",
  "usage": "single_use",
  "bitcoin": {
    "address": "test_1MBhWS3uv4ynCfQXF3xQjJkzFPukr4K56N",
    "amount": 2371000,
    "amount_charged": 0,
    "amount_received": 0,
    "amount_returned": 0,
    "uri": "bitcoin:test_1MBhWS3uv4ynCfQXF3xQjJkzFPukr4K56N?amount=0.02371000"
  }
}
     */

    public String getId() {
        return id;
    }

    public String getObject() {
        return object;
    }

    public int getAmount() {
        return amount;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public Date getCreated() {
        return created;
    }

    public String getCurrency() {
        return currency;
    }

    public String getFlow() {
        return flow;
    }

    public boolean isLivemode() {
        return livemode;
    }

    public String getStatementDescriptor() {
        return statementDescriptor;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public String getUsage() {
        return usage;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public Map<String, Object> getOwner() {
        return owner;
    }

    public Map<String, Object> getReceiver() {
        return receiver;
    }

    public Map<String, Object> getBitcoin() {
        return bitcoin;
    }
}
