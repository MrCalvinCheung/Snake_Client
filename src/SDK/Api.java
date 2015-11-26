package SDK;

import UI.Screen;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import example.Config;

import java.util.ArrayList;

/**
 * Created by Calvin on 09/11/2015.
 */
public class Api {

    ServerConnection serverConnection = new ServerConnection();
    private String username;
    private String password;
    private String message;

    public String login(User user) {

        Screen screen = new Screen();

        screen.getlogin().getUsername().getText();
        screen.getlogin().getPassword().getText();

        user = new User();

        user.setUsername(username);
        user.setPassword(password);


        return serverConnection.post(new Gson().toJson(user), "login");

    }

    public ArrayList <User> getUsers(){

        String jsonOfUsers = serverConnection.get(Config.getServerAdresseAllUsers());

        return new Gson().fromJson(jsonOfUsers, new TypeToken<ArrayList<User>>(){}.getType());

    }

    // public DeleteGame(Game gameid) {

    //     return serverConnection.post(new Gson().fromJson(gameid), "games");
    // }

}