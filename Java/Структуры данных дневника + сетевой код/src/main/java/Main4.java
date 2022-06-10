import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class Main4 {

    public static void main(String a[]) throws IOException {

        /*URL obj = new URL(" http://78.47.187.129/Z4ZvXH31");
        URLConnection conn = obj.openConnection();
        /*
        //get all headers
        Map<String, List<String>> map = conn.getHeaderFields();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey() +
                    " ,Value : " + entry.getValue());
        }

        //get header by 'key'
        String server = conn.getHeaderField("Location");

        System.out.println(server);*/

        URL url = new URL("https://vk.com");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        System.out.println(connection.getResponseCode());

    }

}
