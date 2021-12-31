package Frames;

import java.awt.event.*;
import javax.swing.*;

import Program.*;

public class GetCredentialsFrame extends JFrame implements ActionListener {
    JLabel nameLabel;
    JLabel pinLabel;
    JTextField nameTextField;
    JTextField pinTextField;
    JButton submitButton;

    Account currentAccount;
    
    GetCredentialsFrame(String title, Account account) {
        super(title);
        this.currentAccount = account;

        setupFrame();
        setupTextFieldsAndButton();
        
        this.setVisible(true);
    }

    public void setupFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(540, 250);  // width = 540, height = 200
        this.setLayout(null);
    }

    public void setupTextFieldsAndButton() {
        nameLabel = new JLabel("Full name");
        pinLabel = new JLabel("Pin number");
        nameTextField = new JTextField();
        pinTextField = new JTextField();
        submitButton = new JButton("Submit");

        nameLabel.setBounds(100, 50, 130, 20);
        pinLabel.setBounds(300, 50, 130, 20);
        nameTextField.setBounds(100, 70, 130, 25);
        pinTextField.setBounds(300, 70, 130, 25);
        submitButton.setBounds(215, 110, 100, 20);

        submitButton.addActionListener(this);
        submitButton.setFocusable(false);

        this.add(nameLabel);
        this.add(pinLabel);
        this.add(submitButton);
        this.add(nameTextField);
        this.add(pinTextField);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Verify that input is a 5 digit number
            Integer.parseInt(pinTextField.getText());
            if(pinTextField.getText().length() != 5)
                throw new NumberFormatException();

            this.currentAccount.setName(nameTextField.getText());
            this.currentAccount.setAccountPin(pinTextField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid Input: Pin must be a 5 digit number", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
} // End class
