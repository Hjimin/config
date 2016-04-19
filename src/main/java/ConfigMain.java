import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.client.HttpClient;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by gurum on 16. 4. 19.
 */
public class ConfigMain {
    public static void main(String[] args) throws IOException {
        OpenstackConfig openstackConfig = new OpenstackConfig();
        try {
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost postRequest = new HttpPost("http://192.168.10.50:8181/jiminnn/gggg");

            postRequest.addHeader("accept", "application/json");
            JSONObject jsonObject = openstackConfig.readConfig();
            StringEntity input = new StringEntity(jsonObject.toJSONString());
            input.setContentType("application/json");
            postRequest.setEntity(input);

            HttpResponse response = httpClient.execute(postRequest);

            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            String output;
            System.out.println("============Output:============");

            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
