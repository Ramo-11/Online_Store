package Frames;

import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.JFrame;

import GUI.Buttons.*;
//import Program.*;

public class Frame extends JFrame implements ActionListener {

    AdminButton adminButton;
    UserLogInButton userLogInButton;
    UserSignupButton userSignupButton;

    public Frame(String title) {
        super(title);

        setUpFrame();
        setUpButtons();

        this.setVisible(true);
    }

    public void setUpFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1000, 400);  // width = 1000, height = 400
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 200));
    }

    public void setUpButtons() {
        adminButton = new AdminButton("Admin Log In");
        userLogInButton = new UserLogInButton("User Log In");
        userSignupButton = new UserSignupButton("Create a new user");

        adminButton.addActionListener(this);
        userLogInButton.addActionListener(this);
        userSignupButton.addActionListener(this);

        this.add(adminButton);
        this.add(userLogInButton);
        this.add(userSignupButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == adminButton) {
            this.setVisible(false);
            this.dispose();
            new GetCredentialsFrame("something");
        }
        
        else if(e.getSource() == userLogInButton)
            System.out.println("Ok?");
    }
    
} // End class
