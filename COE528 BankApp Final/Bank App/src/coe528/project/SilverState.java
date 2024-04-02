package coe528.project;

/**
 * OVERVIEW: The SilverState class is a mutable representation of a Silver customer in the bank app.
 * It extends the Customer class, providing implementations for login, logout, deposit, withdrawal,
 * and purchase functionalities for Silver customers. This class is designed to manage customer
 * credentials (username and password), account balance, and enforce state-specific purchase rules.
 */
public class SilverState extends Customer {
    private String username;
    private String password;
    private int balance;

    /**
     * Constructs a SilverState object with the provided username, password, and balance.
     *
     * @param username A non-null and non-empty string representing the username.
     * @param password A non-null and non-empty string representing the password.
     * @param balance A non-negative integer representing the account balance.
     * REQUIRES: A non-null and non-empty username, a non-null and non-empty password, and a non-negative balance.
     * MODIFIES: this.username, this.password, this.balance
     * EFFECTS: Initializes a new SilverState object with the provided username, password, and balance.
     */
    public SilverState(String username, String password, int balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    /**
     * Attempts to login with the specified username and password.
     *
     * @param user The username to log in with.
     * @param pass The password to log in with.
     * @return true if the login credentials match the instance's credentials, false otherwise.
     * REQUIRES: Non-null and non-empty user and pass parameters.
     * MODIFIES: none
     * EFFECTS: Returns true if the provided user and pass match the instance's username and password, respectively.
     */
    @Override
    public boolean login(String user, String pass) {
        return this.username.equals(user) && this.password.equals(pass);
    }

    /**
     * Logs out the current user.
     *
     * @return always true, indicating successful logout.
     * REQUIRES: none
     * MODIFIES: none
     * EFFECTS: Allows the user to log out, returning true to indicate successful logout.
     */
    @Override
    public boolean logout() {
        return true;
    }

    /**
     * Deposits the specified amount into the account balance.
     *
     * @param amount The amount to deposit.
     * REQUIRES: An amount greater than 0.
     * MODIFIES: this.balance 
     * EFFECTS: Increases the customer's balance by the specified amount.
     */
    @Override
    public void deposit(int amount) {
        this.balance += amount;
    }

    /**
     * Withdraws the specified amount from the account balance.
     *
     * @param amount The amount to withdraw.
     * @return true if the withdrawal is successful, false otherwise.
     * REQUIRES: An amount greater than 0 and less than or equal to the current balance.
     * MODIFIES: this.balance
     * EFFECTS: Decreases the balance by the specified amount and returns true if successful.
     */
    @Override
    public boolean withdraw(int amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    /**
     * Gets the username of the customer.
     *
     * @return The username of the customer.
     * REQUIRES: none
     * MODIFIES: none
     * EFFECTS: Returns the username of the customer.
     */
    @Override
    public String getUser() {
        return this.username;
    }

    /**
     * Gets the password of the customer.
     *
     * @return The password of the customer.
     * REQUIRES: none
     * MODIFIES: none
     * EFFECTS: Returns the password of the customer.
     */
    @Override
    public String getPassword() {
        return this.password;
    }

    /**
     * Gets the current balance of the customer.
     *
     * @return The current balance of the customer.
     * REQUIRES: none
     * MODIFIES: none
     * EFFECTS: Returns the current balance of the customer.
     */
    @Override
    public int getBalance() {
        return this.balance;
    }
    /**
     * Attempts to make a purchase with the specified amount, applying a service fee.
     * 
     * REQUIRES: A purchase amount that is at least 50 and does not exceed the current balance.
     * MODIFIES: this.balance
     * EFFECTS: Deducts the purchase amount plus a $20 service fee from the balance, returning true if successful.
     * 
     * @param amount The amount to be used for the purchase.
     * @return true if the purchase and fee deduction are successful, false otherwise.
     */
    @Override
    public boolean purchase(int amount) {
        if (amount >= 50 && amount <= this.balance) {
            this.balance -= (amount + 20);
            return true;
        }
        return false;
    }
    
    /**
     * Checks the integrity of the SilverState object according to its representation invariant.
     * 
     * REQUIRES: none
     * MODIFIES: none
     * EFFECTS: Returns true if the object adheres to the representation invariant 
     * @return true if the object state is valid, false otherwise.
     * 
     * Representation Invariant:
     * - username must not be null and must not be an empty string. This ensures each SilverState object has a valid username.
     * - password must not be null and must not be an empty string. This ensures each SilverState object has a valid password.
     * - balance must be a non-negative integer. This ensures the integrity of the account's balance, disallowing negative balances.
     * 
     * 
     */
    public boolean repOk() {
        return !(username == null || username.isEmpty() || password == null || password.isEmpty() || balance < 0);
    }

    /**
     * Provides a string representation of the SilverState object, detailing the username, balance, and customer level.
     * 
     * REQUIRES: none
     * MODIFIES: none
     * EFFECTS: Returns a string representation of the SilverState object, including username, balance, 
     * and level, accurately reflecting the state of the object as a Silver-level customer.
     * 
     * @return A string detailing the username, balance, and level of the SilverState object.
     * 
     * Abstraction Function:
     * AF(c) = "Username: " + c.username + "\nBalance: " + c.balance + " Level: Silver" where
     * - c.username represents the unique identifier for the customer associated with this account.
     * - c.balance represents the current monetary balance of the account in a unit of currency.
     * - The constant "Silver" indicates the customer's account level, signifying specific benefits and rules applicable to this tier.
     *
     * 
     */
    @Override
    public String toString() {
        return String.format("Username: %s\nBalance: %d Level: Silver", this.username, this.balance);
    }

}

