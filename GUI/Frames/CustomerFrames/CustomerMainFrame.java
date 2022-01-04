package GUI.Frames.CustomerFrames;

import java.awt.event.*;
import javax.swing.*;
import GUI.Frames.Frame;

import Program.*;

public class CustomerMainFrame extends JFrame implements ActionListener {
    JButton browseProductsButton;
    JButton viewShoppingCart;
    JButton purchaseItemsInCart;
    JButton removeProductButton;
    JButton createcustomerButton;
    JButton createCustomerButton;
    JButton removeCustomerButton;
    JButton backToMainFrame;

    CustomerController controlCustomer;

    CustomerMainFrame(String title, Customer customer) {
        super(title);
         
        controlCustomer = new CustomerController(customer);

        setupFrame();
        setupButtons();

        this.setVisible(true);
    }

    public void setupFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(700, 500);  // width = 700, height = 500
        this.setLayout(null);
    }

    public void setupButtons() {
        browseProductsButton = new JButton("Browse Products");
        viewShoppingCart = new JButton("View Shopping Cart");
        purchaseItemsInCart = new JButton("Purchase Items in Shopping Cart");;
        backToMainFrame = new JButton("<-- Main Menu");

        browseProductsButton.setBounds(200, 100, 300, 30);
        viewShoppingCart.setBounds(200, 220, 300, 30);
        purchaseItemsInCart.setBounds(200, 340, 300, 30);
        backToMainFrame.setBounds(20, 20, 120, 20);

        browseProductsButton.addActionListener(this);
        viewShoppingCart.addActionListener(this);
        purchaseItemsInCart.addActionListener(this);
        backToMainFrame.addActionListener(this);

        browseProductsButton.setFocusable(false);
        viewShoppingCart.setFocusable(false);
        purchaseItemsInCart.setFocusable(false);
        backToMainFrame.setFocusable(false);

        this.add(browseProductsButton);
        this.add(viewShoppingCart);
        this.add(purchaseItemsInCart);
        this.add(backToMainFrame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backToMainFrame) {
            this.setVisible(false);
            this.dispose();
            new Frame("Online Store");
        }
        else if(e.getSource() == browseProductsButton)
            new BrowseProductsFrame("Browse Products: " + controlCustomer.getCustomer().getName(), this.controlCustomer.getInventory().getProducts(), controlCustomer.getCustomer());
        else if(e.getSource() == viewShoppingCart)
            new ViewShoppingCartFrame("View Shopping Cart: " + controlCustomer.getCustomer().getName(), controlCustomer.getCustomer().getShoppingCart());
        else if(e.getSource() == purchaseItemsInCart)
            new PurchaseCartItemsFrame("Purchase Items in shopping cart: " + controlCustomer.getCustomer().getName(), controlCustomer.getCustomer());
    }
}
