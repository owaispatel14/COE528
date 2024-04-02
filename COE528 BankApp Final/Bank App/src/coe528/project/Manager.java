package coe528.project;

import java.io.*;

/**
 * This class represents a manager that handles customer accounts.
 * It includes functionality to verify login credentials, add or delete customers,
 * manage customer account levels based on balance, and process transactions such as deposits,
 * withdrawals, and purchases.
 */
public class Manager {
    
    // Manager's credentials and directory for customer files
    private String username;
    private String password;
    private final String dir = "customerFile"; // Directory to store customer files
    private int bal; // Balance
    private Customer current; // Reference to the currently logged-in customer
    
    /**
     * Verifies the login credentials of a customer.
     * 
     * @param usr  The username of the customer.
     * @param pswd The password of the customer.
     * @return     true if the credentials match an existing customer, false otherwise.
     */
    public boolean verify(String usr, String pswd) {
        boolean verification = false;
        
        try {
            FileReader readFile = new FileReader(dir + usr + pswd + ".txt");
            BufferedReader buffer1 = new BufferedReader(readFile);
            
            // Parse customer information from the file
            String line = buffer1.readLine();
            String[] info = line.split(", ");
            
            // Assigning the read values to local variables
            username = info[0];
            password = info[1];
            bal = Integer.parseInt(info[2]);
            
            // Determine and create the appropriate state based on balance
            Customer c1;
            if (bal < 10000) {
                c1 = new SilverState(username, password, bal);
            } else if (bal >= 10000 && bal < 20000) {
                c1 = new GoldState(username, password, bal);
            } else if (bal >= 20000) {
                c1 = new PlatinumState(username, password, bal);
            } else {
                System.out.println("No money");
                return false;
            }
            
            // Update current customer reference if login is successful
            if (c1.login(usr, pswd)) {
                current = c1;
                verification = true;
            }
             
        } catch (Exception e) {
            System.out.println("User doesn't exist");
        }
        return verification;
    }
    
    /**
     * Adds a new customer to the system by creating a file with their details.
     * 
     * @param user The username of the new customer.
     * @param pass The password of the new customer.
     */
    public void addCustomer(String user, String pass) {
        String newDirectory = dir + user + pass + ".txt";
        File customerFile = new File(newDirectory);
        try {
            FileWriter writeToFile = new FileWriter(customerFile);
            BufferedWriter writer = new BufferedWriter(writeToFile);
            
            writer.write(user + ", " + pass + ", " + 100); // Initial balance set to 100
        
            writer.close();
        }
        catch (Exception e) {
            System.out.println("Error creating new user file.");
        }
    }
    
    /**
     * Deletes an existing customer from the system by removing their file.
     * 
     * @param user The username of the customer to delete.
     * @param pass The password of the customer to delete.
     */
    public void deleteCustomer(String user, String pass) {
        File dFile = new File(dir + user + pass + ".txt");
        try {
            if (dFile.delete()) {
                System.out.println("Deleted user");  
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
    
    /**
     * Returns the state level of the currently logged-in customer.
     * 
     * @return The state level as a String.
     */
    public String level() {
        if (current instanceof SilverState) {
            return "Silver";
        } else if (current instanceof GoldState) {
            return "Gold";
        } else {
            return "Platinum";
        }
    }
    
    /**
     * Logs out the current customer.
     * 
     * @return true if logout is successful, otherwise false.
     */
    public boolean logout() {
        return current.logout();
    }
    
    /**
     * Updates the details of the current customer in the system.
     */
    public void updateCustomer() {
        try {
            // Update the customer file with the current details
            FileWriter writeToFile = new FileWriter(dir + current.getUser() + current.getPassword() + ".txt");
            BufferedWriter writer = new BufferedWriter(writeToFile);
            
            writer.write(current.getUser() + ", " + current.getPassword() + ", " + current.getBalance());
        
            writer.close();
        }
        catch (Exception e) {
            System.out.println("Cant update");
        }
        
        // Check and update customer state based on the new balance
        if (current.getBalance() < 10000) {
            current = new SilverState(current.getUser(), current.getPassword(), current.getBalance());
        } else if (current.getBalance() >= 10000 && current.getBalance() < 20000) {
            current = new GoldState(current.getUser(), current.getPassword(), current.getBalance());
        } else if (current.getBalance() >= 20000) {
            current = new PlatinumState(current.getUser(), current.getPassword(), current.getBalance());
        } else {
            System.out.println("No money");
        }
    }
    /**
     * Deposits a specified amount into the current customer's account and updates their details.
     * 
     * @param amount The amount to deposit.
     */
    public void deposit(int amount) {
        current.deposit(amount); // Deposit the amount into the customer's account.
        updateCustomer(); // Reflect the change in the customer's account file.
    }
    
    /**
     * Attempts to withdraw a specified amount from the current customer's balance.
     * Updates the customer details if the withdrawal is successful.
     * 
     * @param amount The amount to withdraw.
     * @return       true if the withdrawal is successful, false otherwise.
     */
    public boolean withdraw(int amount) {
        if (current.withdraw(amount)) { // Check if withdrawal is possible and perform it if so.
            updateCustomer(); // Update the customer's account details to reflect the withdrawal.
            return true; // Withdrawal was successful.
        }
        return false; // Withdrawal failed, likely due to insufficient funds.
    }
    
    /**
     * Retrieves the currently logged-in customer.
     * 
     * @return A reference to the current Customer object.
     */
    public Customer getCurrent() {
        return current; // Return the reference to the current customer.
    }
    
    /**
     * Obtains the balance of the current customer's account.
     * 
     * @return The current balance as an integer.
     */
    public int getBalance() {
        return current.getBalance(); // Retrieve and return the current balance.
    }
    
    /**
     * Processes a purchase transaction for the current customer by deducting the specified amount from their balance.
     * Updates the customer details if the purchase is successful.
     * 
     * @param amount The amount of the purchase.
     * @return true if the purchase is successfully made, false otherwise.
     */
    public boolean purchase(int amount) {
        if (current.purchase(amount)) { // Attempt to make a purchase and deduct the amount from the balance.
            updateCustomer(); // Update customer details to reflect the new balance.
            return true; // Purchase was successful.
        }
        return false; // Purchase failed, possibly due to insufficient funds.
    }
}
