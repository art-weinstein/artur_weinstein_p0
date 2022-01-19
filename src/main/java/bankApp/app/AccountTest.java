package bankApp.app;
import bankApp.models.Account;
import bankApp.repositories.AccountRepoDBImpl;
import bankApp.repositories.AccountRepo;
//import bankApp.services.AccountService;
//import bankApp.services.AccountServiceImpl;


import java.util.Date;
import java.util.Scanner;

public class AccountTest {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        AccountRepo ar = new AccountRepoDBImpl();
//        AccountService as = new AccountServiceImpl(ar);
//        System.out.println("enter id");
//        int id = scan.nextInt();
        System.out.println("Enter username");
        String username = scan.nextLine();
        System.out.println("Enter password");
        String password = scan.nextLine();
//        String validation = String.valueOf(ar.login(username,password));

//        Account account = new Account();
        if(ar.login(username, password) != null) {
//            System.out.println("Welcome" + username);
            System.out.println(" Welcome " + username);

        } else{
            System.out.println("Please enter valid credentials");
        }


        System.out.println(ar.login(username, password));

        System.out.println("====Login====");


    }


}