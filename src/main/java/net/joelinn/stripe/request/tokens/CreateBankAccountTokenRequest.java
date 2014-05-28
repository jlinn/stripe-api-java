package net.joelinn.stripe.request.tokens;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Joe Linn
 * Date: 5/26/2014
 * Time: 12:11 AM
 */
public class CreateBankAccountTokenRequest extends CreateTokenRequest{
    protected Map<String, Object> bankAccount;

    public CreateBankAccountTokenRequest(String country, String routingNumber, String accountNumber) {
        bankAccount = new HashMap<String, Object>();
        bankAccount.put("country", country);
        bankAccount.put("routing_number", routingNumber);
        bankAccount.put("account_number", accountNumber);
    }
}
