package bankApp.dbtesting;
import bankApp.repositories.AccountRepoDBImpl;
import bankApp.repositories.AccountRepo;
//import bankApp.services.AccountService;
//import bankApp.services.AccountServiceImpl;


import java.util.Scanner;

public class AccountLoginTest {

    public static void main(String[] args) {
        AccountRepo ar = new AccountRepoDBImpl();

        String username = "art";
        String password = "password";



        if(ar.login(username, password) != null) {
            System.out.println(" Welcome " + username);

        } else{
            System.out.println("Please enter valid credentials");
        }


        System.out.println(ar.login(username, password));

        System.out.println("====Login====");

    }


}