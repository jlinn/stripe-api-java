package net.joelinn.stripe.json;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.*;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * User: Joe Linn
 * Date: 8/22/2014
 * Time: 11:39 AM
 */
public class StripeObjectDeserializer extends JsonDeserializer<Map<String, Object>>{
    protected static final String OBJECT_KEY = "object";
    
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
    public Map<String, Object> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        final JsonNode jsonNode = jp.readValueAsTree();

        Map<String, Object> parsed = new HashMap<String, Object>();

        if(!jsonNode.isObject()){
            throw new JsonParseException("Object expected.", jp.getCurrentLocation());
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, true);   //TODO: set to false
        mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
        mapper.registerModule(new StripeModule());

        if(jsonNode.has(OBJECT_KEY)){
            final JsonNode object = jsonNode.get(OBJECT_KEY);
            if(object.has(OBJECT_KEY)){
                final String objectType = object.get(OBJECT_KEY).asText();
                try{
                    final Class responseClass = findResponseClass(objectType);
                    parsed.put(OBJECT_KEY, mapper.convertValue(object, responseClass));
                }
                catch (IllegalArgumentException e){
                    // No enum value exists for the current object type. Fall back to a map.
                    parsed.put(OBJECT_KEY, mapper.readValue(object, new TypeReference<Map<String, Object>>() {}));
                } catch (ClassNotFoundException e) {
                    parsed.put(OBJECT_KEY, mapper.readValue(object, new TypeReference<Map<String, Object>>() {}));
                }
            }
        }
        Iterator<Map.Entry<String, JsonNode>> fields = jsonNode.getFields();
        while(fields.hasNext()){
            final Map.Entry<String, JsonNode> field = fields.next();
            final JsonNode value = field.getValue();
            if(field.getKey().equals(OBJECT_KEY)){
                continue;
            }
            if(value.isObject()){
                parsed.put(field.getKey(), mapper.readValue(value, new TypeReference<Map<String, Object>>() {}));
            }
            else if(value.isArray()){
                parsed.put(field.getKey(), mapper.readValue(value, new TypeReference<List<Object>>() {}));
            }
        }
        return parsed;
    }

    protected Class findResponseClass(final String objectType) throws ClassNotFoundException {
        final String className = "net.joelinn.stripe.response." + objectType + "s." + Character.toUpperCase(objectType.charAt(0)) + objectType.substring(1) + "Response";
        return Class.forName(className);
    }
}
