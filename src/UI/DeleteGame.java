package UI;


import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by Calvin on 19/11/2015.
 */
public class DeleteGame extends JPanel{


    private JButton btnDeleteGame;
    private JButton btnMainMenu;

    /**
     * Create the panel.
     */
    public DeleteGame() {
        setLayout(null);

        btnDeleteGame = new JButton("Delete Game");
        btnDeleteGame.setBounds(24, 32, 156, 45);
        add(btnDeleteGame);

        btnMainMenu = new JButton("Main Menu");
        btnMainMenu.setBounds(24, 97, 156, 45);
        add(btnMainMenu);

        JComboBox DeleteGameComboBox = new JComboBox();
        DeleteGameComboBox.setBounds(242, 32, 156, 45);
        add(DeleteGameComboBox);

    }

    public JButton getBtnDeleteGame() {
        return btnDeleteGame;
    }
    public JButton getBtnMainMenu() {
        return btnMainMenu;
    }


    public void addActionListener(ActionListener l) {

        btnDeleteGame.addActionListener(l);
        btnMainMenu.addActionListener(l);
    }

}



