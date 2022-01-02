package GUI.Buttons;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

public class CustomerLoginButton extends JButton {

    public CustomerLoginButton(String title) {
        ImageIcon icon = new ImageIcon("GUI/Images/customerIcon.png");

        this.setText(title);
        this.setPreferredSize(new Dimension(200, 50));
        this.setFocusable(false);    // Removes highlight on text
        this.setForeground(Color.darkGray);  //set text color
        this.setIcon(icon);
    }
    
} // End class