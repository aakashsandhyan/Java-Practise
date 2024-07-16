import com.oracle.javafx.jmx.json.JSONDocument;
import com.oracle.javafx.jmx.json.JSONReader;
import jdk.nashorn.internal.parser.JSONParser;
import netscape.javascript.JSObject;
import org.json.JSONObject;

public class ObjectSerialize {
    public static byte[] serialize(Object object){
        if(object == null) {
            return null;
        }

        JSONObject jsonObject = new JSONObject(object);
        return jsonObject.toString().getBytes();
    }
}
