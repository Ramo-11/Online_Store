package GUI.Frames.CustomerFrames;

import javax.swing.*;
import java.awt.event.*;

import Program.*;

public class PurchaseCartItemsFrame extends JFrame implements ActionListener {
    CustomerController controlCustomer;
    
    JButton confirmtationButton;
    
    PurchaseCartItemsFrame(String title, CustomerController controlCustomer) {
        super(title);
        this.controlCustomer = controlCustomer;
        
        setupFrame();
        setupButton();

        this.setVisible(true);
    }

    public void setupFrame() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setSize(400, 300);  // width = 400, height = 300
        this.setLayout(null);
    }

    public void setupButton() {
        confirmtationButton = new JButton("Confirm Purchase?");
        confirmtationButton.setBounds(100, 100, 150, 20);
        confirmtationButton.setFocusable(false);
        confirmtationButton.addActionListener(this);
        this.add(confirmtationButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(controlCustomer.getCustomer().getShoppingCart().getProducts().size() == 0)
            JOptionPane.showMessageDialog(null, "Fail: Your shopping cart is empty", "Error", JOptionPane.ERROR_MESSAGE);

        else {
            controlCustomer.checkout();
            JOptionPane.showMessageDialog(null, "Success: Thank you for shopping with us", "Success", JOptionPane.INFORMATION_MESSAGE);
        }

        this.setVisible(false);
        this.dispose();
    }
} // End class
