package UI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class UserMenu extends JPanel {


    private JButton btnStartGame;
    private JButton btnHighscore;
    private JButton btnLogOut;
    private JButton btnCreateGame;
    private JButton btnDeleteGame;
    private JLabel lblPleaseChooseAn;
    /**
     * Create the panel.
     */
    public UserMenu() {
        setLayout(null);
        setBounds(100, 100, 619, 388);

        JLabel Welcome = new JLabel("Main Menu");
        Welcome.setBounds(200, 28, 229, 27);
        Welcome.setHorizontalAlignment(SwingConstants.CENTER);
        Welcome.setFont(new Font("Lucida Grande", Font.BOLD, 22));
        add(Welcome);

        btnStartGame = new JButton("Start game");
        btnStartGame.setBounds(81, 116, 113, 62);
        add(btnStartGame);

        btnHighscore = new JButton("Highscore");
        btnHighscore.setBounds(170, 203, 113, 62);
        add(btnHighscore);

        btnLogOut = new JButton("Log Out");
        btnLogOut.setBounds(349, 203, 113, 62);
        add(btnLogOut);

        btnCreateGame = new JButton("Create Game");
        btnCreateGame.setBounds(258, 116, 113, 62);
        add(btnCreateGame);

        btnDeleteGame = new JButton("Delete Game");
        btnDeleteGame.setBounds(436, 116, 113, 62);
        add(btnDeleteGame);

        lblPleaseChooseAn = new JLabel("Please choose an option");
        lblPleaseChooseAn.setBounds(239, 67, 152, 16);
        add(lblPleaseChooseAn);

        JLabel Background = new JLabel("");
        Background.setIcon(new ImageIcon(Login.class.getResource("/res/Snake_Background.png")));
        Background.setBounds(0, 0, 630, 388);
        add(Background);

    }

    public JButton getBtnStartGame(){
        return btnStartGame;
    }
    public JButton getBtnHighscore(){
        return btnHighscore;
    }
    public JButton getBtnLogout(){
        return btnLogOut;
    }
    public JButton getBtnCreateGame(){
        return btnCreateGame;
    }
    public JButton getbtnDeleteGame(){
        return btnDeleteGame;
    }

    public void addActionListener(ActionListener l) {

        btnStartGame.addActionListener(l);
        btnHighscore.addActionListener(l);
        btnLogOut.addActionListener(l);
        btnCreateGame.addActionListener(l);
        btnDeleteGame.addActionListener(l);

    }
}
