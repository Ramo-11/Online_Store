package GUI.Frames.AdminFrames;

import java.awt.event.*;
import javax.swing.*;
import GUI.Frames.Frame;

import Program.*;

public class AdminMainFrame extends JFrame implements ActionListener {
    JButton viewAllProductsButton;
    JButton addProductButton;
    JButton updateProductButton;
    JButton removeProductButton;
    JButton createAdminButton;
    JButton createCustomerButton;
    JButton removeCustomerButton;
    JButton backToMainFrame;

    Admin admin;
    AdminController controlAdmin;

    AdminMainFrame(String title, Admin admin) {
        super(title + ": " + admin.getName());
        
        this.admin = admin;  
        controlAdmin = new AdminController();

        setupFrame();
        setupButtons();

        this.setVisible(true);
    }

    public void setupFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(700, 950);  // width = 700, height = 900
        this.setLayout(null);
    }

    public void setupButtons() {
        viewAllProductsButton = new JButton("View All Products");
        addProductButton = new JButton("Add a Product");
        updateProductButton = new JButton("Update a Product");
        removeProductButton = new JButton("Remove a Product");
        createAdminButton = new JButton("Create an Admin Account");
        createCustomerButton = new JButton("Create a User Account");
        removeCustomerButton = new JButton("Remove a User Account");
        backToMainFrame = new JButton("<-- Main Menu");

        viewAllProductsButton.setBounds(200, 100, 300, 30);
        addProductButton.setBounds(200, 220, 300, 30);
        updateProductButton.setBounds(200, 340, 300, 30);
        removeProductButton.setBounds(200, 460, 300, 30);
        createAdminButton.setBounds(200, 580, 300, 30);
        createCustomerButton.setBounds(200, 700, 300, 30);
        removeCustomerButton.setBounds(200, 820, 300, 30);
        backToMainFrame.setBounds(20, 20, 120, 20);

        viewAllProductsButton.addActionListener(this);
        addProductButton.addActionListener(this);
        updateProductButton.addActionListener(this);
        removeProductButton.addActionListener(this);
        createAdminButton.addActionListener(this);
        createCustomerButton.addActionListener(this);
        removeCustomerButton.addActionListener(this);
        backToMainFrame.addActionListener(this);

        viewAllProductsButton.setFocusable(false);
        addProductButton.setFocusable(false);
        updateProductButton.setFocusable(false);
        removeProductButton.setFocusable(false);
        createAdminButton.setFocusable(false);
        createCustomerButton.setFocusable(false);
        removeCustomerButton.setFocusable(false);
        backToMainFrame.setFocusable(false);

        this.add(viewAllProductsButton);
        this.add(addProductButton);
        this.add(updateProductButton);
        this.add(removeProductButton);
        this.add(createAdminButton);
        this.add(createCustomerButton);
        this.add(removeCustomerButton);
        this.add(backToMainFrame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backToMainFrame) {
            this.setVisible(false);
            this.dispose();
            new Frame("Online Store");
        }
        else if(e.getSource() == viewAllProductsButton)
            new ViewProductsFrame("View Products", this.controlAdmin.getInventory().getProducts());
        else if(e.getSource() == addProductButton)
            new AddProductFrame("Add a New Product", this.controlAdmin);
        else if(e.getSource() == updateProductButton)
            new UpdateProductFrame("Update a Product", this.controlAdmin);
        else if(e.getSource() == removeProductButton)
            new RemoveProductFrame("Remove a Product", this.controlAdmin);
        else if(e.getSource() == createAdminButton)
            new CreateAdminAccountFrame("Create Admin Account", this.controlAdmin);
        else if(e.getSource() == createCustomerButton)
            new CreateCustomerAccountFrame("Create Customer Account", this.controlAdmin);
        else if(e.getSource() == removeCustomerButton)
            new RemoveCustomerAccountFrame("Remove Customer Account", this.controlAdmin);
    }
}
