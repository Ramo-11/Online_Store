package Program;

import java.util.*;

public class AdminController {
    ArrayList<Admin> admins;
    ArrayList<Customer> customers;
    Inventory inventory;
    DataController controlData;

    AdminController() {
        admins = new ArrayList<Admin>();
        customers = new ArrayList<Customer>();
        inventory = new Inventory();
        controlData = new DataController();

        controlData.downloadProductsData(inventory.allProducts);
        controlData.downloadAdminsData(admins);
    }
}
