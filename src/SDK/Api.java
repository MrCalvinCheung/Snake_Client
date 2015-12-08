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

    /**
     * Serverconnection object to call on methods such as post, get, put, delete
     */

    ServerConnection serverConnection = new ServerConnection(); //Object af ServerConnection oprettes
    //Login metode kaldes her

    public String login(User user) { //når du kalder metoden, så skal den 'fodres' med et user objekt

        String message = "";

        String data = serverConnection.post(new Gson().toJson(user), "login/");
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

    /**
     * Gets all users in the database
     * @return arraylist
     */

//Kalder på spillerne jeg bruger i min combobox til at vise spillerne i min DB.
    public ArrayList <User> getUsers(){

        String jsondata = serverConnection.get("users/");

        return new Gson().fromJson(jsondata, new TypeToken<ArrayList<User>>(){}.getType());

    }

    /**
     * Gets all pending games of an user, based on id
     * @param userid
     * @return arraylist
     */
    //kaldet her gøre at når man har inviteret kan man afhente og deltage i spillet. Den kalder vha. userid
    public ArrayList <Game> getGames(int userid){

        String jsondata = serverConnection.get("games/pending/"+ userid);
        return new Gson().fromJson(jsondata, new TypeToken<ArrayList<Game>>(){}.getType());

    }

    /**
     * Finds a gameid and deletes the game if nothing goes wrong
     * @param gameID
     * @return message
     */
    public String DeleteGame (int gameID) { //Sender et GAME ID(TAL) tilbage til serveren
        String jsondata = serverConnection.delete("games/"+gameID);
        return parseMessage(jsondata);

        /**
         * Arraylist of host games, to delete
         */
    }
    //Arraylist af Game så spiller kan finde spil
    public ArrayList <Game> getGamesToDelete(int userid){

        String jsondata = serverConnection.get("games/host/"+ userid);

        return new Gson().fromJson(jsondata, new TypeToken<ArrayList<Game>>(){}.getType());
        }

    /**
     *  a call to the server to join the game, this only joins the game but does not start it.
     * @param game
     * @return
     */
    //StartGame metode oprettes her første kald er til at joine et spi
    public String joinGame(Game game) {
        String jsondata = serverConnection.put("games/join/",new Gson().toJson(game));
        return parseMessage(jsondata);
/**
 * Starts the game, but is dependable to joingame
 */
    }
    //andet kald er til at starte selve spillet
    public String startGame (Game game) {
        String jsondata = serverConnection.put("games/start/",new Gson().toJson(game));
        return parseMessage(jsondata);
    }

    /**
     * creates the games
     * @param game
     * @return parsemessage(jsondata)
     */
    public String createGame(Game game) {
        String jsondata = serverConnection.post(new Gson().toJson(game),"games");
        return parseMessage(jsondata);

    }

    /**
     * Arraylist of overall score, which calls on the new made method that displays who won most.
     * @return
     */
    //Henter et arraylist af alle scorerne, efter en masse ændringer i serveren
    public ArrayList<Score> getHighscore () {
        String jsondata = serverConnection.get("highscores/");
        return new Gson().fromJson(jsondata, new TypeToken<ArrayList<Score>>(){}.getType());
    }
    //Parse metode der kaldes på hvergang man skal hente Json.

    /**
     * method to make a JSON object that send to the server. Which is called on the other
     * @param message
     * @return message
     */
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