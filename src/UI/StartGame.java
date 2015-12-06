package UI;

import SDK.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StartGame extends JPanel {
    private JButton btnStartGame;
    private JButton btnMainMenu;
    private JTextField opponentControls;
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
        btnStartGame.setForeground(new Color(0, 128, 0));
        btnStartGame.setBounds(54, 69, 137, 54);
        add(btnStartGame);

        btnMainMenu = new JButton("Main Menu");
        btnMainMenu.setBounds(53, 137, 138, 50);
        add(btnMainMenu);

        comboBoxPending = new JComboBox();
        comboBoxPending.setBounds(334, 97, 231, 27);
        add(comboBoxPending);

        JLabel lblNewLabel_1 = new JLabel("Pending");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(334, 69, 231, 16);
        add(lblNewLabel_1);

        opponentControls = new JTextField();
        opponentControls.setBounds(334, 213, 231, 28);
        add(opponentControls);
        opponentControls.setColumns(10);

        JLabel lblcontrols = new JLabel();
        lblcontrols.setIcon(new ImageIcon(CreateGame.class.getResource("/res/control.png")));
        lblcontrols.setHorizontalAlignment(SwingConstants.CENTER);
        lblcontrols.setBounds(193, 172, 129, 86);
        add(lblcontrols);

        JLabel lblusercontrols = new JLabel("Type in your moves");
        lblusercontrols.setHorizontalAlignment(SwingConstants.CENTER);
        lblusercontrols.setBounds(334, 185, 231, 16);
        add(lblusercontrols);

        JLabel Background = new JLabel("");
        Background.setIcon(new ImageIcon(Login.class.getResource("/res/Snake_Background.png")));
        Background.setBounds(0, 0, 630, 388);
        add(Background);
    }

    public String getopponentControls() {
        return opponentControls.getText();
    }

    public void setGames(ArrayList<Game> games) {
        comboBoxPending.removeAllItems();
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

    public void clearTextFields() {
        opponentControls.setText("");
    }

}
