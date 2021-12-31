package Program;

import java.util.ArrayList;

public class Customer extends Account {
    ShoppingCart cart;
    
    public Customer() {
        super();
        cart = new ShoppingCart();
    }

    Customer(String name, int accountNum, int accountPin) {
        super(name, accountNum, accountPin);
        cart = new ShoppingCart();
    }

    public ShoppingCart getShoppingCart() {
        return cart;
    }

    public boolean login(ArrayList<Customer> users, Account account) {
        for(int i = 0; i < users.size(); i++)
            if((account.getName().equals(users.get(i).getName())) && (account.getAccountPin() == users.get(i).getAccountPin())) {
                // Customer was found
                return true;
            }

        System.out.println("\nUser was not found");
        helper.clearCredentials(account);
        helper.Wait();
        return false;
    }
}
