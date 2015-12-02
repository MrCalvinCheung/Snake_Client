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

    ServerConnection serverConnection = new ServerConnection(); //Object af ServerConnection oprettes


    public String login(User user) { //når du kalder metoden, så skal den 'fodres' med et user objekt

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

    public ArrayList <Game> getGames(int userid){

        String jsonofgames = serverConnection.get("games/pending/"+ userid);

        return new Gson().fromJson(jsonofgames, new TypeToken<ArrayList<Game>>(){}.getType());

    }

    public String joinGame(Game game) {
        String jsondata = serverConnection.put("games/join",new Gson().toJson(game));

        String message = "";

        JSONParser parser = new JSONParser();
        try {
            Object object = parser.parse(jsondata);
            JSONObject jsonobject = (JSONObject) object;

            message = (String) jsonobject.get("message");

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return message;

    }

    public String startGame (Game game) {
        String jsondata = serverConnection.put("games/start",new Gson().toJson(game));

        String message = "";

        JSONParser parser = new JSONParser();
        try {
            Object object = parser.parse(jsondata);
            JSONObject jsonobject = (JSONObject) object;

            if (jsonobject.get("message") !=null)

                message = (String) jsonobject.get("message");
            else {
                Game temp = new Gson().fromJson(jsondata, Game.class);
                game.setWinner(temp.getWinner());

            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return message;
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