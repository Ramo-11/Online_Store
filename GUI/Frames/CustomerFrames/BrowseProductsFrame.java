package GUI.Frames.CustomerFrames;

import java.util.ArrayList;
import javax.swing.*;

import GUI.Buttons.ProductButton;

import java.awt.FlowLayout;
import java.awt.event.*;

import Program.*;

public class BrowseProductsFrame extends JFrame implements ActionListener {
    Product userProduct;
    ArrayList<Product> products;
    ArrayList<ProductButton> buttons;
    CustomerController controlCustomer;
    Customer customer;

    JTextField quantityTextField;
    JLabel quantityLabel;
    JButton submitButton;
    JButton okayButton;
    
    BrowseProductsFrame(String title, ArrayList<Product> products, Customer customer) {
        super(title);
        this.userProduct = new Product();
        this.products = products;
        this.customer = customer;
        controlCustomer = new CustomerController(customer);

        setupFrame();
        createButtons();
        setupButton();

        this.setVisible(true);
    }

    public void setupFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setSize(900, 600);  // width = 900, height = 600
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 50));
    }

    public void setupButton() {
        okayButton = new JButton("Done");
        okayButton.setFocusable(false);
        okayButton.addActionListener(this);
        this.add(okayButton);
    }

    public void createButtons() {
        buttons = new ArrayList<ProductButton>();
        String space = "                               ";

        int i = 0;
        for(Product p : products)
            buttons.add(new ProductButton("Product " + (++i) + ":" + space + "name: " + p.getName() + space + "price: " + p.getPrice() + space + "description: " + p.getDescription()  + space + "quantity: " + p.getQuantity(), p));

        for(ProductButton l : buttons) {
            l.setFocusable(false);
            l.addActionListener(this);
            this.add(l);
        }
    }

    public void productQuantity() {
        clearFrame();
        this.setResizable(false);

        quantityTextField = new JTextField();
        quantityLabel = new JLabel("Enter Quantity");
        submitButton = new JButton("Submit");

        quantityTextField.setBounds(300, 200, 120, 25);
        quantityLabel.setBounds(280, 170, 230, 25);
        submitButton.setBounds(310, 270, 100, 25);

        submitButton.addActionListener(this);
        submitButton.setFocusable(false);

        this.add(quantityTextField);
        this.add(quantityLabel);
        this.add(submitButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(e.getSource() == okayButton) {
                this.setVisible(false);
                this.dispose();
            }

            else if(e.getSource() == submitButton) {
                int quantity = Integer.parseInt(quantityTextField.getText());
                if(controlCustomer.browseProducts(userProduct, quantity)) {
                    JOptionPane.showMessageDialog(null, "Success: Product has been added to your shopping cart", "Success", JOptionPane.INFORMATION_MESSAGE);
                    this.setVisible(false);
                    this.dispose();
                }
                else 
                    JOptionPane.showMessageDialog(null, "Invalid Input: quantity must not be greater than total quantity of the product", "Error", JOptionPane.ERROR_MESSAGE);
            }

            else {
                for(ProductButton p : buttons)
                    if(e.getSource() == p) {
                        userProduct = p.getProduct();
                        productQuantity();
                    }
            } 
        } catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid Input: quantity must be a number", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void clearFrame() {
        this.getContentPane().removeAll();
        this.revalidate();
        this.repaint();
    }
} // End class
