package coe528.project;

/**
 * An abstract class representing a customer in a banking system.
 * This class provides a template for customer operations across different customer levels such as Silver, Gold, and Platinum.
 * Each subclass must implement the operations according to the specifics of the customer level it represents.
 */
public abstract class Customer {
    /**
     * Attempts to log in a customer with the provided credentials.
     * @param user The username of the customer.
     * @param pass The password of the customer.
     * @return true if the login is successful, false otherwise.
     */
    public abstract boolean login(String user, String pass);

    /**
     * Logs out the current customer.
     * @return true if the logout is successful, typically always true.
     */
    public abstract boolean logout();

    /**
     * Deposits a specified amount into the customer's account.
     * @param amount The amount to deposit.
     */
    public abstract void deposit(int amount);

    /**
     * Withdraws a specified amount from the customer's account.
     * @param amount The amount to withdraw.
     * @return true if the withdrawal is successful (sufficient funds), false otherwise.
     */
    public abstract boolean withdraw(int amount);

    /**
     * Retrieves the username of the customer.
     * @return The username of the customer.
     */
    public abstract String getUser();

    /**
     * Retrieves the password of the customer.
     * @return The password of the customer.
     */
    public abstract String getPassword();

    /**
     * Retrieves the current balance of the customer's account.
     * @return The current balance.
     */
    public abstract int getBalance();

    /**
     * Processes a purchase transaction for the customer.
     * @param amount The amount of the purchase.
     * @return true if the purchase is successful (sufficient funds and meets purchase requirements), false otherwise.
     */
    public abstract boolean purchase(int amount);
}
