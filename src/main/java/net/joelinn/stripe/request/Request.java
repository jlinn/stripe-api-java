package net.joelinn.stripe.request;

import com.sun.jersey.core.util.MultivaluedMapImpl;
import org.codehaus.jackson.map.PropertyNamingStrategy;

import javax.ws.rs.core.MultivaluedMap;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Date;
import java.util.Map;

import static net.joelinn.stripe.request.RequestUtil.mapToRequest;

/**
 * User: Joe Linn
 * Date: 5/21/2014
 * Time: 4:30 PM
 */
abstract public class Request {
    public MultivaluedMap<String, String> toRequest(){
        return toRequest(this);
    }

    protected MultivaluedMap<String, String> toRequest(Request request){
        return toRequest(request, null);
    }

    @SuppressWarnings("unchecked")
    protected MultivaluedMap<String, String> toRequest(Request request, final String prefix){
        MultivaluedMapImpl map = new MultivaluedMapImpl();
        Class cls = request.getClass();
        PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy naming = new PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy();
        while(!cls.equals(Request.class)){
            for (Field field : cls.getDeclaredFields()) {
                try {
                    boolean inaccessible = false;
                    if(!Modifier.isPublic(field.getModifiers())){
                        field.setAccessible(true);
                        inaccessible = true;
                    }
                    Object fieldValue = field.get(this);
                    if(fieldValue != null){
                        String key = naming.translate(field.getName());
                        if(prefix != null){
                            key = prefix + "[" + key + "]";
                        }
                        if(fieldValue instanceof Map){
                            map.putAll(mapToRequest((Map) fieldValue, key));
                        }
                        else if(fieldValue instanceof Request){
                            map.putAll(((Request) fieldValue).toRequest());
                        }
                        else if(fieldValue instanceof Date){
                            map.add(key, dateToString((Date) fieldValue));
                        }
                        else{
                            map.add(key, String.valueOf(fieldValue));
                        }
                    }
                    if(inaccessible){
                        field.setAccessible(false);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            cls = cls.getSuperclass();
        }
        return map;
    }

    protected String dateToString(Date date){
        return String.valueOf(date.getTime() / 1000);
    }
}
