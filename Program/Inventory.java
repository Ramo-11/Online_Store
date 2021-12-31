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

    public ArrayList<Product> getAllProducts() {
        return this.allProducts;
    } // End getAllProducts Method

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

    public void updateProduct(Product product, int itemNumber) {
        allProducts.get(itemNumber-1).setName(product.getName());
        allProducts.get(itemNumber-1).setPrice(product.getPrice());
        allProducts.get(itemNumber-1).setDescription(product.getDescription());
        allProducts.get(itemNumber-1).setQuantity(product.getQuantity());
    } // End updateProduct Method

    public void setProducts(ArrayList<Product> allProducts) {
        this.allProducts = allProducts;
    } // End setProducts Method

    public void printProducts() {
        int i = 1;
        for(Product p : allProducts) {
            System.out.println("\nItem " + i + ": \n" + p.printProduct());
            i++;
        }
    } // End printProducts Method
}
