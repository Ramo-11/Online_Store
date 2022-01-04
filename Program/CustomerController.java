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
        if(quantity <= 0)
            return false;
            
        Product productToPurchase = new Product(product);
        productToPurchase.setQuantity(quantity);

        for(Product p : getInventory().getProducts())
            if(productToPurchase.getID().equals(p.getID()))
                if(productToPurchase.getQuantity() > p.getQuantity())
                    return false;

        customer.getShoppingCart().addProductToCart(productToPurchase);
        controlData.uploadCartData(customer);
        return true;
    }
    
    public void checkout() {
        // Subtract products from inventory products
        for(Product Cp : customer.getShoppingCart().getProducts()) {
            for(Product Ip : inventory.getProducts()) {
                if(Cp.getID().equals(Ip.getID())) {
                    Ip.setQuantity(Ip.getQuantity() - Cp.getQuantity());
                    if(Ip.getQuantity() == 0)
                        inventory.removeProduct(Ip);
                }
            }
        }
        // Remove all items in shopping cart
        customer.getShoppingCart().clearProducts();

        // Upload new products and shopping cart of user
        controlData.uploadProductsData(inventory.getProducts());
        controlData.uploadCartData(customer);
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }
}
