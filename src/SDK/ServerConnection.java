package SDK;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Created by Calvin on 29/10/2015.
 * Server connection is the class where we make the methods to call api of the server
 * I use this to call the api, where we can use the methods created on the server
 */
public class ServerConnection {

    public ServerConnection(){

        this.hostAddress = "http://localhost";
        this.port = 8888;
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

    /**
     * post method sends data to server
     * @param json
     * @param path
     * @return a message
     */

    public String post(String json, String path){

        Client client = Client.create();
        System.out.println(getHostAddress() + ":" + getPort() + "/api/" + path);
        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").post(ClientResponse.class, json);

        String output = response.getEntity(String.class);

        return output;

    }

    /**
     * get method calls on server and gets information
     * @param path
     * @return data about users
     */

    public String get(String path){

        Client client = Client.create();
        System.out.println(getHostAddress() + ":" + getPort() + "/api/" + path);
        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").get(ClientResponse.class);

        return response.getEntity(String.class);
    }

    /**
     * put method updates data
     * @param path
     * @param json
     * @return updated informations through database
     */
    public String put(String path, String json) {


        Client client = Client.create();
        System.out.println(getHostAddress() + ":" + getPort() + "/api/" + path);
        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").put(ClientResponse.class, json);

        String output = response.getEntity(String.class);

        return output;


}

    /**
     * Delete method is used when data needs to be removed
     * @param path
     * @return a message
     */

    public String delete(String path) {

        Client client = Client.create();
        System.out.println(getHostAddress() + ":" + getPort() + "/api/" + path);
        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").delete(ClientResponse.class);

        return response.getEntity(String.class);
    }
}
