package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

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
        table.setBounds(131, 66, 367, 215);
        add(table);

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

    public void ActionListener(ActionListener l){
        btnMainMenu.addActionListener(l);
    }



}
