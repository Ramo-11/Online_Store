package GUI.Frames.AdminFrames;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;

import Program.*;

public class RemoveCustomerAccountFrame extends JFrame implements ActionListener {
    JLabel accountNumLabel;
    JTextField accountNumTextField;
    JButton submitButton;

    Customer customerToRemove;
    AdminController controlAdmin;

    RemoveCustomerAccountFrame(String title, AdminController controlAdmin) {
        super(title);
        this.controlAdmin = controlAdmin;
        customerToRemove = new Customer();

        setupFrame();
        setupTextFieldsAndLabels();

        this.setVisible(true);
    }

    public void setupFrame() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setSize(850, 400);  // width = 850, height = 400
        this.setLayout(null);
    }

    public void setupTextFieldsAndLabels() {
        accountNumLabel = new JLabel("Account Number");
        accountNumTextField = new JTextField();
        submitButton = new JButton("Submit");

        accountNumLabel.setBounds(300, 170, 120, 25);
        accountNumTextField.setBounds(300, 200, 120, 25);
        submitButton.setBounds(310, 270, 100, 25);

        submitButton.addActionListener(this);
        submitButton.setFocusable(false);

        this.add(accountNumLabel);
        this.add(accountNumTextField);
        this.add(submitButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Verify that account input is a 5 digit number
            Integer.parseInt(accountNumTextField.getText());
            if(accountNumTextField.getText().length() != 5)
                throw new NumberFormatException();

            customerToRemove.setAccountNum(accountNumTextField.getText());

            controlAdmin.removeCustomer(customerToRemove);
            JOptionPane.showMessageDialog(null, "Success: Customer account has been removed", "Success", JOptionPane.INFORMATION_MESSAGE);

            this.setVisible(false);
            this.dispose();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid Input: Pin must be a 5 digit number", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
} // End class
