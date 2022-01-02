package GUI.Frames.AdminFrames;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;

import Program.*;

public class CreateAdminAccountFrame extends JFrame implements ActionListener {
    JLabel nameLabel;
    JLabel pinLabel;
    JTextField nameTextField;
    JTextField pinTextField;
    JButton submitButton;

    Admin newAdmin;
    AdminController controlAdmin;

    CreateAdminAccountFrame(String title, AdminController controlAdmin) {
        super(title);
        this.controlAdmin = controlAdmin;
        newAdmin = new Admin();

        setupFrame();
        setupTextFieldsAndLabels();

        this.setVisible(true);
    }

    public void setupFrame() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setSize(540, 250);  // width = 540, height = 250
        this.setLayout(null);
    }

    public void setupTextFieldsAndLabels() {
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
            if(nameTextField.getText().matches("^\\d+(\\.\\d+)?"))
                throw new NotStringException();

            // Verify that pin input  is a 5 digit number
            Integer.parseInt(pinTextField.getText());
            if(pinTextField.getText().length() != 5)
                throw new NumberFormatException();

            newAdmin = new Admin(nameTextField.getText(), pinTextField.getText());
            controlAdmin.createAdmin(newAdmin);
            JOptionPane.showMessageDialog(null, "Success: Admin account has been created", "Success", JOptionPane.INFORMATION_MESSAGE);

            this.setVisible(false);
            this.dispose();

        } catch (NotStringException ex) {
            JOptionPane.showMessageDialog(null, "Invalid Input: Full name must be a string", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid Input: Pin must be a 5 digit number", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
} // End class
