import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.*;

/*import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
*/



public class requests {
        private final String USER_AGENT = "Mozilla/5.0";
        public static void main(String[] args) throws Exception{
            String key[][]=null;
            String urlStart=null;
            requests http = new requests();
            System.out.println("Testing get");
            http.get(key,urlStart);
            System.out.println("Testing send");
            http.send();
        }
        public String helper(String key[][],String url)
        {
            String finalURL = url+"?";
            for(String row[]:key)
            {
                finalURL=finalURL+row[0]+"="+row[1]+"&";
            }
            finalURL=finalURL.substring(0, finalURL.length()-1);
            return finalURL;
        }
        public void get(String key[][], String urlStart) throws Exception{

            URL url = new URL(helper(key,urlStart));
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setRequestProperty("accept","application/json");
            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            //print result
            System.out.println(response.toString());
            
        }
        public void send() throws Exception{
            
        }
    }

