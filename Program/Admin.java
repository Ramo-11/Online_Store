package Program;

import java.util.ArrayList;

public class Admin extends Account {
    Inventory inventory;

    public Admin() {
        super();
        inventory = new Inventory();
    }

    public Admin(String name, String accountNum, String accountPin) {
        super(name, accountNum, accountPin);
        inventory = new Inventory();
    }

    public boolean login(ArrayList<Admin> admins, Admin account) {
        for(int i = 0; i < admins.size(); i++)
            if((account.getName().equals(admins.get(i).getName())) && (account.getAccountPin().equals(admins.get(i).getAccountPin()))) {
                // Admin was found
                return true;
            }
            
        return false;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
