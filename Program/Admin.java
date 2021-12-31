package Program;

import java.util.ArrayList;

public class Admin extends Account {
    public Admin() {
        super();
    }

    public Admin(String name, String accountNum, String accountPin) {
        super(name, accountNum, accountPin);
    }

    public boolean login(ArrayList<Admin> admins, Account account) {
        for(int i = 0; i < admins.size(); i++)
            if((account.getName().equals(admins.get(i).getName())) && (account.getAccountPin() == admins.get(i).getAccountPin())) {
                // User was found
                return true;
            }

        System.out.println("\nAdmin was not found");
        helper.clearCredentials(account);
        return false;
    }
}
