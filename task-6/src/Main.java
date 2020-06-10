import javax.swing.*;

public class Main {
    private static JFrame frame;
    public static void main(String[] args) {
        //login
        initFrame();
    }

    private static void initFrame(){
        Login login = new Login();

        frame = new JFrame("Login window");
        frame.add(login.getLoginPanel());
        frame.setSize(400,400);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
