package bankApp.models;

import bankApp.repositories.AccountRepo;
import bankApp.repositories.AccountRepoDBImpl;

import java.util.Scanner;

public class Account {
    public static int id;
    public static String username;
    public static String password;

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
        if (ar.addAccount(username, password) != null && username != "" && password != "" ) {
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
        if(ar.login(username, password) != null) {
            System.out.println(" Welcome " + username);

        } else{
            System.out.println("Please enter valid credentials");
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

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username ='" + username + '\'' +
                ", password = " + password +
                '}';
    }
}




