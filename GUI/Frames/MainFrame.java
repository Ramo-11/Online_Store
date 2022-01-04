package GUI.Frames;

import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.JFrame;

import GUI.Buttons.*;
import GUI.Frames.AdminFrames.*;
import GUI.Frames.CustomerFrames.*;
import Program.*;

public class MainFrame extends JFrame implements ActionListener {

    AdminButton adminButton;
    CustomerLoginButton customerLoginButton;
    CustomerSignupButton customerSignupButton;

    AdminController controlAdmin;

    public MainFrame(String title) {
        super(title);

        Admin firstAdmin = new Admin("Admin", "12345");
        controlAdmin = new AdminController();
        controlAdmin.createAdmin(firstAdmin);
        
        setUpFrame();
        setUpButtons();

        this.setVisible(true);
    }

    public void setUpFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setSize(1000, 400);  // width = 1000, height = 400
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 200));
    }

    public void setUpButtons() {
        adminButton = new AdminButton("Admin Log In");
        customerLoginButton = new CustomerLoginButton("Customer Log In");
        customerSignupButton = new CustomerSignupButton("Create a new customer");

        adminButton.addActionListener(this);
        customerLoginButton.addActionListener(this);
        customerSignupButton.addActionListener(this);

        this.add(adminButton);
        this.add(customerLoginButton);
        this.add(customerSignupButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        this.setVisible(false);
        this.dispose();

       if(e.getSource() == adminButton) {
            Admin currentAccount = new Admin();
            AdminController controlAccount = new AdminController(); 
            new AdminLoginFrame("Get Credentials", currentAccount, controlAccount);
        }
        
        else if(e.getSource() == customerLoginButton) {
            CustomerController controlAccount = new CustomerController();
            new CustomerLoginFrame("Get Credentials", controlAccount);
        }

        else if(e.getSource() == customerSignupButton) {
            CustomerController controlAccount = new CustomerController();
            new CustomerSignupFrame("Get Credentials", controlAccount);
        }
    }
    
} // End class
