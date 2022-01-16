package bankApp.app;
import bankApp.models.Account;
import javafx.scene.input.InputEvent;

import java.util.InputMismatchException;
import java.util.Scanner;

import static bankApp.models.Account.*;

//import static bankApp.models.AccountMethods.userLogin;

public class BankApp {
    public BankApp() {

    }

    static Account account = new Account();

    public static void main(String[] args) {
        //test to access account
//        AccountRepo ar = new AccountRepoDBImpl();
//        Account account = new Account();

        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the bank! Please register an account.");
        System.out.println("Press 1 to log in or 2 register");
        int logOrRegister;
        boolean reRun = true;
        boolean authenticated = false;
        while (reRun) {
            try {
                logOrRegister = scan.nextInt();
                if (logOrRegister == 1) {
                    //call login method
                    account.userLogin();
//                    commandInput();
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
                commandInput();
            }

        }

    }
}
