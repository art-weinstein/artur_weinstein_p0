package bankApp.junittesting;

import bankApp.models.Account;
import bankApp.repositories.AccountRepo;
import bankApp.repositories.AccountRepoDBImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static bankApp.models.Account.*;
import static org.junit.jupiter.api.Assertions.*;


public class bankTest {
    static AccountRepo ar = new AccountRepoDBImpl();


    @BeforeAll
    public static void setUp() {
        System.out.println("Initialization before tests run");
    }
    @BeforeEach
    public void before(){
        System.out.println("Run next test");
    }


    // this addAccount() test physically adds an account, fails unless parameters are change every
    //implementation

    // properly creates an account
//    @Test
//    public void addAccount(){
//        Account account = new Account();
//        ar.addAccount("Cody5", "Password", 1000);
//        assertEquals(account.getUsername(), "Cody5");
//        assertEquals(account.getPassword(), "Password");
//        assertEquals(account.getId(), 22);
//        assertEquals(account.getFunds(), 1000);
//    }

    @Test
    public void getId() {
        Account account = new Account();
        username = "art";
        password = "password";
        ar.login(username, password);
        assertEquals(account.getId(), 2);
    }

    @Test
    public void setId() {
        Account account = new Account();
        account.setId(5);
        assertEquals(account.getId(), 5);
    }


    @Test
    public void getFunds(){
        Account account = new Account();
        ar.login("test5", "test5");
        account.getFunds();
        assertEquals(account.getFunds(), 2000);
    }


    @Test
    public void setFunds(){
        Account account = new Account();
        account.setId(5);
        account.setFunds(6000);
        assertEquals(account.getFunds(), 6000);
    }

    @Test
    public void setChecking() {
        Account account = new Account();
        account.setId(5);
        account.setChecking(3000);
        assertEquals(account.getChecking(), 3000);
    }

    @Test public void getSavings(){
        Account account = new Account();
        account.setId(5);
        this.getId();
        assertEquals(account.getSavings(), 0);
    }
    @Test
    public void setSavings(){
        Account account = new Account();
        account.setId(5);
        account.setSavings(2000);
        assertEquals(account.getSavings(), 2000);
    }

    @Test
    public void getPassword(){
        Account account = new Account();
        account.setId(2);
        this.getId();
        assertEquals(account.getPassword(), "password");
    }

    @Test
    public void getUsername(){
        Account account = new Account();
        account.setId(2);
        this.getId();
        assertEquals(account.getUsername(), "art");
    }


//    @Test
//    public void transferFundsToSavings(){
//        Account account = new Account();
////        ar.login("test5", "test5");
////        ar.login("art", "password");
//        account.setId(5);
//        ar.transferFundsToSavings(account);
//        account.setFunds(1000);
//        account.setSavings(1000);
////        this.getFunds();
////        this.getSavings();
//        assertEquals(account.getFunds(), 1000);
////        assertEquals(account.getSavings(), 1000);
//    }




//    Account transferCheckingToSavings(Account change);
//    Account transferSavingsToChecking(Account change);
//    Account withdrawFromSavings(Account change);
//    Account withdrawFromChecking(Account change);


}
