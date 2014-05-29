package net.joelinn.stripe.test;

import net.joelinn.stripe.Client;
import org.junit.Before;

/**
 * User: Joe Linn
 * Date: 5/21/2014
 * Time: 3:32 PM
 */
abstract public class StripeTestCase {
    protected static final String VISA_1 = "4242424242424242";
    protected static final String VISA_2 = "4012888888881881";
    protected static final String MASTERCARD_1 = "5555555555554444";
    protected static final String MASTERCARD_2 = "5105105105105100";
    protected static final String AMEX_1 = "378282246310005";
    protected static final String AMEX_2 = "371449635398431";
    protected static final String DISCOVER_1 = "6011111111111117";
    protected static final String DISCOVER_2 = "6011000990139424";
    protected static final String DINERS_CLUB_1 = "30569309025904";
    protected static final String DINERS_CLUB_2 = "38520000023237";
    protected static final String JCB_1 = "3530111333300000";
    protected static final String JCB_2 = "3566002020360505";

    protected static final String ROUTING_NUMBER = "110000000";
    protected static final String ACCOUNT_NUMBER = "000123456789";

    protected static final String CARD_DECLINED = "4000000000000002";
    protected static final String INCORRECT_NUMBER = "4242424242424241";
    protected static final String EXPIRED_CARD = "4000000000000069";
    protected static final String PROCESSING_ERROR = "4000000000000119";

    protected Client client;

    @Before
    public void setUpClient(){
        client = new Client("tGN0bIwXnHdwOa85VABjPdSn8nWY7G7I", true);
    }
}
