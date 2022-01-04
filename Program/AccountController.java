package Program;

import java.util.*;
import java.io.*;

public abstract class AccountController implements Serializable {
    ArrayList<Customer> customers;
    DataController controlData;
    Inventory inventory; 

    AccountController() {
        customers = new ArrayList<Customer>();
        controlData = new DataController();
        inventory = new Inventory();

        this.controlData.downloadProductsData(inventory.getProducts());
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
