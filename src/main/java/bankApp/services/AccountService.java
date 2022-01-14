package bankApp.services;
import bankApp.models.Account;

public interface AccountService {
    public Account login(String username, String password);
    public Account getAccount(int id);
    public boolean loggedin(Account a);
}
