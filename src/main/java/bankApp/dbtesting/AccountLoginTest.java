package bankApp.dbtesting;
import bankApp.models.Account;
import bankApp.repositories.AccountRepoDBImpl;
import bankApp.repositories.AccountRepo;

import static bankApp.models.Account.*;

public class AccountLoginTest {

    public static void main(String[] args) {
        AccountRepo ar = new AccountRepoDBImpl();

        String username = "Cody6";
        String password = "Cody6";


        if(ar.login(username, password) != null) {
            System.out.println(" Welcome " + username);
            System.out.println(Accounts());

            double[] allAccounts = accounts;

            for(int i = 0; i<allAccounts.length; i++){
                System.out.println(allAccounts[i] + " ");
            }

        } else{
            System.out.println("Please enter valid credentials");
        }
        System.out.println(ar.login(username, password));
        System.out.println(accounts[0]);
        System.out.println("====Login====");

    }
}