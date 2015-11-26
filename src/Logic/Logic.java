package Logic;

import SDK.Game;
import SDK.ServerConnection;
import SDK.User;
import UI.Screen;
import com.google.gson.Gson;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Logic {

    private Screen screen;
    private String username;
    private String password;
    private String message;


    public Logic() {


        screen = new Screen();
        screen.setVisible(true);


    }

    public void run() {
        screen.getlogin().addActionListener(new UserActionListener());

        screen.getusermenu().addActionListener(new UserActionListener());

        screen.getdeletegame().addActionListener(new UserActionListener());

        screen.getcreategame().addActionListener(new UserActionListener());

        screen.getstartgame().addActionListener(new UserActionListener());

        screen.gethighscore().ActionListener(new UserActionListener());

        //screen.getgamepanel().addActionListener(new UserActionListener());
        //screen.show(screen.GamePanel);

    }



    /*public String Login (Screen screen) {


        screen.getlogin().getUsername().getText();
        screen.getlogin().getPassword().getText();

        ServerConnection sc = new ServerConnection();

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        String Json = new Gson().toJson(user);

        sc.post(Json,"login/") ;

        return message;
    }*/

    private boolean Empty(String text) {
        if (text.equals("") || text.length() < 1 || text == null) {
            return true;
        } else
            return false;
    }


    private class UserActionListener implements ActionListener {


        public void actionPerformed(ActionEvent e) {
            String actCom = e.getActionCommand();
            if (actCom.equals("Login")) {

                String usernameField = screen.getlogin().getUsername().getText();
                String passwordField = screen.getlogin().getPassword().getText();
                screen.getlogin().getUsername().setText("");
                screen.getlogin().getPassword().setText("");

                if (Empty(usernameField) || Empty(passwordField)) {
                    screen.getlogin().setLblErrorMessage("Please type in Username and Password");
                } else {
                    screen.show(Screen.UserMenu);
                }

                } else if (e.getSource() == screen.getusermenu().getbtnDeleteGame()) {
                    screen.show(screen.DeleteGame);
                } else if (e.getSource() == screen.getdeletegame().getBtnMainMenu()) {
                    screen.show(screen.UserMenu);
                } else if (e.getSource() == screen.getusermenu().getBtnCreateGame()) {
                    screen.show(screen.CreateGame);
                } else if (e.getSource() == screen.getcreategame().getBtnMainMenu()) {
                    screen.show(screen.UserMenu);
                } else if (e.getSource() == screen.getusermenu().getBtnStartGame()) {
                    screen.show(screen.StartGame);
                } else if (e.getSource() == screen.getstartgame().getBtnMainMenu()) {
                    screen.show(screen.UserMenu);
                } else if (e.getSource() == screen.getstartgame().getBtnStartGame()) {
                    screen.show(screen.GamePanel);
                } else if (e.getSource() == screen.getusermenu().getBtnHighscore()) {
                    screen.show(screen.Highscore);
                } else if (e.getSource() == screen.gethighscore().getBtnMainMenu()) {
                    screen.show(screen.UserMenu);
                } else if (e.getSource() == screen.getusermenu().getBtnLogout()) {
                    screen.show(screen.LOGIN);
                }

            }

        }


    public static void createUser(User user) {

    }

    public static void deleteUser(int userId) {

    }

    public static void getUser(int userId) {

    }

    public static void getGame(int gameId) {

    }

    public static void joinGame(int gameId, User opponent, String controls) {

    }

    public static void startGame(int gameId) {

    }

    public static void createGame(String name, int status) {

        ServerConnection serverConnection = new ServerConnection();

        Game game = new Game();
        game.setName(name);
        //game.setHost();
        game.setStatus(status);

        String json = new Gson().toJson(game);

        serverConnection.post(json, "create");

    }

    public static void deleteGame(int gameId) {


    }

}
