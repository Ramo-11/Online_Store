package Program;

import java.util.*;

public abstract class AccountController {
    ArrayList<Customer> customers;
    Inventory inventory;
    DataController controlData;

    AccountController() {
        customers = new ArrayList<Customer>();
        inventory = new Inventory();
        controlData = new DataController();

        controlData.downloadProductsData(inventory.allProducts);
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}
