package bankApp.services;
import bankApp.models.Account;
import bankApp.repositories.AccountRepo;

public class AccountServiceImpl implements AccountService {
    private AccountRepo ar;

    public AccountServiceImpl(AccountRepo ar){
        this.ar = ar;
    }
    @Override
    public Account login(String username, String password){
        return ar.login(username, password);
    }

//    @Override
//    public Account login(String username, String password) {
//        return null;
//    }

    @Override
    public Account getAccount(int id){
        return ar.getAccount(id);
    }

    @Override
    public boolean loggedIn(Account a) {
        return false;
    }

    @Override
    public Account transferFundsToChecking(Account change){
        return ar.transferFundsToChecking(change);
    }

}
