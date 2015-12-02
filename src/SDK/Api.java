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

        String jsondata = serverConnection.get("users");

        return new Gson().fromJson(jsondata, new TypeToken<ArrayList<User>>(){}.getType());

    }

    public ArrayList <Game> getGames(int userid){

        String jsondata = serverConnection.get("games/pending/"+ userid);
        return new Gson().fromJson(jsondata, new TypeToken<ArrayList<Game>>(){}.getType());

    }

    public String joinGame(Game game) {
        String jsondata = serverConnection.put("games/join",new Gson().toJson(game));
        return parseMessage(jsondata);

    }

    public String DeleteGame (int gameID) { //Sender et GAME ID(TAL) tilbage til serveren
        String jsondata = serverConnection.delete("games/"+gameID);
        return parseMessage(jsondata);

    }

    public ArrayList <Game> getGamesToDelete(int userid){

        String jsondata = serverConnection.get("games/host/"+ userid);

        return new Gson().fromJson(jsondata, new TypeToken<ArrayList<Game>>(){}.getType());
        }

    public String startGame (Game game) {
        String jsondata = serverConnection.put("games/start",new Gson().toJson(game));
        return parseMessage(jsondata);
    }

    public String createGame(Game game) {
        String jsondata = serverConnection.post(new Gson().toJson(game),"games");
        return parseMessage(jsondata);


    }

    public ArrayList<Game> getHighscore (String username, int userid) {
        String jsondata = serverConnection.get("scores/" +userid + username);

        return new Gson().fromJson(jsondata, new TypeToken<ArrayList<Game>>(){}.getType());
    }

    public String parseMessage(String message) {
        JSONParser parser = new JSONParser();
        try {
            Object object = parser.parse(message);
            JSONObject jsonobject = (JSONObject) object;

            message = (String) jsonobject.get("message");

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return message;
    }

}