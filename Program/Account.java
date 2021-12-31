package Program;

import java.util.Random;
import java.io.*;

public class Account {
    String name;
    int accountNum;
    int accountPin;

    protected DataController controller;
    protected Helpers helper;

    public Account() {
        name = "Default Name";
        accountNum = 0;
        accountPin = 0;
        controller = new DataController();
        helper = new Helpers();
    }

    public Account(String name, int accountNum, int accountPin) {
        this.name = name;
        this.accountNum = accountNum;
        this.accountPin = accountPin;
        controller = new DataController();
        helper = new Helpers();
    }

    public void setName(String name) {
        this.name = name;
    }

    // Generate a random number to be account number
    public void generateAccountNum() {
        Random random = new Random();
        this.accountNum = random.nextInt(100000);
    }

    public void setAccountPin(int accountPin) {
        this.accountPin = accountPin;
    }

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    public String getName() {
        return this.name;
    }

    public int getAccountNum() {
        return this.accountNum;
    }

    public int getAccountPin() {
        return this.accountPin;
    }
}
