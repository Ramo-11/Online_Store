package Program;

import java.util.*;

public class ShoppingCart {
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
