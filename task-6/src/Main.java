import javax.swing.*;
import java.io.*;
import java.util.HashMap;

public class Main {
    private static File users = new File("users.txt");
    private static JFrame frame;
    static HashMap <String,char[]> passwords = new HashMap<>();
    public static void main(String[] args) {
        readUsers();

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

    private static void readUsers(){
        passwords.clear();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(users));
            String line = reader.readLine();
            int counter = 0;

            String username = "";
            char[] pass;
            while (line != null){
                if(counter % 2 == 0){
                    username = line;
                }
                else {
                    pass = line.toCharArray();
                    passwords.put(username,pass);
                }
                counter++;
                line = reader.readLine();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * saves given username and corresponding password to file
     * @param username username to save
     * @param password password to save
     */
    static void addUser(String username,char[] password){
        try {
            FileWriter writer = new FileWriter(users,true);
            writer.write(username + "\n");
            for (char c : password) {
                writer.write(c);
            }
            writer.write("\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        readUsers();
    }


}
