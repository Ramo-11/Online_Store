package Program;

import java.util.ArrayList;

public class Admin extends Account {

    public Admin() {
        super();
    }

    public Admin(String name, String accountNum, String accountPin) {
        super(name, accountNum, accountPin);
    }

    public boolean login(ArrayList<Admin> admins, Admin account) {
        for(int i = 0; i < admins.size(); i++)
            if((account.getName().equals(admins.get(i).getName())) && (account.getAccountPin().equals(admins.get(i).getAccountPin()))) {
                // Admin was found
                return true;
            }
            
        return false;
    }
}
