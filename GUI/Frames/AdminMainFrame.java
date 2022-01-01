package GUI.Frames;

import java.awt.event.*;
import javax.swing.*;

import Program.*;

public class AdminMainFrame extends JFrame implements ActionListener {
    JButton addProductButton;
    JButton updateProductButton;
    JButton removeProductButton;
    JButton createAdminButton;
    JButton createUserButton;
    JButton removeUserButton;

    Admin admin;

    AdminMainFrame(String title, Admin admin) {
        super(title + ": " + admin.getName());
        
        this.admin = admin;  
        
        setupFrame();
        setupButtons();

        this.setVisible(true);
    }

    public void setupFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(700, 900);  // width = 700, height = 900
        this.setLayout(null);
    }

    public void setupButtons() {
        addProductButton = new JButton("Add a Product");
        updateProductButton = new JButton("Update a Product");
        removeProductButton = new JButton("Remove a Product");
        createAdminButton = new JButton("Create an Admin Account");
        createUserButton = new JButton("Create a User Account");
        removeUserButton = new JButton("Remove a User Account");

        addProductButton.setBounds(200, 100, 300, 30);
        updateProductButton.setBounds(200, 220, 300, 30);
        removeProductButton.setBounds(200, 340, 300, 30);
        createAdminButton.setBounds(200, 460, 300, 30);
        createUserButton.setBounds(200, 580, 300, 30);
        removeUserButton.setBounds(200, 700, 300, 30);

        addProductButton.addActionListener(this);
        updateProductButton.addActionListener(this);
        removeProductButton.addActionListener(this);
        createAdminButton.addActionListener(this);
        createUserButton.addActionListener(this);
        removeUserButton.addActionListener(this);

        addProductButton.setFocusable(false);
        updateProductButton.setFocusable(false);
        removeProductButton.setFocusable(false);
        createAdminButton.setFocusable(false);
        createUserButton.setFocusable(false);
        removeUserButton.setFocusable(false);

        this.add(addProductButton);
        this.add(updateProductButton);
        this.add(removeProductButton);
        this.add(createAdminButton);
        this.add(createUserButton);
        this.add(removeUserButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}
