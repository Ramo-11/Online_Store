package GUI.Frames.AdminFrames;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;

import Program.*;

public class RemoveProductFrame extends JFrame implements ActionListener {
    JTextField productIDTextField;    
    JLabel productIDLabel;
    JButton submitButton;
    
    AdminController controlAdmin;

    RemoveProductFrame(String title, AdminController controlAdmin) {
        super(title);
        this.controlAdmin = controlAdmin;

        setupFrame();
        setupTextFieldsAndLabels();

        this.setVisible(true);
    }
    
    public void setupFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(850, 400);  // width = 850, height = 400
        this.setLayout(null);
    }

    public void setupTextFieldsAndLabels() {
        productIDTextField = new JTextField();
        productIDLabel = new JLabel("Product ID");
        submitButton = new JButton("Submit");

        productIDLabel.setBounds(300, 170, 120, 25);
        productIDTextField.setBounds(300, 200, 120, 25);
        submitButton.setBounds(310, 270, 100, 25);

        submitButton.addActionListener(this);
        submitButton.setFocusable(false);

        this.add(productIDTextField);
        this.add(productIDLabel);
        this.add(submitButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Boolean productFound = false;
        Product toRemove = new Product();

        for(Product p : this.controlAdmin.getInventory().getProducts())
            if(productIDTextField.getText().equals(p.getID())) {
                toRemove = p;
                productFound = true;
            }

        if(productFound == false)
            JOptionPane.showMessageDialog(null, "Fail: Product was not found", "Fail", JOptionPane.WARNING_MESSAGE);

        else {
            controlAdmin.removeProduct(toRemove);
            JOptionPane.showMessageDialog(null, "Success: Product has been removed", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
        
        this.setVisible(false);
        this.dispose();
    }
} // End class
