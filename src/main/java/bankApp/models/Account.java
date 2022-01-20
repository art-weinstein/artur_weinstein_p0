package bankApp.models;

import bankApp.repositories.AccountRepo;
import bankApp.repositories.AccountRepoDBImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Account {
    public static int id;
    public static String username;
    public static String password;
    public static double funds;
    public static double savings;
    public static double checking;
    public static double[] accounts = new double[3];

    public Account() {
    }

    public static String Accounts(){
        accounts = new double[]{funds, checking, savings};
        return "Funds: " + accounts[0] +  " | checking: " + accounts[1] + " | savings: " + accounts[2];
    }

    public static void register() {
        Scanner scan = new Scanner(System.in);
        AccountRepo ar = new AccountRepoDBImpl();
        System.out.println("Register an account");
        System.out.println("Enter username");
        String username = scan.nextLine();
        System.out.println("Enter password");
        String password = scan.nextLine();
        System.out.println("Enter your available funds");
        funds = scan.nextDouble();
        if (ar.addAccount(username, password, funds) != null && username != "" && password != "") {
            System.out.println("Account for " + username + " is registered!");

        } else {
            System.out.println("Please enter valid credentials");
        }
    }

    public static void userLogin() {
        Scanner scan = new Scanner(System.in);
        AccountRepo ar = new AccountRepoDBImpl();
        System.out.println("Enter username");
        String username = scan.nextLine();
        System.out.println("Enter password");
        String password = scan.nextLine();
        int validated = 0;
        while (validated == 0) {
            if (ar.login(username, password) != null) {
                Accounts();
                System.out.println("Welcome " + username);
                System.out.println(Accounts());
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

    public static String transferToChecking() {
        boolean reRun = true;
        while (reRun) {
            Scanner scan = new Scanner(System.in);
            try {
                AccountRepo ar = new AccountRepoDBImpl();
                System.out.println("Enter an amount to transfer from personal funds to checking");
                System.out.println(Accounts());
                double fundTransfer = scan.nextDouble();
                Account account = new Account();
                while (ar.transferFundsToChecking(account) != null && reRun) {
                    if (fundTransfer <= funds) {
                        checking += fundTransfer;
                        funds -= fundTransfer;
                        System.out.println(Accounts());
                        reRun = false;
                    } else {
                        System.out.println("Insufficient funds, please enter a valid amount!");
                        System.out.println("Current funds:");
                        System.out.println(funds);
                        System.out.println("Current Checking");
                        System.out.println(checking);
                        fundTransfer = scan.nextDouble();
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid input!");
                scan.next();
            }
        }
        return "Please select an option";
    }

    public static String transferToSavings() {
        boolean reRun = true;
        while (reRun) {
                Scanner scan = new Scanner(System.in);
            try {
                AccountRepo ar = new AccountRepoDBImpl();
                System.out.println("Enter an amount to transfer from personal funds to savings");
                System.out.println(Accounts());
                double savingTransfer = scan.nextDouble();
                int transferred = 0;
                Account account = new Account();
                while (ar.transferFundsToSavings(account) != null && reRun) {
                    if (savingTransfer <= funds) {
                        savings += savingTransfer;
                        funds -= savingTransfer;
                        System.out.println(Accounts());
                        reRun = false;
                    } else {
                        System.out.println("Insufficient funds, please enter a valid amount!");
                        System.out.println("Current funds:");
                        System.out.println(funds);
                        System.out.println("Current savings");
                        System.out.println(savings);
                        savingTransfer = scan.nextDouble();
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid input!");
                scan.next();
            }
        }
            return "Please select an option";
    }

    public static String checkingToSavings() {
        boolean reRun = true;
        while (reRun) {
            Scanner scan = new Scanner(System.in);
            try {
                AccountRepo ar = new AccountRepoDBImpl();
                System.out.println("Enter an amount to transfer from checking to savings");
                System.out.println(Accounts());
                double checkToSaving = scan.nextDouble();
                int transferred = 0;
                Account account = new Account();
                while (ar.transferCheckingToSavings(account) != null && reRun) {
                    if (checkToSaving <= checking) {
                        savings += checkToSaving;
                        checking -= checkToSaving;
                        System.out.println(Accounts());
                        reRun = false;
                    } else {
                        System.out.println("Insufficient funds, please enter a valid amount!");
                        System.out.println("Current checking:");
                        System.out.println(checking);
                        System.out.println("Current savings");
                        System.out.println(savings);
                        checkToSaving = scan.nextDouble();
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid input!");
                scan.next();
            }
        }
            return "Please select an option";
    }

    public static String savingsToChecking() {
        boolean reRun = true;
        while(reRun) {
            Scanner scan = new Scanner(System.in);
            try {
                AccountRepo ar = new AccountRepoDBImpl();
                System.out.println("Enter an amount to transfer from savings to checking");
                System.out.println(Accounts());
                double savingToCheck = scan.nextDouble();

                Account account = new Account();
                while (ar.transferSavingsToChecking(account) != null && reRun) {
                    if (savingToCheck <= savings) {
                        checking += savingToCheck;
                        savings -= savingToCheck;
                        System.out.println(Accounts());
                        reRun = false;
                    } else {
                        System.out.println("Insufficient savings, please enter a valid amount!");
                        System.out.println("Current savings:");
                        System.out.println(savings);
                        System.out.println("Current Checking");
                        System.out.println(savings);
                        savingToCheck = scan.nextDouble();
                    }
                    scan.nextDouble();
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid input!");
            }
        }
        return "Please select an option";
    }

    public static String withdrawSavings() {
        boolean reRun = true;
        while (reRun) {
            Scanner scan = new Scanner(System.in);
            try {
                AccountRepo ar = new AccountRepoDBImpl();
                System.out.println("Enter an amount to withdraw from savings to funds");
                System.out.println(Accounts());
                double savingToFunds = scan.nextDouble();
                Account account = new Account();
                while (ar.withdrawFromSavings(account) != null && reRun) {
                    if (savingToFunds <= savings) {
                        funds += savingToFunds;
                        savings -= savingToFunds;
                        System.out.println(Accounts());
                        reRun = false;
                    } else {
                        System.out.println("Insufficient savings, please enter a valid amount!");
                        System.out.println("Current savings:");
                        System.out.println(savings);
                        System.out.println("Current funds");
                        System.out.println(funds);
                        savingToFunds = scan.nextDouble();
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid input!");
            }
        }
            return "Please select an option";
    }

    public static String withdrawChecking() {
        boolean reRun = true;
        while (reRun) {
            Scanner scan = new Scanner(System.in);
            try {
                AccountRepo ar = new AccountRepoDBImpl();
                System.out.println("Enter an amount to withdraw from checking to funds");
                System.out.println(Accounts());
                double checkingToFunds = scan.nextDouble();
                int transferred = 0;
                Account account = new Account();
                while (ar.withdrawFromChecking(account) != null && reRun) {
                    if (checkingToFunds <= checking) {
                        funds += checkingToFunds;
                        checking -= checkingToFunds;
                        System.out.println(Accounts());
                        reRun = false;
                    } else {
                        System.out.println("Insufficient funds in checking, please enter a valid amount!");
                        System.out.println("Current checking:");
                        System.out.println(checking);
                        System.out.println("Current funds");
                        System.out.println(funds);
                        checkingToFunds = scan.nextDouble();
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid input!");
            }
        }
        return "Please select an option";
    }

    public static int command() {
//        BankAccount bankAccount = new BankAccount();
//            Scanner scan = new Scanner(System.in);

        System.out.println("What would you like to do?");
        System.out.println("'1' to transfer from funds to checking");
        System.out.println("'2' to transfer from funds to savings");
        System.out.println("'3' to transfer from checking to savings");
        System.out.println("'4' to transfer from savings to checking");
        System.out.println("'5' to withdraw from savings");
        System.out.println("'6' to withdraw from checking");
        System.out.println("'7 to view all accounts");
        System.out.println("'8' log out");
//            double command = scan.nextDouble()
        return 1;
    }


    public static void commandInput() {
        Scanner scan = new Scanner(System.in);
        while (command() != 7) {
            try {
                int command = scan.nextInt();
                if (command == 1) {
                    transferToChecking();
                } else if (command == 2) {
                    transferToSavings();
                } else if (command == 3) {
                    checkingToSavings();
                } else if (command == 4) {
                    savingsToChecking();
                } else if (command == 5) {
                    withdrawSavings();
                } else if (command == 6) {
                    withdrawChecking();
                } else if (command == 7) {
                    System.out.println(Accounts());
                } else if (command == 8) {
                    System.out.println("Thank you, " + username + ". Goodbye!");
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid input!");
                scan.next();
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername(){
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public double getFunds() {
        return funds;
    }

    public void setFunds(double funds) {
        this.funds = funds;
    }

    public double getSavings() {
        return savings;
    }

    public void setSavings(double savings) {
        this.savings = savings;
    }

    public double getChecking() {
        return checking;
    }

    public void setChecking(double checking) {
        this.checking = checking;
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




