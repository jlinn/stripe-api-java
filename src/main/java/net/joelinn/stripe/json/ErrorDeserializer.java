package net.joelinn.stripe.json;

import net.joelinn.stripe.response.ErrorResponse;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.*;

import java.io.IOException;

/**
 * User: Joe Linn
 * Date: 5/22/2014
 * Time: 12:45 PM
 */
public class ErrorDeserializer extends JsonDeserializer<ErrorResponse>{
    /**
     * Method that can be called to ask implementation to deserialize
     * JSON content into the value type this serializer handles.
     * Returned instance is to be constructed by method itself.
     * <p/>
     * Pre-condition for this method is that the parser points to the
     * first event that is part of value to deserializer (and which
     * is never JSON 'null' literal, more on this below): for simple
     * types it may be the only value; and for structured types the
     * Object start marker.
     * Post-condition is that the parser will point to the last
     * event that is part of deserialized value (or in case deserialization
     * fails, event that was not recognized or usable, which may be
     * the same event as the one it pointed to upon call).
     * <p/>
     * Note that this method is never called for JSON null literal,
     * and thus deserializers need (and should) not check for it.
     *
     * @param jp   Parsed used for reading JSON content
     * @param ctxt Context that can be used to access information about
     *             this deserialization activity.
     * @return Deserializer value
     */
    @Override
    public ErrorResponse deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
        mapper.configure(SerializationConfig.Feature.WRAP_ROOT_VALUE, true);
        JsonNode node = jp.readValueAs(JsonNode.class);
        if(node.isObject()){
            if(node.has("error")){
                JsonNode error = node.get("error");
                return (ErrorResponse) mapper.reader(ErrorResponse.class).readValue(error);
            }
        }
        return null;
    }
}
