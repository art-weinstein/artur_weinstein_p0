package bankApp.dbtesting;

import bankApp.repositories.AccountRepo;
import bankApp.repositories.AccountRepoDBImpl;

import java.util.Scanner;

public class RegisterAccountTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        AccountRepo ar = new AccountRepoDBImpl();
        System.out.println("Register an account");
//        AccountService as = new AccountServiceImpl(ar);
//        System.out.println("enter id");
//        int id = scan.nextInt();
        System.out.println("Enter username");
        String username = scan.nextLine();
        System.out.println("Enter password");
        String password = scan.nextLine();
        System.out.println("Enter your available funds");
        double funds = scan.nextDouble();
//        String validation = String.valueOf(ar.login(username,password));

//        Account account = new Account();
        if (ar.addAccount(username, password, funds) != null && username != "" && password != "" ) {
            System.out.println("Account for " + username + " is registered!");

        } else {
            System.out.println("Please enter valid credentials");
        }
    }
}
