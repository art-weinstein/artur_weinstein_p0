package bankApp.app;
import bankApp.models.Account;
//import bankApp.models.AccountMethods;
import bankApp.repositories.AccountRepo;
import bankApp.repositories.AccountRepoDBImpl;

import java.util.Scanner;

//import static bankApp.models.AccountMethods.userLogin;

public class BankApp {

    public static void main(String[] args) {
        //test to access account
//        AccountRepo ar = new AccountRepoDBImpl();
//        Account account = new Account();

        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the bank! Please register an account.");
        System.out.println("Press 1 to log in or 2 register");
        int logOrRegister = scan.nextInt();

        if(logOrRegister == 1){
            //call login method
            Account.userLogin();
        } else if (logOrRegister == 2){
            //call register method followed by login method
            Account.register();
            System.out.println("Please log in");
            Account.userLogin();
        }
    }
}
