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
}
