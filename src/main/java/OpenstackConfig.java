import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class OpenstackConfig {
    public JSONObject readConfig()
    {
        JSONParser parser = new JSONParser();
        try {

            Object obj = parser.parse(new FileReader(
                    "/home/gurum/csdncm/config/src/main/java/config.json"));

            JSONObject jsonObject = (JSONObject) obj;

//            String hostName = (String) jsonObject.get("hostName");
//            String publicNetworkIp = (String) jsonObject.get("publicNetworkIp");
//            String manageNetworkIp = (String) jsonObject.get("manageNetworkIp");
//            String dataNetworkIp = (String) jsonObject.get("dataNetworkIp");
//            String tunnelType = (String) jsonObject.get("tunnelType");
//            String nodeType = (String) jsonObject.get("nodeType");
//            System.out.println("name: " + hostName);
//            System.out.println("public: " + publicNetworkIp);
//            System.out.println("manage: " + manageNetworkIp);
//            System.out.println("data: " + dataNetworkIp);
//            System.out.println("tunnel: " + tunnelType);
//            System.out.println("node: " + nodeType);
            return jsonObject;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
