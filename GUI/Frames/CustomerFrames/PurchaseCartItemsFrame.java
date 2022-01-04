package GUI.Frames.CustomerFrames;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;

import Program.*;

public class PurchaseCartItemsFrame extends JFrame implements ActionListener {
    Customer customer;
    CustomerController controlCustomer;
    
    JButton confirmtationButton;
    
    PurchaseCartItemsFrame(String title, Customer customer) {
        super(title);
        this.customer = customer;

        setupFrame();

        this.setVisible(true);
    }

    public void setupFrame() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setSize(900, 600);  // width = 900, height = 600
        this.setLayout(null);
    }

    public void setupButton() {
        confirmtationButton = new JButton("Confirm Purchase?");
        confirmtationButton.setBounds(300, 100, 70, 20);
        confirmtationButton.addActionListener(this);
        this.add(confirmtationButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controlCustomer.checkout();
        JOptionPane.showMessageDialog(null, "Success: Thank you for shopping with us", "Success", JOptionPane.INFORMATION_MESSAGE);
        this.setVisible(false);
        this.dispose();
    }
} // End class
