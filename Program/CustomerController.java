package Program;

public class CustomerController extends AccountController {
    public CustomerController() {
        super();

        this.controlData.downloadUsersData(customers);
    }

    public boolean isLoginSuccessful(Customer currentCustomer) {
        if(!currentCustomer.login(customers, currentCustomer)) {
            System.out.println("\nLogging in failed");
            return false;
        }

        System.out.println("\nLogged in successfully");
        return true;
    } // End isLoginSuccessful Method

    public void createAccount(Customer customer) {
        customers.add(customer);
        controlData.uploadUserData(customers);
    }
}
