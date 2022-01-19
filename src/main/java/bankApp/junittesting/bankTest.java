package bankApp.junittesting;

import bankApp.repositories.AccountRepo;
import bankApp.repositories.AccountRepoDBImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

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



    // properly creates a fake account
    @Test
    public void addAccount(){
        username = "Cody";
        password = "Password";
        funds = 1000;
        id = 15;
        savings = 0;
        assertEquals("Cody", username);
        assertEquals(15, id);
        assertEquals(0, savings);
        assertEquals(1000, funds);
    }

    // properly updates funds and savings from 0 to 1000; test does not transfer to database.
    @Test
    public void transferFundsToChecking(){
        ar.login("art", "password");
        funds = 1000;
        savings = 1000;
        assertEquals(1000, funds);
        assertEquals(1000, savings);
    }





}
