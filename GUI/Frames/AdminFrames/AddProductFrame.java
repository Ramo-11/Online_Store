package GUI.Frames.AdminFrames;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;

import Program.*;

public class AddProductFrame extends JFrame implements ActionListener {
    JTextField nameTextField;
    JTextField priceTextField;
    JTextField descriptionTextField;
    JTextField quantityTextField;
    JLabel nameLabel;
    JLabel priceLabel;
    JLabel descriptionLabel;
    JLabel quantityLabel;
    JButton submitButton;
    
    AdminController controlAdmin;

    AddProductFrame(String title, AdminController controlAdmin) {
        super(title);
        this.controlAdmin = controlAdmin;

        setupFrame();
        setupTextFieldsAndLabels();

        this.setVisible(true);
    }
    
    public void setupFrame() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setSize(920, 400);  // width = 920, height = 400
        this.setLayout(null);
    }

    public void setupTextFieldsAndLabels() {
        nameTextField = new JTextField();
        priceTextField = new JTextField();
        descriptionTextField = new JTextField();
        quantityTextField = new JTextField();
        nameLabel = new JLabel("Product Name");
        priceLabel = new JLabel("Product Price");
        descriptionLabel = new JLabel("Product Description");
        quantityLabel = new JLabel("Product Quantity");
        submitButton = new JButton("Submit");

        nameTextField.setBounds(100, 200, 120, 25);
        priceTextField.setBounds(300, 200, 120, 25);
        descriptionTextField.setBounds(500, 200, 120, 25);
        quantityTextField.setBounds(700, 200, 120, 25);
        nameLabel.setBounds(100, 170, 120, 25);
        priceLabel.setBounds(300, 170, 120, 25);
        descriptionLabel.setBounds(500, 170, 120, 25);
        quantityLabel.setBounds(700, 170, 120, 25);
        submitButton.setBounds(400, 270, 100, 25);

        submitButton.addActionListener(this);
        submitButton.setFocusable(false);

        this.add(nameTextField);
        this.add(priceTextField);
        this.add(descriptionTextField);
        this.add(quantityTextField);
        this.add(nameLabel);
        this.add(priceLabel);
        this.add(descriptionLabel);
        this.add(quantityLabel);
        this.add(submitButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(nameTextField.getText().matches("^\\d+(\\.\\d+)?") || descriptionTextField.getText().matches("^\\d+(\\.\\d+)?"))
                throw new NotStringException();

            Product product = new Product(nameTextField.getText(),
                                        Double.parseDouble(priceTextField.getText()),
                                        descriptionTextField.getText(),
                                        Integer.parseInt(quantityTextField.getText()));
            controlAdmin.addProduct(product);
            JOptionPane.showMessageDialog(null, "Success: Product has been added", "Success", JOptionPane.INFORMATION_MESSAGE);
            
            this.setVisible(false);
            this.dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid Input: Price must be a number and quantity must be an integer", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
} // End class
