package SDK;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;

/**
 * Created by Calvin on 09/11/2015.
 */
public class Api {

    ServerConnection serverConnection = new ServerConnection();


    public String login(User user) {

        String message = "";

        String data = serverConnection.post(new Gson().toJson(user), "login");
        JSONParser parser = new JSONParser();
        try {
            Object object = parser.parse(data);
            JSONObject jsonobject = (JSONObject) object;

            message = (String)jsonobject.get("message");

            if (jsonobject.get("userid") != null)
            user.setId((int)(long) jsonobject.get("userid")); //Long tvinger JSON til int

        } catch (ParseException e) {
            message = "You didn't type anything";
        }
        return message;
    }



    public ArrayList <User> getUsers(){

        String jsonOfUsers = serverConnection.get("users");

        return new Gson().fromJson(jsonOfUsers, new TypeToken<ArrayList<User>>(){}.getType());

    }

    public String createGame(Game game) {
        String jsondata = serverConnection.post(new Gson().toJson(game),"games");

        String message = "";

        JSONParser parser = new JSONParser();
        try {
            Object object = parser.parse(jsondata);
            JSONObject jsonobject = (JSONObject) object;

            message = (String)jsonobject.get("message");

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return message;


    }

    // public DeleteGame(Game gameid) {

    //     return serverConnection.post(new Gson().fromJson(gameid), "games");
    // }

}