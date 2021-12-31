package Program;

import java.util.concurrent.TimeUnit;
import java.util.*;
import java.io.*;

public class Helpers implements Serializable {
    public void Wait() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public void mainMenu() {
        System.out.println("--------------------------------Welcome to our online store--------------------------------\n");
        System.out.println("1- Sign in as admin");
        System.out.println("2- Sign in as user");
        System.out.println("3- Create an account\n");
    }

    public void clearCredentials(Account person) {
        person.setName("Default Name");
        person.setAccountPin(0);
        person.setAccountNum(0);
    }

    public int getUserNumInput() {
        Scanner helperScanner = new Scanner(System.in);
        int userChoice = 0;

        if(helperScanner.hasNextInt())
            userChoice = helperScanner.nextInt();

        else
            System.out.println("Input is invalid");

        return userChoice;
    }
} // End Class

