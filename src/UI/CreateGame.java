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
     * Create buttons
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
        lblUsers.setBounds(436, 81, 151, 16);
        add(lblUsers);

        JLabel lblusercontrols = new JLabel("Type in your moves");
        lblusercontrols.setHorizontalAlignment(SwingConstants.CENTER);
        lblusercontrols.setBounds(436, 181, 151, 16);
        add(lblusercontrols);

        JLabel lblcontrols = new JLabel();
        lblcontrols.setIcon(new ImageIcon(CreateGame.class.getResource("/res/control.png")));
        lblcontrols.setHorizontalAlignment(SwingConstants.CENTER);
        lblcontrols.setBounds(261, 166, 129, 86);
        add(lblcontrols);


        usercontrols = new JTextField();
        usercontrols.setBounds(436, 209, 151, 28);
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
        btnCreateGame.setForeground(new Color(0, 128, 0));
        btnCreateGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnCreateGame.setBounds(50, 50, 138, 50);
        add(btnCreateGame);

        btnMainMenu = new JButton("Main Menu");
        btnMainMenu.setBounds(50, 115, 138, 50);
        add(btnMainMenu);

        JLabel Background = new JLabel("");
        Background.setIcon(new ImageIcon(Login.class.getResource("/res/Snake_Background.png")));
        Background.setBounds(0, 0, 630, 388);
        add(Background);
    }

    /**
     * Button to creategame
     *
     * @return btnCreateGame
     */
    public JButton getBtnCreateGame() {
        return btnCreateGame;
    }

    /**
     * Main Menu button
     * @return btnMainMenu
     */

    public JButton getBtnMainMenu() {
        return btnMainMenu;
    }

    /**
     * Textfield to usernames
     * @return gameName.getText
     */
    public String getgameName(){
        return gameName.getText();
    }

    /**
     * String movement controls
     * @return user control movement textfield
     */

    public String getuserControls() {
        return usercontrols.getText();
    }

    /**
     * Get a array list of all users
     * @param users
     */
    public void setUsers(ArrayList<User>users){
        usercombobox.removeAllItems();
        for (User u: users) {
            usercombobox.addItem(u.getUsername());
        }
    }

    /**
     * Combobox to display usernames
     *
     * @return username
     */
    public String getUsername(){

        return (String) usercombobox.getSelectedItem();

    }

    /**
     * ActionListener for buttons to creategame and to get back to mainmenu
     * @param l
     */

    public void addActionListener(ActionListener l) {

        btnCreateGame.addActionListener(l);
        btnMainMenu.addActionListener(l);
    }

}
	
