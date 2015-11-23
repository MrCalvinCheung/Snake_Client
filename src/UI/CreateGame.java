package UI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Calvin on 19/11/2015.
 */
public class CreateGame extends JPanel {

    private JTextField gameName;
    private JButton btnCreateGame;
    private JButton btnMainMenu;
    /**
     * Create the panel.
     */
    public CreateGame() {
        setLayout(null);

        JLabel lblCreateGame = new JLabel("Create Game");
        lblCreateGame.setFont(new Font("Lucida Grande", Font.BOLD, 16));
        lblCreateGame.setHorizontalAlignment(SwingConstants.CENTER);
        lblCreateGame.setBounds(138, 27, 159, 50);
        add(lblCreateGame);

        JLabel lblGameName = new JLabel("Game name");
        lblGameName.setHorizontalAlignment(SwingConstants.CENTER);
        lblGameName.setBounds(43, 109, 93, 22);
        add(lblGameName);

        gameName = new JTextField();
        gameName.setBounds(159, 106, 151, 28);
        add(gameName);
        gameName.setColumns(10);

        btnCreateGame = new JButton("Create Game");
        btnCreateGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnCreateGame.setBounds(159, 146, 138, 50);
        add(btnCreateGame);

        btnMainMenu = new JButton("Main Menu");
        btnMainMenu.setBounds(159, 208, 138, 50);
        add(btnMainMenu);

    }

    public JButton getBtnCreateGame() {
        return btnCreateGame;
    }

    public JButton getBtnMainMenu() {
        return btnMainMenu;
    }

    public String getgameName(){
        return gameName.getText();
    }

    public void addActionListener(ActionListener l) {

        btnCreateGame.addActionListener(l);
        btnMainMenu.addActionListener(l);
    }
}

