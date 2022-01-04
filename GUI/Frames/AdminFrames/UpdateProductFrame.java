package GUI.Frames.AdminFrames;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;

import Program.*;

public class UpdateProductFrame extends JFrame implements ActionListener {
    JTextField productIDTextField;  
    JTextField updatedInfoTextField;

    JLabel updatedInfoPrompt;
    JLabel promptLabel;
    JLabel productIDLabel;

    JButton nameButton;
    JButton descriptionButton;
    JButton priceButton;
    JButton quantityButton;
    JButton newSubmitButton;
    JButton submitButton;
    
    Product productToUpdate;
    AdminController controlAdmin;
    char toUpdate;

    UpdateProductFrame(String title, AdminController controlAdmin) {
        super(title);
        this.controlAdmin = controlAdmin;
        toUpdate = ' ';

        setupFrame();
        setupTextFieldsAndLabels();

        this.setVisible(true);
    }
    
    public void setupFrame() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setSize(750, 400);  // width = 750, height = 400
        this.setLayout(null);
    }

    public void setupTextFieldsAndLabels() {
        productIDTextField = new JTextField();
        productIDLabel = new JLabel("Product ID (5 alphanumeric characters)");
        submitButton = new JButton("Submit");

        productIDTextField.setBounds(300, 200, 120, 25);
        productIDLabel.setBounds(240, 170, 230, 25);
        submitButton.setBounds(310, 270, 100, 25);

        submitButton.addActionListener(this);
        submitButton.setFocusable(false);

        this.add(productIDTextField);
        this.add(productIDLabel);
        this.add(submitButton);
    }

    public void updateFrame() {
        clearFrame();

        newSubmitButton = new JButton("Submit");
        promptLabel = new JLabel("What would you like to update?");
        nameButton = new JButton("Name");
        descriptionButton = new JButton("Description");
        priceButton = new JButton("Price");
        quantityButton = new JButton("Quantity");

        promptLabel.setBounds(300, 100, 200, 25);
        nameButton.setBounds(100, 200, 120, 25);
        descriptionButton.setBounds(240, 200, 120, 25);
        priceButton.setBounds(380, 200, 120, 25);
        quantityButton.setBounds(520, 200, 120, 25);

        nameButton.setFocusable(false);
        descriptionButton.setFocusable(false);
        priceButton.setFocusable(false);
        quantityButton.setFocusable(false);

        nameButton.addActionListener(this);
        descriptionButton.addActionListener(this);
        priceButton.addActionListener(this);
        quantityButton.addActionListener(this);

        this.add(promptLabel);
        this.add(nameButton);
        this.add(descriptionButton);
        this.add(priceButton);
        this.add(quantityButton);
    }

    public void getUpdatedInfo(String labelTitle) {
        clearFrame();

        updatedInfoPrompt = new JLabel("Enter New " + labelTitle);
        updatedInfoTextField = new JTextField();

        updatedInfoPrompt.setBounds(300, 170, 120, 25);
        updatedInfoTextField.setBounds(300, 200, 120, 25);
        newSubmitButton.setBounds(310, 270, 100, 25);

        newSubmitButton.addActionListener(this);

        this.add(updatedInfoPrompt);
        this.add(updatedInfoTextField);
        this.add(newSubmitButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submitButton) {
            Boolean productFound = false;

            for(Product p : this.controlAdmin.getInventory().getProducts())
                if(productIDTextField.getText().equals(p.getID())) {
                    productToUpdate = new Product(p);
                    productFound = true;
                }

            if(productFound == false)
                JOptionPane.showMessageDialog(null, "Fail: Product was not found", "Fail", JOptionPane.WARNING_MESSAGE);

            else 
                updateFrame();
        }

        if(e.getSource() == nameButton) {
            getUpdatedInfo("Name");
            toUpdate = 'N';
        }
        else if(e.getSource() == descriptionButton) {
            getUpdatedInfo("Description");
            toUpdate = 'D';
        }
        else if(e.getSource() == priceButton) {
            getUpdatedInfo("Price");
            toUpdate = 'P';
        }
        else if(e.getSource() == quantityButton) {
            getUpdatedInfo("Quantity");
            toUpdate = 'Q';
        }

        if(e.getSource() == newSubmitButton) {
            if(toUpdate == 'N')
                productToUpdate.setName(updatedInfoTextField.getText());
            else if(toUpdate == 'D')
                productToUpdate.setDescription(updatedInfoTextField.getText());
            else if(toUpdate == 'P')
                productToUpdate.setPrice(Double.parseDouble(updatedInfoTextField.getText()));
            else if(toUpdate == 'Q')
                productToUpdate.setQuantity(Integer.parseInt(updatedInfoTextField.getText()));

            controlAdmin.updateProduct(productToUpdate);
            JOptionPane.showMessageDialog(null, "Success: Product has been updated", "Success", JOptionPane.INFORMATION_MESSAGE);

            toUpdate = ' ';
            this.setVisible(false);
            this.dispose();
        }
    }

    public void clearFrame() {
        this.getContentPane().removeAll();
        this.revalidate();
        this.repaint();
    }
}
