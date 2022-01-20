# Code Survey

### By Art Weinstein

### A basic console application that allows users to register a bank account, and transfer money between all their accounts.

## Technologies Used

* Java
* DBeaver
* AWS (PostgreSQL)

## Description

This banking application starts by prompting the user to either make an account, or log in. The information provided by the user is populated to a database, and allows for 
data to persist even after the application terminates. Money transferred between accounts will transfer in the database accordingly 
based on the methods executed by the user. After logging in, the user are provided with 8 options:

1. Transfer funds to checking
2. Transfer funds to savings
3. Transfer from checking to savings
4. Transfer from savings to checking
5. Withdraw from checking
6. Withdraw from savings
7. View balance in all accounts
8. Log out.

Please note that users are unable to overdraft or enter invalid inputs. Upon account creation, the user is asked to enter the amount of funds available to them.
This allows for users to observe the functionality of the application, and to move money between all their accounts.





## Setup/Installation Requirements

1. [Clone](https://docs.github.com/en/github/creating-cloning-and-archiving-repositories/cloning-a-repository-from-github/cloning-a-repository) this repository.
2. Open the program in IntelliJ or similar software
3. In the Java directory, create a resources package.
4. Within the resources package, create a `connection.properties` file.
5. Enter the credentials for the database you wish to connect (this will require the endpoint, username and password)
6. Create a table with an integer for the primary key, and columns for VARCHAR username, VARCHAR password, DOUBLE funds, DOUBLE checking and DOUBLE savings
7. Navigate to the app package `src/main/java/bankApp/app` and open the Java Class `BankApp`
8. Execute the program by playing the play button next to the main method and follow the prompts

To test the methods individually, navigate to the dbtesting package: `src/main/java/bankApp/dbtesting` and choose
the methods you wish to test. Run each test by clicking the play button next to the main method and follow the prompts.


## Known Bugs

* No known bugs.

## License

* [MIT License](https://opensource.org/licenses/MIT)

Copyright (c) 2021 Art Weinstein

## Contact Information

* [Email](artur.weintsein@gmail.com)