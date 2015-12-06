package UI;

import SDK.Game;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DeleteGame extends JPanel {

    private JButton btnDeleteGame;
    private JButton btnMainMenu;
    private JComboBox DeleteGameComboBox;

    /**
     * Create the panel.
     * Create buttons
     */
    public DeleteGame() {
        setLayout(null);
        setBounds(100, 100, 630, 388);

        btnDeleteGame = new JButton("Delete Game");
        btnDeleteGame.setBounds(24, 32, 156, 45);
        add(btnDeleteGame);

        btnMainMenu = new JButton("Main Menu");
        btnMainMenu.setBounds(24, 97, 156, 45);
        add(btnMainMenu);

        DeleteGameComboBox = new JComboBox();
        DeleteGameComboBox.setBounds(237, 32, 238, 45);
        add(DeleteGameComboBox);

        JLabel Background = new JLabel("");
        Background.setIcon(new ImageIcon(Login.class.getResource("/res/Snake_Background.png")));
        Background.setBounds(0, 0, 630, 388);
        add(Background);
    }

    /**
     * Arraylist for all the games
     * @param games
     */
    public void setDeleteGames(ArrayList<Game> games) {
        DeleteGameComboBox.removeAllItems();
        for (Game g : games) {
            DeleteGameComboBox.addItem(g.getName());
        }
    }

    /**
     * to
     * @return usernames
     */
    public String getDeleteComboBox() {
        return (String) DeleteGameComboBox.getSelectedItem();
    }

    /**
     * Delete button for games
     * @return btnDeleteGame
     */
    public JButton getBtnDeleteGame() {
        return btnDeleteGame;
    }

    /**
     * A back to the main menu button
     * @return btnMainMenu
     */
    public JButton getBtnMainMenu() {
        return btnMainMenu;
    }

    /**
     * Actionlistener for buttons
     * @param l
     */

    public void addActionListener(ActionListener l) {

        btnDeleteGame.addActionListener(l);
        btnMainMenu.addActionListener(l);
    }

    /**
     * Method to remove an item from the combobox
     */
    public void removeGame() {
        DeleteGameComboBox.removeItemAt(DeleteGameComboBox.getSelectedIndex());
    }
}
