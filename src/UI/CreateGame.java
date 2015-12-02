package UI;

import SDK.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CreateGame extends JPanel {
    private JTextField gameName;
    private JTextField usercontrols;
    private JButton btnCreateGame;
    private JButton btnMainMenu;
    private JComboBox usercombobox;


    /**
     * Create the panel.
     */
    public CreateGame() {
        setLayout(null);
        setBounds(100, 100, 630, 388);

        JLabel lblCreateGame = new JLabel("Create Game");
        lblCreateGame.setFont(new Font("Lucida Grande", Font.BOLD, 16));
        lblCreateGame.setHorizontalAlignment(SwingConstants.CENTER);
        lblCreateGame.setBounds(235, 27, 159, 50);
        add(lblCreateGame);

        JLabel lblGameName = new JLabel("Game name");
        lblGameName.setHorizontalAlignment(SwingConstants.CENTER);
        lblGameName.setBounds(268, 78, 93, 22);
        add(lblGameName);

        JLabel lblUsers = new JLabel("Select opponent");
        lblUsers.setHorizontalAlignment(SwingConstants.CENTER);
        lblUsers.setBounds(489, 81, 106, 16);
        add(lblUsers);

        JLabel lblusercontrols = new JLabel("Type in your moves");
        lblusercontrols.setHorizontalAlignment(SwingConstants.CENTER);
        lblusercontrols.setBounds(243, 233, 129, 16);
        add(lblusercontrols);

        JLabel lblUsewA = new JLabel("Use \"W, A, S, D\"");
        lblUsewA.setHorizontalAlignment(SwingConstants.CENTER);
        lblUsewA.setBounds(91, 267, 118, 16);
        add(lblUsewA);

        usercontrols = new JTextField();
        usercontrols.setBounds(243, 273, 151, 28);
        add(usercontrols);
        usercontrols.setColumns(10);

        usercombobox = new JComboBox();
        usercombobox.setBounds(436, 109, 159, 27);
        add(usercombobox);


        gameName = new JTextField();
        gameName.setBounds(239, 106, 151, 28);
        add(gameName);
        gameName.setColumns(10);

        btnCreateGame = new JButton("Create Game");
        btnCreateGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnCreateGame.setBounds(50, 50, 138, 50);
        add(btnCreateGame);

        btnMainMenu = new JButton("Main Menu");
        btnMainMenu.setBounds(50, 115, 138, 50);
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

    public String getuserControls() {
        return usercontrols.getText();
    }

    public void setUsers(ArrayList<User>users){
        usercombobox.removeAllItems();
        for (User u: users) {
            usercombobox.addItem(u.getUsername());
        }
    }

    public String getUsername(){

        return (String) usercombobox.getSelectedItem();

    }


    public void addActionListener(ActionListener l) {

        btnCreateGame.addActionListener(l);
        btnMainMenu.addActionListener(l);
    }

}
	
