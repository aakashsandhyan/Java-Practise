import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Driver {

    public static void main(String args[]) throws IOException {
        HttpClient httpClient = HttpClients.createDefault();
//        DefaultHttp httpClient = HttpClients.createDefault();


        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String today = date.format(formatter);


        String urlString = "http://cdn-api.co-vin.in/api/v2/appointment/sessions/public/calendarByDistrict?district_id=312&date=" + today;

        HttpGet getRequest = new HttpGet(urlString);
        getRequest.addHeader("Host", "https://apisetu.gov.in");

        try
        {
            HttpResponse response = httpClient.execute(getRequest);

//            CloseableHttpResponse response = httpClient.execute(getRequest);
            HttpEntity entity = response.getEntity();
//
            String inline = "";
            if(entity != null)
            {

                String apiOutput = EntityUtils.toString(entity);
                System.out.println(apiOutput);
                Scanner scanner = new Scanner(entity.getContent());
//                while (scanner.hasNext()) {
//                    System.out.println(scanner.nextLine());
////                    inline += scanner.nextLine();
//                }

            }
            JSONParser parse = new JSONParser();
//            JSONObject data_obj = (JSONObject) parse.parse(inline);

            System.out.println(entity.getContent());
//            JSONArray centers = (JSONArray) data_obj.get("centers");
//
//            for(int i = 0; i < centers.size(); i++)
//            {
//                JSONObject center = (JSONObject) centers.get(i);
//                System.out.println(center.get("center_id"));
//                System.out.println(center.get("name"));
//                System.out.println();
//            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
