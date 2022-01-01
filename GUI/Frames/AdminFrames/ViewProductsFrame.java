package GUI.Frames.AdminFrames;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.event.*;

import Program.*;

public class ViewProductsFrame extends JFrame implements ActionListener {
    ArrayList<Product> products;

    JButton okayButton;
    
    ViewProductsFrame(String title, ArrayList<Product> products) {
        super(title);
        this.products = products;

        setupFrame();
        setupButton();
        createLabels();

        this.setVisible(true);
    }

    public void setupFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setSize(700, 600);  // width = 540, height = 250
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 50));
    }

    public void setupButton() {
        okayButton = new JButton("OK");
        okayButton.setFocusable(false);
        okayButton.addActionListener(this);
        this.add(okayButton);
    }

    public void createLabels() {
        ArrayList<JLabel> labels = new ArrayList<JLabel>();
        String space = "     ";

        JLabel emptyLabel = new JLabel();
        labels.add(emptyLabel);

        int i = 0;
        for(Product p : products)
            labels.add(new JLabel("Product " + (++i) + ":" + space + "name: " + p.getName() + space + "price: " + p.getPrice() + space + "description: " + p.getDescription() + space + "quantity: " + p.getQuantity()));


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
