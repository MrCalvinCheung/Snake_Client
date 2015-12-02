package UI;

import SDK.Score;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Highscore extends JPanel {
    private JTable table;
    private JButton btnMainMenu;

    /**
     * Create the panel.
     */
    public Highscore() {
        setLayout(null);
        setBounds(100, 100, 630, 388);

        JLabel lblNewLabel = new JLabel("Highscore");
        lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(263, 19, 104, 31);
        add(lblNewLabel);

        table = new JTable();
        JScrollPane scrollpane = new JScrollPane(table);
        scrollpane.setBounds(131, 66, 367, 215);
        add(scrollpane);

        btnMainMenu = new JButton("Main Menu");
        btnMainMenu.setBounds(246, 293, 138, 50);
        add(btnMainMenu);

        JLabel Background = new JLabel("");
        Background.setIcon(new ImageIcon(Login.class.getResource("/res/Snake_Background.png")));
        Background.setBounds(0, 0, 630, 388);
        add(Background);
    }

    public JButton getBtnMainMenu(){
        return btnMainMenu;
    }

    public void setTableModel(ArrayList<Score> scores) {
        HighscoreTableModel tableModel = new HighscoreTableModel(scores);
        table.setModel(tableModel);

    }
    public void ActionListener(ActionListener l){
        btnMainMenu.addActionListener(l);
    }



}
