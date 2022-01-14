package bankApp.models;

import bankApp.repositories.AccountRepo;
import bankApp.repositories.AccountRepoDBImpl;

import java.util.Scanner;

public class Account {
    public static int id;
    public static String username;
    public static String password;
    public static double funds;
    public static double savings;
    public static double checking;

    public Account() {
    }


    public static void register(){
        Scanner scan = new Scanner(System.in);
        AccountRepo ar = new AccountRepoDBImpl();
        System.out.println("Register an account");
        System.out.println("Enter username");
        String username = scan.nextLine();
        System.out.println("Enter password");
        String password = scan.nextLine();
        System.out.println("Enter your available funds");
        double funds = scan.nextDouble();
        if (ar.addAccount(username, password, funds) != null && username != "" && password != "" ) {
            System.out.println("Account for " + username + " is registered!");

        } else {
            System.out.println("Please enter valid credentials");
        }
    }

    public static void userLogin(){
        Scanner scan = new Scanner(System.in);
        AccountRepo ar = new AccountRepoDBImpl();
        System.out.println("Enter username");
        String username = scan.nextLine();
        System.out.println("Enter password");
        String password = scan.nextLine();
        int validated = 0;
        while (validated == 0) {
            if (ar.login(username, password) != null) {
                System.out.println("Welcome " + username);
                System.out.println("Funds: " + funds);
                System.out.println("Checking: " + checking);
                System.out.println("Savings: " + savings);
                validated = 1;

            } else {
                System.out.println("Please enter valid credentials");
                System.out.println("Enter username");
                username = scan.nextLine();
                System.out.println("Enter password");
                password = scan.nextLine();
            }
        }
    }

    

    public Account(int id, String username, String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Account(String username, String password){
        this.username = username;
        this.password = password;
    }

    public void login() {
        this.id = id;
    }

    public void getAccount(){
        this.id = id;
    }

    public int getAccount(int id){
        return id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static double getFunds() {
        return funds;
    }

    public static void setFunds(double funds) {
        Account.funds = funds;
    }

    public static double getSavings() {
        return savings;
    }

    public static void setSavings(double savings) {
        Account.savings = savings;
    }

    public static double getChecking() {
        return checking;
    }

    public static void setChecking(double checking) {
        Account.checking = checking;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username ='" + username + '\'' +
                ", password = " + password +
                '}';
    }
}




