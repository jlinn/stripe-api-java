package net.joelinn.stripe.request;

import com.sun.jersey.core.util.MultivaluedMapImpl;

import javax.ws.rs.core.MultivaluedMap;
import java.util.Map;

/**
 * User: Joe Linn
 * Date: 5/23/2014
 * Time: 12:14 PM
 */
public class RequestUtil {
    public static MultivaluedMap<String, String> mapToRequest(final Map<String, Object> map, final String prefix){
        MultivaluedMap<String, String> request = new MultivaluedMapImpl();
        for (String key : map.keySet()) {
            request.add(prefix + "[" + key + "]", String.valueOf(map.get(key)));
        }
        return request;
    }
}
