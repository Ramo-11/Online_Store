package Program;

import java.io.*;
import java.util.*;

public class DataController {
    public void downloadAdminsData(ArrayList<Admin> admins) {
        int accountNum; 
        String name;
        int accountPin;
        String endLine;

        try {
            File theFile = new File("listAdmins.txt");
            Scanner input = new Scanner(theFile);
            
            while (input.hasNextLine()) {
                name = input.nextLine();
                if(!input.hasNextInt())
                    break;
                accountNum = input.nextInt();
                endLine = input.nextLine();
                accountPin = input.nextInt();
                if(input.hasNextLine())
                    endLine = input.nextLine();
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
        int accountNum; 
        String name;
        int accountPin;
        String endLine;

        try {
            File theFile = new File("listUsers.txt");
            Scanner input = new Scanner(theFile);
            
            while (input.hasNextLine()) {
                name = input.nextLine();
                if(!input.hasNextInt())
                    break;
                accountNum = input.nextInt();
                endLine = input.nextLine();
                accountPin = input.nextInt();
                if(input.hasNextLine())
                    endLine = input.nextLine();
                customers.add(new Customer(name, accountNum, accountPin));
            } // End while
            input.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } // End try catch
    } // End downloadUserData Method
   
    public void uploadUserData(ArrayList<Customer> customers) {
        try {
            FileWriter outFile = new FileWriter("listUsers.txt", false);
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
        String name;
        String description;
        int quantity;
        String endLine;

        try {
            File theFile = new File("listProducts.txt");
            Scanner input = new Scanner(theFile);
            
            while (input.hasNextLine()) {
                name = input.nextLine();
                if(!input.hasNextDouble())
                    break;
                price = input.nextDouble();
                endLine = input.nextLine();
                description = input.nextLine();
                if(!input.hasNextInt())
                    break;
                quantity = input.nextInt();
                if(input.hasNextLine())
                    endLine = input.nextLine();
                products.add(new Product(name, price, description, quantity));
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
    } // End uploadProductsData Method
}
