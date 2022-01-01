package Program;

import java.util.*;

public class AdminController extends AccountController {

    public ArrayList<Admin> admins;
    public Inventory inventory;

    public AdminController() {
        super();

        this.admins = new ArrayList<Admin>();
        this.inventory = new Inventory();

        this.controlData.downloadAdminsData(admins);
        this.controlData.downloadProductsData(inventory.getProducts());
    }

    public boolean isLoginSuccessful(Admin currentAdmin) {
        if(!currentAdmin.login(admins, currentAdmin)) {
            System.out.println("\nLogging in failed");
            return false;
        }

        System.out.println("\nLogged in successfully");
        return true;
    }

    public void addProduct(Product newProduct) {
        inventory.addProduct(newProduct);
        controlData.uploadProductsData(inventory.getProducts());
    }

    public void removeProduct(Product productToRemove) {
        this.inventory.removeProduct(productToRemove);
        controlData.uploadProductsData(inventory.getProducts());
    }

    public Inventory getInventory() {
        return inventory;
    }
}
