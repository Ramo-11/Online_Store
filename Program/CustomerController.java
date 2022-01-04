package Program;

public class CustomerController extends AccountController {
    Customer customer;

    public CustomerController() {
        super();

        customer = new Customer();
        controlData.downloadUsersData(customers);
    }

    public CustomerController(Customer customer) {
        super();
        
        this.customer = customer;
        controlData.downloadUsersData(customers);
        controlData.downloadCartData(customer);
    }

    public void createAccount(Customer customer) {
        customers.add(customer);
        controlData.uploadUserData(customers);
    }

    public boolean isLoginSuccessful(Customer currentCustomer) {
        if(!currentCustomer.login(customers, currentCustomer)) {
            System.out.println("\nLogging in failed");
            return false;
        }

        System.out.println("\nLogged in successfully");
        return true;
    } // End isLoginSuccessful Method

    public boolean browseProducts(Product product, int quantity) {
        product.setQuantity(quantity);
        for(Product p : getInventory().getProducts())
            if(product.getID().equals(p.getID()))
                if(product.getQuantity() > p.getQuantity())
                    return false;

            customer.getShoppingCart().addProductToCart(product);
            controlData.uploadCartData(customer);
            return true;
    }
    
    public void checkout() {
        
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }
}
