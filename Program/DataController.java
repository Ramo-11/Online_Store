package Program;

import java.io.*;
import java.util.*;

public class DataController implements Serializable {
    public void downloadAdminsData(ArrayList<Admin> admins) {
        String accountNum; 
        String name;
        String accountPin;

        try {
            File theFile = new File("listAdmins.txt");
            Scanner input = new Scanner(theFile);
            
            while (input.hasNextLine()) {
                name = input.nextLine();
                accountNum = input.nextLine();
                accountPin = input.nextLine();

                admins.add(new Admin(name, accountNum, accountPin));
            } // End while
            input.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } // End try catch
    } // End downloadAdminData Method
   
    public void uploadAdminData(ArrayList<Admin> admins) {
        try {
            FileWriter outFile = new FileWriter("listAdmins.txt", false);
            PrintWriter output = new PrintWriter(outFile);
                    
            for (int i = 0; i < admins.size(); i++) {
                if(i != 0) {
                    output.print("\n");
                }
                output.print(admins.get(i).getName());
                output.print("\n");
                output.print(admins.get(i).getAccountNum());
                output.print("\n");
                output.print(admins.get(i).getAccountPin());
            } // End for
            outFile.close();
            output.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } // End try catch    
    } // End uploadAdminData Method

    public void downloadUsersData(ArrayList<Customer> customers) {
        String accountNum; 
        String name;
        String accountPin;

        try {
            File theFile = new File("listCustomers.txt");
            Scanner input = new Scanner(theFile);
            
            while (input.hasNextLine()) {
                name = input.nextLine();
                accountNum = input.nextLine();
                accountPin = input.nextLine();
                customers.add(new Customer(name, accountNum, accountPin));
            } // End while
            input.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } // End try catch
    } // End downloadUserData Method
   
    public void uploadUserData(ArrayList<Customer> customers) {
        try {
            FileWriter outFile = new FileWriter("listCustomers.txt", false);
            PrintWriter output = new PrintWriter(outFile);
                    
            for (int i = 0; i < customers.size(); i++) {
                if(i != 0) {
                    output.print("\n");
                }
                output.print(customers.get(i).getName());
                output.print("\n");
                output.print(customers.get(i).getAccountNum());
                output.print("\n");
                output.print(customers.get(i).getAccountPin());
            } // End for
            outFile.close();
            output.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } // End try catch    
    } // End uploadUserData Method

    public void downloadProductsData(ArrayList<Product> products) {
        double price; 
        String ID;
        String name;
        String description;
        int quantity;

        try {
            File theFile = new File("listProducts.txt");
            Scanner input = new Scanner(theFile);
            
            while (input.hasNextLine()) {
                ID = input.nextLine();
                name = input.nextLine();
                if(!input.hasNextDouble())
                    break;
                price = input.nextDouble();
                input.nextLine();
                description = input.nextLine();
                if(!input.hasNextInt())
                    break;
                quantity = input.nextInt();
                if(input.hasNextLine())
                    input.nextLine();
                products.add(new Product(ID, name, price, description, quantity));
            } // End while
            input.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } // End try catch
    } // End downloadProductsData Method
   
    public void uploadProductsData(ArrayList<Product> products) {
        try {
            FileWriter outFile = new FileWriter("listProducts.txt", false);
            PrintWriter output = new PrintWriter(outFile);
                    
            for (int i = 0; i < products.size(); i++) {
                if(i != 0) {
                    output.print("\n");
                }
                output.println(products.get(i).getID());
                output.println(products.get(i).getName());
                output.println(products.get(i).getPrice());
                output.println(products.get(i).getDescription());
                output.print(products.get(i).getQuantity());
            } // End for
            outFile.close();
            output.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } // End try catch    
    }
        public void downloadCartData(Customer customer) {
            try{
                FileInputStream file = new FileInputStream(customer.getName() + "Cart");
                ObjectInputStream in = new ObjectInputStream(file);
    
                ShoppingCart cart = new ShoppingCart();
                cart = (ShoppingCart)in.readObject();

                customer.setShoppingCart(cart);
    
                in.close();
                file.close();
    
                System.out.println("Download is complete!\n");
            } catch(IOException ex) {
                System.out.println(ex.getMessage());
            } catch(ClassNotFoundException ex){
                System.out.println("Class not found exception was caught");
            } 
        } // End downloadProductsData Method
       
        public void uploadCartData(Customer customer) {
            try{
                FileOutputStream file = new FileOutputStream(customer.getName() + "Cart");
                ObjectOutputStream out = new ObjectOutputStream(file);
    
                out.writeObject(customer.getShoppingCart());
    
                out.close();
                file.close();
    
                System.out.println("Upload is complete!\n");
            } catch(IOException ex) {
                System.out.println("Exception caught in uploadCartData method");
            }
    } // End uploadProductsData Method
}
