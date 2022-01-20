package bankApp.repositories;

import bankApp.models.Account;

public interface AccountRepo {
    Account getAccount(int id);
    Account login(String username, String password);
    Account addAccount(String username, String password, double accounts);
    Account transferFundsToChecking(Account change);
    Account transferFundsToSavings(Account change);
    Account transferCheckingToSavings(Account change);
    Account transferSavingsToChecking(Account change);
    Account withdrawFromSavings(Account change);
    Account withdrawFromChecking(Account change);
}
