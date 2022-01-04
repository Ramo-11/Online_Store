package GUI.Frames.CustomerFrames;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;

import Program.*;

public class ViewShoppingCartFrame extends JFrame implements ActionListener {
    ArrayList<Product> products;

    JButton okayButton;
    
    ViewShoppingCartFrame(String title, ShoppingCart cart) {
        super(title);
        this.products = cart.getProducts();

        setupFrame();
        createLabels();
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

    public void createLabels() {
        ArrayList<JLabel> labels = new ArrayList<JLabel>();
        String space = "                               ";

        int i = 0;
        for(Product p : products)
            labels.add(new JLabel("Product " + (++i) + ":" + space + "name: " + p.getName() + space + "price: " + p.getPrice() + space + "description: " + p.getDescription()  + space + "quantity: " + p.getQuantity()));


        for(JLabel l : labels) {
            l.setFocusable(false);
            this.add(l);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
        this.dispose();
    }
} // End class
