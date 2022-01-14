package bankApp.repositories;

import bankApp.models.Account;

public interface AccountRepo {
    public Account getAccount(int id);
    public Account login(String username, String password);
    public Account addAccount(String username, String password, double funds);
//    Account login(int id);
}
