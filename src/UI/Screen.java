package UI;

import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;
import java.net.URL;


public class Screen extends JFrame {

    public static final String LOGIN = "Login123";
    public static final String UserMenu = "UserMenu123";
    public static final String DeleteGame = "DeleteGame123";
    public static final String CreateGame = "CreateGame123";
    public static final String StartGame = "StartGame123";
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
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
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

    public void music()
    {
        try {

            // Open an audio input stream.
            URL url = this.getClass().getClassLoader().getResource("Audio/N.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            // Get a sound clip resource.
            Clip clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioIn);
            clip.start();
            // start()
// Loop()
            clip.loop(Clip.LOOP_CONTINUOUSLY);  // repeat forever
        } catch (UnsupportedAudioFileException e) {
            //e.printStackTrace();
        } catch (IOException e) {
            //e.printStackTrace();
        } catch (LineUnavailableException e) {
            //e.printStackTrace();
        }
    }

}
	
	

