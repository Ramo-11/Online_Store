package GUI.Frames.AdminFrames;

import java.awt.event.*;
import javax.swing.*;

import Program.*;

public class AdminMainFrame extends JFrame implements ActionListener {
    JButton viewAllProductsButton;
    JButton addProductButton;
    JButton updateProductButton;
    JButton removeProductButton;
    JButton createAdminButton;
    JButton createUserButton;
    JButton removeUserButton;

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
        createUserButton = new JButton("Create a User Account");
        removeUserButton = new JButton("Remove a User Account");

        viewAllProductsButton.setBounds(200, 100, 300, 30);
        addProductButton.setBounds(200, 220, 300, 30);
        updateProductButton.setBounds(200, 340, 300, 30);
        removeProductButton.setBounds(200, 460, 300, 30);
        createAdminButton.setBounds(200, 580, 300, 30);
        createUserButton.setBounds(200, 700, 300, 30);
        removeUserButton.setBounds(200, 820, 300, 30);

        viewAllProductsButton.addActionListener(this);
        addProductButton.addActionListener(this);
        updateProductButton.addActionListener(this);
        removeProductButton.addActionListener(this);
        createAdminButton.addActionListener(this);
        createUserButton.addActionListener(this);
        removeUserButton.addActionListener(this);

        viewAllProductsButton.setFocusable(false);
        addProductButton.setFocusable(false);
        updateProductButton.setFocusable(false);
        removeProductButton.setFocusable(false);
        createAdminButton.setFocusable(false);
        createUserButton.setFocusable(false);
        removeUserButton.setFocusable(false);

        this.add(viewAllProductsButton);
        this.add(addProductButton);
        this.add(updateProductButton);
        this.add(removeProductButton);
        this.add(createAdminButton);
        this.add(createUserButton);
        this.add(removeUserButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == viewAllProductsButton)
            new ViewProductsFrame("View Products", this.controlAdmin.inventory.getProducts());
        else if(e.getSource() == addProductButton)
            new AddProductFrame("Add a New Product", this.controlAdmin);
        else if(e.getSource() == removeProductButton)
            new RemoveProductFrame("Remove a Product", this.controlAdmin);
    }
}
