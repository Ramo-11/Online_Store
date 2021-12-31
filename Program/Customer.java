package Program;

import java.util.ArrayList;

public class Customer extends Account {
    ShoppingCart cart;
    
    public Customer() {
        super();
        cart = new ShoppingCart();
    }

    Customer(String name, String accountNum, String accountPin) {
        super(name, accountNum, accountPin);
        cart = new ShoppingCart();
    }

    public ShoppingCart getShoppingCart() {
        return cart;
    }

    public boolean login(ArrayList<Customer> customers, Customer account) {
        for(int i = 0; i < customers.size(); i++)
            if((account.getName().equals(customers.get(i).getName())) && (account.getAccountPin() == customers.get(i).getAccountPin())) {
                // Customer was found
                return true;
            }

        System.out.println("\nCustomer was not found");
        helper.clearCredentials(account);
        return false;
    }
}
