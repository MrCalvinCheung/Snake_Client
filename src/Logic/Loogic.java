package Logic;

import SDK.Logic;
import UI.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Loogic {

    private Screen screen;
    private UserMenu usermenu;
    private DeleteGame deletegame;
    private CreateGame creategame;
    private StartGame startgame;
    private GamePanel gamepanel;
    private Highscore highscore;



    public Loogic() {




        screen = new Screen();
        screen.setVisible(true);

        usermenu = new UserMenu();
        usermenu.setVisible(true);

        deletegame = new DeleteGame();
        deletegame.setVisible(true);

        creategame = new CreateGame();
        creategame.setVisible(true);

        startgame = new StartGame();
        startgame.setVisible(true);

        gamepanel = new GamePanel();
        gamepanel.setVisible(true);

        highscore = new Highscore();
        highscore.setVisible(true);

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

    public boolean Empty (String text) {

        if (text.equals("") || text.length()<1|| text == null) {
            return true;
        }

        else {
            return false;
        }

    }



    private class UserActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e){

            if (e.getSource() == screen.getlogin().getBtnLogin()) {

                Login login = new Login();
                Logic logic = new Logic();
                logic.login(login.getUsername(), login.getPassword());


                screen.show(screen.UserMenu);

            }
            else if (e.getSource() == screen.getusermenu().getbtnDeleteGame()){
                screen.show(screen.DeleteGame);
            }
            else if (e.getSource() == screen.getdeletegame().getBtnMainMenu()){
                screen.show(screen.UserMenu);
            }

            else if (e.getSource() == screen.getusermenu().getBtnCreateGame()){
                screen.show(screen.CreateGame);
            }
            else if (e.getSource() == screen.getcreategame().getBtnMainMenu()){
                screen.show(screen.UserMenu);
            }
            else if (e.getSource() == screen.getusermenu().getBtnStartGame()){
                screen.show(screen.StartGame);
            }
            else if (e.getSource() == screen.getstartgame().getBtnMainMenu()){
                screen.show(screen.UserMenu);
            }
            else if (e.getSource() == screen.getstartgame().getBtnStartGame()){
                screen.show(screen.GamePanel);
            }
            else if (e.getSource() == screen.getusermenu().getBtnHighscore()){
                screen.show(screen.Highscore);
            }
            else if (e.getSource() == screen.gethighscore().getBtnMainMenu()){
                screen.show(screen.UserMenu);
            }
            else if (e.getSource() == screen.getusermenu().getBtnLogout()){
                screen.show(screen.LOGIN);
            }

        }

    }
}
	

