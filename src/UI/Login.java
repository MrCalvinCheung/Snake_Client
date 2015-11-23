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
        lblUsername.setBounds(269, 91, 91, 16);
        add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
        lblPassword.setBounds(269, 159, 91, 16);
        add(lblPassword);

        Username = new JTextField();
        Username.setBounds(240, 119, 149, 28);
        add(Username);
        Username.setColumns(10);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(240, 263, 149, 52);
        add(btnLogin);

        Password = new JPasswordField();
        Password.setBounds(240, 183, 149, 28);
        add(Password);

        lblErrorMessage = new JLabel("");
        lblErrorMessage.setBounds(120, 269, 245, 16);
        add(lblErrorMessage);

    }

    public String getUsername() {
        return Username.getText();
    }

    public String getPassword() {
        String pw = new String(Password.getPassword());
        return pw;
    }

    public JButton getBtnLogin() {
        return btnLogin;
    }

    public void showLblErrorMessage(boolean visible, String message) {
        lblErrorMessage.setText(message);
        lblErrorMessage.setVisible(visible);
    }

    public void showLblErrorMessage(boolean visible){
        lblErrorMessage.setVisible(visible);
    }

    public void addActionListener(ActionListener l){
        btnLogin.addActionListener(l);
    }
    public void Password(){
        Password.setText("");
    }

    public void ClearTextField(){
        Password.setText("");
        Username.setText("");
    }

}
