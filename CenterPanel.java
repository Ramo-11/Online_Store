import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Buttons.*;

public class CenterPanel extends JPanel implements ActionListener{
    AdminButton adminButton;
    UserLogInButton userLogInButton;
    UserSignupButton userSignupButton;
    
    CenterPanel() {
        this.setSize(new Dimension(980, 780));  // height = 780
        //this.setBackground(Color.RED);

        adminButton = new AdminButton("Admin Log in");
        userLogInButton = new UserLogInButton("User Log in");
        userSignupButton = new UserSignupButton("User Sign Up");

        // adminButton.addActionListener(this);
        // userLogInButton.addActionListener(this);

        this.add(adminButton);
        this.add(userLogInButton);
        this.add(userSignupButton);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == adminButton) {
            clearPanel();
        }

        else if(e.getSource() == userLogInButton)
            System.out.println("User log in");
	}

    public void clearPanel() {
        this.removeAll();
        this.revalidate();
        this.repaint();
    }
}
