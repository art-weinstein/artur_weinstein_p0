package bankApp.dbtesting;

import bankApp.repositories.AccountRepo;
import bankApp.repositories.AccountRepoDBImpl;

import static bankApp.models.Account.checkingToSavings;

public class SavingsToCheckingTest {
    public static void main(String[] args) {
        AccountRepo ar = new AccountRepoDBImpl();
        String username = "test6";
        String password = "test6";
        ar.login(username, password);
        checkingToSavings();
    }
}
