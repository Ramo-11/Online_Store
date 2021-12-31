package GUI.Buttons;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

public class UserSignupButton extends JButton {

    public UserSignupButton(String title) {
        this.setText(title);
        this.setPreferredSize(new Dimension(140, 50));
        this.setFocusable(false);    // Removes highlight on text
        this.setForeground(Color.darkGray);  //set text color
    }
    
} // End class