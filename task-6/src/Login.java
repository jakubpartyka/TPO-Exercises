import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Login {
    private JPanel loginPanel;
    private JTextField loginTextField;
    private JPasswordField passwordPasswordField;
    private JButton logInButton;
    private JButton registerButton;
    private JButton quitButton;
    private JLabel status;

    Login() {
        logInButton.addActionListener(e -> {
            if(verifyLogin()){}
                //todo
            else {
                status.setForeground(Color.RED);
                status.setText("INCORRECT USERNAME / PASSWORD -> TRY AGAIN");
            }
        });
        quitButton.addActionListener(e -> System.exit(0));
    }

    private boolean verifyLogin() {
        String username = loginTextField.getText();
        char [] password = passwordPasswordField.getPassword();

        char [] correct = Main.passwords.get(username);

        return Arrays.equals(password,correct);
    }

    JPanel getLoginPanel() {
        return loginPanel;
    }

}
