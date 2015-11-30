package UI;

import SDK.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StartGame extends JPanel {
    private JButton btnStartGame;
    private JButton btnMainMenu;
    private JTextField textfield;
    private JComboBox comboBoxPending;

    /**
     * Create the panel.
     */
    public StartGame() {
        setLayout(null);
        setBounds(100, 100, 630, 388);

        JLabel lblNewLabel = new JLabel("Start Game");
        lblNewLabel.setBounds(262, 32, 106, 16);
        lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblNewLabel);

        btnStartGame = new JButton("Start Game");
        btnStartGame.setBounds(19, 70, 137, 54);
        add(btnStartGame);

        btnMainMenu = new JButton("Main Menu");
        btnMainMenu.setBounds(18, 136, 138, 50);
        add(btnMainMenu);

        comboBoxPending = new JComboBox();
        comboBoxPending.setBounds(334, 97, 231, 27);
        add(comboBoxPending);

        JLabel lblNewLabel_1 = new JLabel("Pending");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(421, 69, 61, 16);
        add(lblNewLabel_1);

        textfield = new JTextField();
        textfield.setBounds(232, 261, 151, 28);
        add(textfield);
        textfield.setColumns(10);

        JLabel lblUsewA = new JLabel("Use \"W, A, S, D\"");
        lblUsewA.setHorizontalAlignment(SwingConstants.CENTER);
        lblUsewA.setBounds(91, 267, 118, 16);
        add(lblUsewA);

        JLabel lblNewLabel_2 = new JLabel("Type in your moves");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(232, 233, 151, 16);
        add(lblNewLabel_2);
    }

    public void setGames(ArrayList<Game> games) {
        for (Game g : games) {
            comboBoxPending.addItem(g.getName());
        }
    }

    public String getPendingGames() {
        return (String) comboBoxPending.getSelectedItem();
    }


    public JButton getBtnStartGame() {
        return btnStartGame;
    }

    public JButton getBtnMainMenu(){
        return btnMainMenu;
    }

    public void addActionListener(ActionListener l) {

        btnStartGame.addActionListener(l);
        btnMainMenu.addActionListener(l);
    }
}
