package UI;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class Screen extends JFrame {

    public static final String LOGIN = "Login123";
    public static final String UserMenu = "UserMenu123";
    public static final String DeleteGame = "DeleteGame123";
    public static final String CreateGame = "CreateGame123";
    public static final String StartGame = "StartGame123";
    public static final String GamePanel = "GamePanel123";
    public static final String Highscore = "Highscore123";



    private JPanel contentPane;
    private CardLayout c;
    private Login login;
    private UserMenu usermenu;
    private DeleteGame deletegame;
    private CreateGame creategame;
    private StartGame startgame;
    private Highscore highscore;


    /**
     * Create the frame.
     */
    public Screen() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 630, 388);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        contentPane.setLayout(new CardLayout(0,0));

        login = new Login();
        contentPane.add(login, LOGIN);

        usermenu = new UserMenu();
        contentPane.add(usermenu, UserMenu);

        deletegame = new DeleteGame();
        contentPane.add(deletegame, DeleteGame);

        creategame = new CreateGame();
        contentPane.add(creategame, CreateGame);

        startgame = new StartGame();
        contentPane.add(startgame, StartGame);

        highscore = new Highscore();
        contentPane.add(highscore, Highscore);

        c = (CardLayout) getContentPane().getLayout();


    }

    public Login getlogin() {
        return login;
    }

    public UserMenu getusermenu() {
        return usermenu;
    }

    public DeleteGame getdeletegame(){
        return deletegame;
    }

    public CreateGame getcreategame(){
        return creategame;
    }

    public StartGame getstartgame(){
        return startgame;
    }

    public Highscore gethighscore(){
        return highscore;
    }


    public void show(String card) {

        c.show(this.getContentPane(), card);
    }


}
	
	

