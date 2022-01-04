package Program;

import java.util.*;

public class Inventory {
    public ArrayList<Product> allProducts;

    public Inventory() {
        allProducts = new ArrayList<Product>();
    }

    public Inventory(ArrayList<Product> allProducts) {
        this.allProducts = allProducts;
    }

    public void addProduct(Product product) {
        allProducts.add(product);
    } // End addProduct Method

    public void removeProduct(Product product) {
        Product toRemove = new Product();

        for(Product p : allProducts)
            if(p.getName().equals(product.getName()))
                toRemove = p;

        allProducts.remove(toRemove);
    } // End removeProduct Method

    public void updateProduct(Product product) {
        for(Product p : allProducts)
            if(p.getID().equals(product.getID())) {
                p.setName(product.getName());
                p.setDescription(product.getDescription());
                p.setPrice(product.getPrice());
                p.setQuantity(product.getQuantity());
            }
    } // End updateProduct Method

    public void setProducts(ArrayList<Product> allProducts) {
        this.allProducts = allProducts;
    } // End setProducts Method

    public ArrayList<Product> getProducts() {
        return allProducts;
    }
    
    public void clearProducts() {
        allProducts.clear();
    }
}
