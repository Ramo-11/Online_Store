package Program;

import java.util.*;

public abstract class AccountController {
    ArrayList<Customer> customers;
    DataController controlData;

    AccountController() {
        customers = new ArrayList<Customer>();
        controlData = new DataController();
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}
