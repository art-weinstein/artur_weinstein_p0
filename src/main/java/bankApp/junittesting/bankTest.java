package bankApp.junittesting;
import bankApp.models.Account;
import bankApp.repositories.AccountRepo;
import bankApp.repositories.AccountRepoDBImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static bankApp.models.Account.*;
import static bankApp.models.Account.transferToChecking;
import static org.junit.jupiter.api.Assertions.*;
import static sun.security.jgss.GSSUtil.login;

public class bankTest {
    Scanner scan = new Scanner(System.in);
    static AccountRepo ar = new AccountRepoDBImpl();
//    Account account1 = new Account();
//    AccountRepo ar = new AccountRepoDBImpl();

    @BeforeAll
    public static void setUp() {
        System.out.println("Initialization before tests run");
    }
    @BeforeEach
    public void before(){
        System.out.println("Run next test");
    }

    @Test
    public void getId() {
        username = "art";
        password = "password";
        ar.login(username, password);
        assertEquals(2, id);
        assertEquals(0, funds);
        assertEquals(6000, checking);
        assertEquals(0, savings);
    }

}
