package Program;

import java.util.*;

public class AdminController extends AccountController {

    public ArrayList<Admin> admins;

    public AdminController() {
        super();

        this.admins = new ArrayList<Admin>();

        this.controlData.downloadAdminsData(admins);
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

    public void updateProduct(Product product) {
        inventory.updateProduct(product);
        controlData.uploadProductsData(inventory.getProducts());
    }

    public void createAdmin(Admin admin) {
        admins.add(admin);
        controlData.uploadAdminData(admins);
    }

    public void createCustomer(Customer customer) {
        customers.add(customer);
        controlData.uploadUserData(customers);
    }

    public void removeCustomer(Customer customer) {
        Customer toRemove = new Customer();

        for(Customer c : customers)
            if(c.getAccountNum().equals(customer.getAccountNum()))
                toRemove = c;

        customers.remove(toRemove);

        controlData.uploadUserData(customers);
    }
}
