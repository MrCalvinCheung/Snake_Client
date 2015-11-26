package Logic;

import SDK.Api;
import SDK.Game;
import SDK.Gamer;
import SDK.User;
import UI.Screen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Logic {

    private Screen screen;
    private User currentUser;
    private Api api;

    public Logic() {


        screen = new Screen();
        screen.setVisible(true);

        currentUser = new User();
        api = new Api();

    }

    public void run() {
        screen.getlogin().addActionListener(new LoginActionListener());

        screen.getusermenu().addActionListener(new UserMenuActionListener());

        screen.getcreategame().addActionListener(new CreateGameActionListener());

        screen.getdeletegame().addActionListener(new UserActionListener());

        screen.getstartgame().addActionListener(new UserActionListener());

        screen.gethighscore().ActionListener(new UserActionListener());

        //screen.getgamepanel().addActionListener(new UserActionListener());
        //screen.show(screen.GamePanel);

    }

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

    private class UserMenuActionListener implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == screen.getusermenu().getbtnDeleteGame()) {
                screen.show(screen.DeleteGame);
            } else if (e.getSource() == screen.getusermenu().getBtnCreateGame()) {
                screen.show(screen.CreateGame);
            } else if (e.getSource() == screen.getusermenu().getBtnStartGame()) {
                screen.show(screen.StartGame);
            } else if (e.getSource() == screen.getusermenu().getBtnHighscore()) {
                screen.show(screen.Highscore);
            } else if (e.getSource() == screen.getusermenu().getBtnLogout()) {
                screen.show(screen.LOGIN);
                currentUser = new User();
            }
        }
    }

    private class CreateGameActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == screen.getcreategame().getBtnMainMenu()) {
                screen.show(screen.UserMenu);



            }
            else if (e.getSource() == screen.getcreategame().getBtnCreateGame()){
                Game game = new Game();
                Gamer host = new Gamer();
                Gamer opponent = new Gamer();

                game.setHost(host);
                game.setOpponent(opponent);
                game.setMapSize(500);

                host.setId(currentUser.getId());
                game.setName(screen.getcreategame().getgameName());

                for (User u : api.getUsers()){

                    if (u.getUsername().equals(screen.getcreategame().getUsername())){
                        opponent.setId(u.getId());
                        System.out.println(u.getId());
                    }
                }
                host.setControls(screen.getcreategame().getuserControls());

                String message = api.createGame(game);
                JOptionPane.showMessageDialog(screen, message);

            }
        }
    }

    private class UserActionListener implements ActionListener {


        public void actionPerformed(ActionEvent e) {


            if (e.getSource() == screen.getdeletegame().getBtnMainMenu()) {
                screen.show(screen.UserMenu);

            } else if (e.getSource() == screen.getstartgame().getBtnMainMenu()) {
                screen.show(screen.UserMenu);
            } else if (e.getSource() == screen.getstartgame().getBtnStartGame()) {
                screen.show(screen.GamePanel);

            } else if (e.getSource() == screen.gethighscore().getBtnMainMenu()) {
                screen.show(screen.UserMenu);

            }


        }
    }
}



