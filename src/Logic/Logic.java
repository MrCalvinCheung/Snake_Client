package Logic;

import SDK.Api;
import SDK.Game;
import SDK.Gamer;
import SDK.User;
import UI.Screen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Logic class
 * connects the Api and UI together
 *
 */
public class Logic {

    private Screen screen;
    private User currentUser;
    private Api api;
    private ArrayList<Game> games;
    private ArrayList<Game> gamestodelete;


    public Logic() {


        screen = new Screen();
        screen.setVisible(true);

        currentUser = new User();
        api = new Api();

    }

    /**
     * This method runs all my screens and starts the music
     * used in the main to startup my program
     */
    public void run() {
        screen.getlogin().addActionListener(new LoginActionListener());

        screen.getusermenu().addActionListener(new UserMenuActionListener());

        screen.getcreategame().addActionListener(new CreateGameActionListener());

        screen.getdeletegame().addActionListener(new DeleteGameActionListener());

        screen.getstartgame().addActionListener(new StartGameActionListener());

        screen.gethighscore().ActionListener(new HighscoreActionListener());

        screen.music();

    }

    /**
     * Login method
     * currentUser is checked over with how the password and username equals
     * goes through Login Api
     * @currentUser
     */
    private class LoginActionListener implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {

            currentUser.setUsername(screen.getlogin().getUsername().getText());
            currentUser.setPassword(screen.getlogin().getPassword().getText());


            String message = api.login(currentUser);
            JOptionPane.showMessageDialog(screen, message);
            if (message.equals("Login successful")) {
                screen.show(screen.UserMenu);
                screen.getcreategame().setUsers(api.getUsers());
                screen.getlogin().clearTextFields();
            }


        }
    }

    /**
     * Actionlistener for the At the user menu' buttons
     * Buttons at the menu
     */
    private class UserMenuActionListener implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
            /**
             * This method returns the games who can be deleted
             * which will be displayed in the combobox
             */
            if (e.getSource() == screen.getusermenu().getbtnDeleteGame()) {
                screen.show(screen.DeleteGame);
                gamestodelete = api.getGamesToDelete(currentUser.getId());
                screen.getdeletegame().setDeleteGames(gamestodelete);
            } else if (e.getSource() == screen.getusermenu().getBtnCreateGame()) {
                screen.show(screen.CreateGame);

                /**
                 * For loop that gets all the games the currentUser has been invited to play
                 */
            } else if (e.getSource() == screen.getusermenu().getBtnStartGame()) {
                screen.show(screen.StartGame);

                games = api.getGames(currentUser.getId());
                for (Game g : games)
                    g.getGameId();
                screen.getstartgame().setGames(games);

                /**
                 * Sets the highscore through the tablemodel
                 */

            } else if (e.getSource() == screen.getusermenu().getBtnHighscore()) {
                screen.show(screen.Highscore);
                screen.gethighscore().setTableModel(api.getHighscore());
            } else if (e.getSource() == screen.getusermenu().getBtnLogout()) {
                screen.show(screen.LOGIN);
                currentUser = new User();
            }
        }
    }


    /**
     * CreateGameActionListener contains the the method to Set the host, opponent and gamemapsize
     * For loop to get all the users who can be invited to games
     * return message
     */
    private class CreateGameActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == screen.getcreategame().getBtnMainMenu()) {
                screen.show(screen.UserMenu);

            } else if (e.getSource() == screen.getcreategame().getBtnCreateGame()) {
                Game game = new Game();
                Gamer host = new Gamer();
                Gamer opponent = new Gamer();

                game.setHost(host);
                game.setOpponent(opponent);
                game.setMapSize(500);

                host.setId(currentUser.getId());
                game.setName(screen.getcreategame().getgameName());

                for (User u : api.getUsers()) {

                    if (u.getUsername().equals(screen.getcreategame().getUsername())) {
                        opponent.setId(u.getId());
                        System.out.println(u.getId());
                    }
                }
                host.setControls(screen.getcreategame().getuserControls());

                String message = api.createGame(game);
                JOptionPane.showMessageDialog(screen, message);
                screen.show(screen.UserMenu);

            } else if (e.getSource() == screen.getstartgame().getBtnMainMenu())
                screen.show(screen.UserMenu);
        }

    }

    /**
     *  Delete game
     *  For loop to call on arraylist to display games that can be deleted in the combobox
     *  returns a message
     */
    private class DeleteGameActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == screen.getdeletegame().getBtnMainMenu()) {
                screen.show(screen.UserMenu);
            }

            else if (e.getSource()== screen.getdeletegame().getBtnDeleteGame()){
                Game game = new Game();
                for(Game g : gamestodelete){
                    if (g.getName().equals(screen.getdeletegame().getDeleteComboBox())){
                        game = g;
                    }
                }
                String message = api.DeleteGame(game.getGameId());
                JOptionPane.showMessageDialog(screen,message);
                if(message.equals("Game was deleted")){
                    screen.getdeletegame().removeGame();

                }
            }

        }
    }

    /**
     * Start game aka join game shows the pending games through a for loop
     * calls on api
     * returns a winner
     */

    private class StartGameActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == screen.getstartgame().getBtnStartGame()) {
                screen.show(screen.UserMenu);

                Game startGame = null;

                for (Game g : games) {
                    if (screen.getstartgame().getPendingGames().equals(g.getName())) {
                        startGame = g;
                    }
                }
                    startGame.getOpponent().setControls(screen.getstartgame().getopponentControls());

                    api.joinGame(startGame);
                    api.startGame(startGame);


                    for (User u : api.getUsers()) {
                        if (u.getId() == startGame.getWinner().getId()) {
                            startGame.getWinner().setUsername(u.getUsername()); //Set når man giver den en "værdi" og get når man henter noget fra objekt
                            //System.out.println(u.getUsername());
                        }

                    }

                JOptionPane.showMessageDialog(screen, "The winner is: " + startGame.getWinner().getUsername());
                screen.getstartgame().clearTextFields();
            } else if (e.getSource() == screen.getstartgame().getBtnMainMenu()) {
                screen.show(screen.UserMenu);
            }

        }
    }


    private class HighscoreActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {


            if (e.getSource() == screen.gethighscore().getBtnMainMenu()) {
                screen.show(screen.UserMenu);

            }
        }
    }
}




