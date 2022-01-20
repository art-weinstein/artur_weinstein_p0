package bankApp.app;
import bankApp.models.Account;
import java.util.InputMismatchException;
import java.util.Scanner;

import static bankApp.models.Account.*;

public class BankApp {
    public BankApp() {

    }

    public static Account account = new Account();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        /*
        Program will start by prompting the user to log in or register. 1 will
        let the user log in, 2 will prompt them to register an account and set that
        account's initial funds
         */
        System.out.println("Welcome to the bank! Please register an account.");
        System.out.println("Press 1 to log in or 2 register");
        int logOrRegister;
        boolean reRun = true;
        boolean authenticated = false;
        while (reRun) {
            //Try catch will detect a mismatch and loop the user back until they enter valid data.
            try {
                logOrRegister = scan.nextInt();
                if (logOrRegister == 1) {
                    //call login method
                    account.userLogin();
                    reRun = false;
                    authenticated = true;
                } else if (logOrRegister == 2) {
                    //call register method followed by login method
                    account.register();
                    System.out.println("Please log in");
                    account.userLogin();
                    authenticated = true;

                    reRun = false;
                } else {
                    System.out.println("Please enter a valid input");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter 1 or 2");
                scan.next();
            }

            if (authenticated) {
                //commandInput method provides user with prompts to execute various methods to move money between accounts
                commandInput();
            }

        }

    }
}
