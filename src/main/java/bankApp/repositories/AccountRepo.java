package bankApp.repositories;

import bankApp.models.Account;

public interface AccountRepo {
    public Account getAccount(int id);
    public Account login(String username, String password);
    public Account addAccount(String username, String password, double funds);
    public Account transferFundsToChecking(Account change);
    public Account transferFundsToSavings(Account change);
    public Account transferCheckingToSavings(Account change);
    public Account transferSavingsToChecking(Account change);
    public Account withdrawFromSavings(Account change);
    public Account withdrawFromChecking(Account change);
}
