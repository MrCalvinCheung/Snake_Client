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

    }

    public void setDeleteGames(ArrayList<Game> games) {
        DeleteGameComboBox.removeAllItems();
        for (Game g : games) {
            DeleteGameComboBox.addItem(g.getName());
        }
    }

    public String getDeleteComboBox() {
        return (String) DeleteGameComboBox.getSelectedItem();
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

    public void removeGame() {
        DeleteGameComboBox.removeItemAt(DeleteGameComboBox.getSelectedIndex());
    }
}
