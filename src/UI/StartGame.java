package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StartGame extends JPanel {
    private JTable table;
    private JButton btnStartGame;
    private JButton btnMainMenu;
    /**
     * Create the panel.
     */
    public StartGame() {
        setLayout(null);

        JLabel lblNewLabel = new JLabel("Start Game");
        lblNewLabel.setBounds(175, 32, 106, 16);
        lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblNewLabel);

        table = new JTable();
        table.setBounds(185, 70, 235, 198);
        add(table);

        btnStartGame = new JButton("Start Game");
        btnStartGame.setBounds(19, 70, 137, 54);
        add(btnStartGame);

        btnMainMenu = new JButton("Main Menu");
        btnMainMenu.setBounds(18, 136, 138, 50);
        add(btnMainMenu);

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
