package Program;

import java.util.UUID;

public class Product {
    String productID;
    String name;
    double price;
    String description;
    int quantity;

    public Product() {
        name = "Default";
        price = 0.0;
        description = "None";
        quantity = 0;
        productID = UUID.randomUUID().toString().substring(0, 5);
    }

    public Product(String name, double price, String description, int quantity) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        productID = UUID.randomUUID().toString().substring(0, 5);

    }

    public Product(String ID, String name, double price, String description, int quantity) {
        this.productID = ID;
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    public Product(Product product) {
        this.name = product.name;
        this.price = product.price;
        this.description = product.description;
        this.quantity = product.quantity;
        this.productID = product.productID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public String getDescription() {
        return this.description;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String getID() {
        return this.productID;
    }
    
    public String printProduct() {
       return "productID: " + getID() + "\nname: " + getName() + "\nprice: " + getPrice() + "\ndescription: " + getDescription() + "\nQuantity: " + getQuantity();
    }
}
