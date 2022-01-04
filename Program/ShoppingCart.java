package Program;

import java.util.*;
import java.io.*;

public class ShoppingCart implements Serializable {
    ArrayList<Product> products;
    
    public ShoppingCart() {
        products = new ArrayList<Product>();
    }

    public ArrayList<Product> getProducts() {
        return this.products;
    }

    public void addProductToCart(Product product) {
        products.add(product);
    }
}
