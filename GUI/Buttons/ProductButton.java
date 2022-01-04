package GUI.Buttons;

import javax.swing.JButton;

import Program.*;

public class ProductButton extends JButton {
    Product product;

    public ProductButton(String title, Product product) {
        super(title);
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }
}
