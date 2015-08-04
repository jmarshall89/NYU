import javax.swing.*;

/**
 * Created by jmarshall on 7/27/15.
 */
public class View extends JFrame {

    JLabel nameLabel = new JLabel("Search Last Name:");
    JTextField name = new JTextField(17);
    JLabel output = new JLabel("");
    JButton enter = new JButton("ENTER");
    JButton cancel = new JButton("CANCEL");

    public View() {

        setTitle("Enter a last name to search.");
        setBounds(150, 50, 280, 350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel pane = new JPanel();
        setContentPane(pane);




    }













    public String getUserInput() {
        String name;
//        code to get name
        name = "josh"; // testing
        return name;
    }
}
