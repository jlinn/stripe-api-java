package net.joelinn.stripe.api;

import net.joelinn.stripe.Client;
import net.joelinn.stripe.request.tokens.CreateTokenRequest;
import net.joelinn.stripe.response.tokens.TokenResponse;

/**
 * User: Joe Linn
 * Date: 5/26/2014
 * Time: 12:18 AM
 */
public class Tokens extends AbstractApi{
    public Tokens(Client client) {
        super(client);
    }

    /**
     * Create a token
     * <a href="https://stripe.com/docs/api/curl#create_card_token">https://stripe.com/docs/api/curl#create_card_token</a>
     * <a href="https://stripe.com/docs/api/curl#create_bank_account_token">https://stripe.com/docs/api/curl#create_bank_account_token</a>
     */
    public TokenResponse createToken(CreateTokenRequest request){
        return client.post(buildUrl(), TokenResponse.class, request.toRequest());
    }

    /**
     * Retrieve a token
     * <a href="https://stripe.com/docs/api/curl#retrieve_token">https://stripe.com/docs/api/curl#retrieve_token</a>
     * @param tokenId the id of the token to retrieve
     */
    public TokenResponse getToken(String tokenId){
        return client.get(buildUrl(tokenId), TokenResponse.class);
    }

    protected String buildUrl(){
        return buildUrl(null);
    }

    protected String buildUrl(String tokenId){
        String url = "tokens";
        if(tokenId != null){
            url += "/" + tokenId;
        }
        return url;
    }
}
