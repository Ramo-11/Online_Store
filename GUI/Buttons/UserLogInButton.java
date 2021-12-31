package GUI.Buttons;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

public class UserLogInButton extends JButton {

    public UserLogInButton(String title) {
        ImageIcon icon = new ImageIcon("Images/userIcon.png");

        this.setText(title);
        this.setPreferredSize(new Dimension(140, 50));
        this.setFocusable(false);    // Removes highlight on text
        this.setForeground(Color.darkGray);  //set text color
        this.setIcon(icon);
    }
    
} // End class