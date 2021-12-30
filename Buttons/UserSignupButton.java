package Buttons;

//import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class UserSignupButton extends JButton {

    public UserSignupButton(String title) {
        this.setText(title);
        this.setBounds(426, 300, 140, 50);
        this.setFocusable(false);    // Removes highlight on text
        this.setForeground(Color.darkGray);  //set text color
        //this.setBackground(Color.GREEN);
    }
    
} // End class