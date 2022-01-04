package Program;

import java.util.Random;
import java.io.*;

public abstract class Account implements Serializable {
    String name;
    String accountNum;
    String accountPin;

    protected DataController controller;

    public Account() {
        name = "Default Name";
        accountNum = "00000";
        accountPin = "00000";
        controller = new DataController();
    }

    public Account(String name, String accountPin) {
        this.name = name;
        this.accountPin = accountPin;
        generateAccountNum();
        controller = new DataController();
    }

    public Account(String name, String accountNum, String accountPin) {
        this.name = name;
        this.accountNum = accountNum;
        this.accountPin = accountPin;
        controller = new DataController();
    }

    public void setName(String name) {
        this.name = name;
    }

    // Generate a random number to be account number
    public void generateAccountNum() {
        Random random = new Random();
        this.accountNum = String.valueOf(random.nextInt(99999));
    }

    public void setAccountPin(String accountPin) {
        this.accountPin = accountPin;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getName() {
        return this.name;
    }

    public String getAccountNum() {
        return this.accountNum;
    }

    public String getAccountPin() {
        return this.accountPin;
    }

    public void clearAccount() {
        name = "Default Name";
        accountNum = "00000";
        accountPin = "00000";
    }
} // End Class
