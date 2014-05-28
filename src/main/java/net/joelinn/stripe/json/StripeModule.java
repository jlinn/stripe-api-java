package net.joelinn.stripe.json;

import net.joelinn.stripe.response.ErrorResponse;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.module.SimpleDeserializers;
import org.codehaus.jackson.map.module.SimpleModule;
import org.codehaus.jackson.map.module.SimpleSerializers;

import java.util.Date;

/**
 * User: Joe Linn
 * Date: 5/22/2014
 * Time: 11:57 AM
 */
public class StripeModule extends SimpleModule{
    private static final long serialVersionUID = 1L;

    public StripeModule(){
        super("StripeModule", new Version(1, 0, 0, ""));
    }

    @Override
    public void setupModule(SetupContext context) {
        super.setupModule(context);
        SimpleDeserializers deserializers = new SimpleDeserializers();
        deserializers.addDeserializer(Date.class, new UnixTimestampDeserializer());
        deserializers.addDeserializer(ErrorResponse.class, new ErrorDeserializer());

        context.addDeserializers(deserializers);

        SimpleSerializers serializers = new SimpleSerializers();
        serializers.addSerializer(Date.class, new UnixTimestampSerializer());

        context.addSerializers(serializers);
    }
}
