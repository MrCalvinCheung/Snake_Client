package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Login extends JPanel {
    private JTextField Username;
    private JPasswordField Password;
    private JButton btnLogin;
    private JLabel lblErrorMessage;

    /**
     * Create the panel.
     */
    public Login() {
        setLayout(null);
        setBounds(100, 100, 630, 388);

        JLabel lblSnake = new JLabel("Welcome to snake");
        lblSnake.setHorizontalAlignment(SwingConstants.CENTER);
        lblSnake.setBounds(192, 40, 245, 22);
        lblSnake.setFont(new Font("Lucida Grande", Font.BOLD, 25));
        add(lblSnake);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
        lblUsername.setFont(new Font("Lucida Grande", Font.BOLD,13));
        lblUsername.setBounds(269, 91, 91, 16);
        add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
        lblPassword.setFont(new Font("Lucida Grande",Font.BOLD,13));
        lblPassword.setBounds(269, 159, 91, 16);
        add(lblPassword);

        Username = new JTextField();
        Username.setBounds(240, 119, 149, 28);
        add(Username);
        Username.setColumns(10);

        btnLogin = new JButton("Login");
        btnLogin.setForeground(new Color(0, 128, 0));
        btnLogin.setBounds(240, 263, 149, 52);
        add(btnLogin);

        Password = new JPasswordField();
        Password.setBounds(240, 183, 149, 28);
        add(Password);

        lblErrorMessage = new JLabel("");
        lblErrorMessage.setForeground(Color.RED);
        lblErrorMessage.setBounds(192, 223, 245, 16);
        lblErrorMessage.setVisible(true);
        add(lblErrorMessage);

        JLabel Background = new JLabel("");
        Background.setIcon(new ImageIcon(Login.class.getResource("/res/Snake_Background.png")));
        Background.setBounds(0, 0, 630, 388);
        add(Background);
    }

    public JTextField getUsername() {

        return Username;
    }

    public JTextField getPassword() {

        return Password;
    }

    public void clearTextFields() {
        Username.setText("");
        Password.setText("");
        }

    public void addActionListener(ActionListener l){
        btnLogin.addActionListener(l);
    }





}

