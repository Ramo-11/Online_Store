package Program;

import java.util.ArrayList;
import java.io.*;

public class Customer extends Account implements Serializable {
    ShoppingCart cart;
    
    public Customer() {
        super();
        cart = new ShoppingCart();
    }

    public Customer(String name, String pin) {
        super(name, pin);
        this.name = name;
        this.accountPin = pin;
        cart = new ShoppingCart();
    }

    Customer(String name, String accountNum, String accountPin) {
        super(name, accountNum, accountPin);
        cart = new ShoppingCart();
    }

    public void setShoppingCart(ShoppingCart cart) {
        this.cart = cart;
    }
    
    public ShoppingCart getShoppingCart() {
        return cart;
    }

    public boolean login(ArrayList<Customer> customers, Customer account) {
        for(int i = 0; i < customers.size(); i++)
            if((account.getName().equals(customers.get(i).getName())) && (account.getAccountPin().equals(customers.get(i).getAccountPin()))) {
                // Customer was found
                return true;
            }

        System.out.println("\nCustomer was not found");
        helper.clearCredentials(account);
        return false;
    }
}
