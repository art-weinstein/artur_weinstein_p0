package bankApp.dbtesting;
import bankApp.repositories.AccountRepoDBImpl;
import bankApp.repositories.AccountRepo;

import static bankApp.models.Account.transferToChecking;

public class FundsToCheckingTest {
    public static void main(String[] args) {
        AccountRepo ar = new AccountRepoDBImpl();
        String username = "test6";
        String password = "test6";
        ar.login(username, password);
        transferToChecking();
    }
}
