package SDK;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Created by Calvin on 29/10/2015.
 */
public class ServerConnection {

    public ServerConnection(){
        this.hostAddress = "http://localhost";
        this.port = 9998;
    }

    private String hostAddress;
    private int port;

    public void setHostAddress(String hostAddress) {
        this.hostAddress = hostAddress;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHostAddress() {
        return hostAddress;
    }

    public int getPort() {
        return port;
    }

    public String post(String json, String path){

        Client client = Client.create();
        System.out.println(getHostAddress() + ":" + getPort() + "/api/" + path);
        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").post(ClientResponse.class, json);

      //  if (response.getStatus() != 200 && response.getStatus() != 201) {
        //    throw new RuntimeException("Failed : HTTP error code : "
        //            + response.getStatus());
        //        }

        String output = response.getEntity(String.class);

        return output;

    }

    public String get(String path){

        Client client = Client.create();
        System.out.println(getHostAddress() + ":" + getPort() + "/api/" + path);
        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").get(ClientResponse.class);

        return response.getEntity(String.class);
    }
}
