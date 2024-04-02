package coe528.project;


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.geometry.Insets;
import javafx.geometry.HPos;
import javafx.scene.layout.VBox;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Bank App");
        Button login = new Button("Login");

        GridPane layout = new GridPane();
        layout.add(login, 0, 3);

        TextField user = new TextField("Username");
        Label userField = new Label("Username: ");

        TextField pw = new TextField("Password");
        Label pwField = new Label("Password: ");

        Label welcome = new Label("BANK");

        Label invalid = new Label("Invalid Login");

        //positioning on the grid
        layout.setAlignment(Pos.CENTER);
        layout.add(user, 0, 1);
        layout.add(pw, 0, 2);
        layout.add(welcome, 0, 0);

        //We create a manager to authenticate the initial logins
        Manager owais = new Manager();

        login.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String username = user.getText();
                String password = pw.getText();

                if (username.equals("admin") && password.equals("admin")) {
                    managerWindow(primaryStage, owais); //if a manager logs in this takes them to the manager screen
                    System.out.println("Got here");

                } else if (owais.verify(username, password)) { //will create a verify method in the manager class to check for login credentials
                    customerWindow(primaryStage, owais);
                    System.out.println("Got here logged in");
                } else {
                    System.out.println("Invalid Login");
                    layout.add(invalid, 1, 3);
                }
            }
        });

        Scene scene = new Scene(layout, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void managerWindow(Stage primaryStage, Manager a) {
        Manager owais = a;

        // Buttons
        Button addButton = new Button("Add Customer");
        Button deleteButton = new Button("Delete Customer");
        Button logoutButton = new Button("Logout");

        // Setting up the VBox for a vertical layout
        VBox layout = new VBox(10); // 10 pixels space between elements
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20, 20, 20, 20)); // Padding around the VBox

        // Add buttons to the VBox
        layout.getChildren().addAll(addButton, deleteButton, logoutButton);

        // Event Handlers
        addButton.setOnAction(e -> addCustomerWindow(primaryStage, owais));
        deleteButton.setOnAction(e -> deleteCustomerWindow(primaryStage, owais));
        logoutButton.setOnAction(e -> start(primaryStage)); 

        // Create the scene with VBox layout
        Scene scene = new Scene(layout, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Manager Dashboard"); // Setting the window title
        primaryStage.show();
    }

public void addCustomerWindow(Stage primaryStage, Manager a) {
    Manager owais = a;
    Label userLabel = new Label("Username: ");
    TextField userField = new TextField();
    Label passLabel = new Label("Password: ");
    TextField passField = new TextField();
    
    Button addCustomerButton = new Button("Add");
    Button backButton = new Button("Back");
    
    // Styling the labels
    userLabel.setFont(Font.font("Calibri", 14));
    passLabel.setFont(Font.font("Calibri", 14));
    
    GridPane gridPane = new GridPane();
    gridPane.setAlignment(Pos.CENTER);
    gridPane.setVgap(10);
    gridPane.setHgap(10);
    gridPane.setPadding(new Insets(20, 20, 20, 20));
    
    addCustomerButton.setOnAction(event -> {
        String Username = userField.getText().trim();
        String Password = passField.getText().trim();
        if (!Username.isEmpty() && !Password.isEmpty()) {
            owais.addCustomer(Username, Password);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Customer Added");
            alert.setHeaderText(null);
            alert.setContentText("Customer Added Successfully!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Username and Password must be entered.");
            alert.showAndWait();
        }
    });
    
    backButton.setOnAction(e -> managerWindow(primaryStage, owais));
    
    gridPane.add(userLabel, 0, 0);
    gridPane.add(userField, 1, 0);
    gridPane.add(passLabel, 0, 1);
    gridPane.add(passField, 1, 1);
    gridPane.add(addCustomerButton, 1, 2);
    gridPane.add(backButton, 1, 3);
    
    Scene scene = new Scene(gridPane, 400, 250);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Add Customer");
    primaryStage.show();
}
    public void deleteCustomerWindow(Stage primaryStage, Manager a) {
        Manager owais = a;
        GridPane deletePane = new GridPane();

        // Styling the GridPane
        deletePane.setPadding(new Insets(20)); // Add padding around the edges
        deletePane.setVgap(10); // Vertical space between rows
        deletePane.setHgap(10); // Horizontal space between columns
        deletePane.setAlignment(Pos.CENTER); // Center the pane in the scene

        // Creating UI components
        Label userLabel = new Label("Username: ");
        TextField userField = new TextField();
        Label passLabel = new Label("Password: ");
        TextField passField = new TextField();
        Button deleteC = new Button("Delete");
        Button backButton = new Button("Back");
        Label deleteText = new Label("Customer Deleted");
        deleteText.setFont(Font.font("Calibri", FontWeight.NORMAL, 14)); // Set font for the deletion confirmation

        // Handling the delete action
        deleteC.setOnAction(event -> {
            String username = userField.getText();
            String password = passField.getText();
            if (!username.isEmpty() && !password.isEmpty()) {
                owais.deleteCustomer(username, password);
                deletePane.getChildren().remove(deleteText); // Remove previous message if exists
                deletePane.add(deleteText, 1, 4); // Show confirmation message
            } else {
                System.out.println("UserName and Password must be provided");
            }
        });

        // Back button action
        backButton.setOnAction(e -> managerWindow(primaryStage, owais)); // Assume managerWindow is a method to return

        // Adding components to the pane
        deletePane.add(userLabel, 0, 0);
        deletePane.add(userField, 1, 0);
        deletePane.add(passLabel, 0, 1);
        deletePane.add(passField, 1, 1);
        deletePane.add(deleteC, 1, 2);
        deletePane.add(backButton, 1, 3);

        // Setting the scene and stage
        Scene scene = new Scene(deletePane, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Delete Customer"); // Setting a title for the window
        primaryStage.show();
    }

    public void customerWindow(Stage primaryStage, Manager a) {
        Manager owais = a;

        GridPane customerGrid = new GridPane();
        customerGrid.setAlignment(Pos.CENTER);
        customerGrid.setPadding(new Insets(20, 20, 20, 20)); // Adds padding around the grid
        customerGrid.setVgap(10); // Vertical gap between rows
        customerGrid.setHgap(10); // Horizontal gap between columns


        Label balLabel = new Label("Balance: " + owais.getBalance());
        balLabel.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));

        // Creating buttons with a uniform style
        Button logoutButton = new Button("Logout");
        Button depositButton = new Button("Deposit");
        Button withdrawButton = new Button("Withdraw");
        Button purchaseButton = new Button("Purchase");

        // Adding action events for buttons
        withdrawButton.setOnAction(e -> withdrawWindow(primaryStage, owais));
        depositButton.setOnAction(e -> depositWindow(primaryStage, owais));
        purchaseButton.setOnAction(e -> purchaseWindow(primaryStage, owais));
        logoutButton.setOnAction(e -> start(primaryStage)); // Assuming 'start' is your initial method to show the start screen

        // Arrange buttons and labels on the grid
        customerGrid.add(depositButton, 0, 1);
        customerGrid.add(withdrawButton, 1, 1);
        customerGrid.add(purchaseButton, 0, 2);
        customerGrid.add(logoutButton, 1, 2);
        customerGrid.add(balLabel, 0, 3, 2, 1); // Span 2 columns for the balance label

        // Aligning elements for a cleaner look
        GridPane.setHalignment(balLabel, HPos.CENTER); // Center the balance label

        Scene scene = new Scene(customerGrid, 400, 300); // Adjusted for better spacing
        primaryStage.setScene(scene);
        primaryStage.setTitle("Customer Account"); // Setting a title for the window
        primaryStage.show();
    }

    public void withdrawWindow(Stage primaryStage, Manager owais) {
        GridPane withdrawPane = new GridPane();

        withdrawPane.setPadding(new Insets(20)); // Adds padding around the edges
        withdrawPane.setVgap(10); // Sets vertical gap between components
        withdrawPane.setHgap(10); // Sets horizontal gap between components

        Label withdrawText = new Label("Withdrawals");
        withdrawText.setFont(new Font("Calibri", 16)); // Sets font for the title

        Button back = new Button("Back");
        Button withdraw = new Button("Withdraw");

        TextField withdrawField = new TextField();

        Label levelLabel = new Label("Level: " + owais.level());
        Label balLabel = new Label("Balance: " + owais.getBalance());

        withdraw.setOnAction(event -> {
            try {
                int amount = Integer.parseInt(withdrawField.getText());
                if (owais.withdraw(amount)) {
                    levelLabel.setText("Level: " + owais.level());
                    balLabel.setText("Balance: " + owais.getBalance());
                } else {
                    Alert notEnough = new Alert(Alert.AlertType.WARNING);
                    notEnough.setTitle("Warning");
                    notEnough.setHeaderText("Insufficient Funds");
                    notEnough.setContentText("You do not have enough funds to complete this withdrawal.");
                    notEnough.showAndWait();
                }
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid Input");
                alert.setContentText("Please enter a valid number.");
                alert.showAndWait();
            }
        });

        back.setOnAction(e -> customerWindow(primaryStage, owais));

        withdrawPane.setAlignment(Pos.CENTER);
        // Arranging components in a visually appealing manner
        withdrawPane.add(withdrawText, 0, 0, 2, 1);
        GridPane.setHalignment(withdrawText, HPos.CENTER); // Centers the withdrawal text
        withdrawPane.add(withdrawField, 0, 1);
        withdrawPane.add(withdraw, 1, 1);
        withdrawPane.add(back, 0, 2, 2, 1);
        GridPane.setHalignment(back, HPos.CENTER); // Center the back button
        withdrawPane.add(levelLabel, 0, 3, 2, 1);
        GridPane.setHalignment(levelLabel, HPos.CENTER); // Center the level label
        withdrawPane.add(balLabel, 0, 4, 2, 1);
        GridPane.setHalignment(balLabel, HPos.CENTER); // Center the balance label

        Scene scene = new Scene(withdrawPane, 400, 300); // Adjusted for a slightly larger window
        primaryStage.setScene(scene);
        primaryStage.setTitle("Withdraw Funds"); // Setting the title of the window
        primaryStage.show();
    }

    public void depositWindow(Stage primaryStage, Manager a) {
        Manager owais = a;
        GridPane depositPane = new GridPane();

        // Set padding and spacing for a cleaner look
        depositPane.setPadding(new Insets(20, 20, 20, 20)); // Adds padding around the grid
        depositPane.setVgap(10); // Vertical gap between rows
        depositPane.setHgap(15); // Horizontal gap between columns

        Label depositText = new Label("Deposit Amount:");

        Button back = new Button("Back");
        Button deposit = new Button("Deposit");

        TextField depositField = new TextField();

        Label levelLabel = new Label("Level: " + owais.level());
        Label balLabel = new Label("Balance: " + owais.getBalance());

        // Handling deposit action with improved functionality
        deposit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    int amount = Integer.parseInt(depositField.getText());
                    owais.deposit(amount);
                    levelLabel.setText("Level: " + owais.level());
                    balLabel.setText("Balance: " + owais.getBalance());
                } catch (NumberFormatException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Invalid Input");
                    alert.setHeaderText(null);
                    alert.setContentText("Please enter a valid numerical amount.");
                    alert.showAndWait();
                }
            }
        });

        back.setOnAction((ActionEvent e) -> {
            customerWindow(primaryStage, owais);
        });

        // Improved layout arrangement
        depositPane.add(depositText, 0, 0);
        depositPane.add(depositField, 0, 1);
        depositPane.add(deposit, 1, 1);
        depositPane.add(back, 0, 3, 2, 1); // Merge cells for the back button
        depositPane.add(levelLabel, 0, 2);
        depositPane.add(balLabel, 0, 4);

        // Aligning components for a better visual appearance
        GridPane.setHalignment(deposit, HPos.RIGHT);
        GridPane.setHalignment(back, HPos.CENTER);
        depositPane.setGridLinesVisible(false); // Optionally, set to true to see the grid lines

        Scene scene = new Scene(depositPane, 400, 300); // Adjusted window size for better layout
        primaryStage.setScene(scene);
        primaryStage.setTitle("Deposit Funds");
        primaryStage.show();
    }

    public void purchaseWindow(Stage primaryStage, Manager a) {
        Manager owais = a;
        GridPane purchasePane = new GridPane();

        purchasePane.setPadding(new Insets(10, 10, 10, 10)); // Add some padding around the grid
        purchasePane.setVgap(5); // Vertical gap between rows
        purchasePane.setHgap(10); // Horizontal gap between columns

        Label purchaseText = new Label("Enter the amount to purchase:");

        Button back = new Button("Back");
        Button purchase = new Button("Purchase");

        TextField purchaseField = new TextField();

        Label levelLabel = new Label("Level: " + owais.level());
        Label balLabel = new Label("Balance: " + owais.getBalance());

        purchase.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    int amount = Integer.parseInt(purchaseField.getText());
                    if (owais.purchase(amount)) {
                        levelLabel.setText("Level: " + owais.level());
                        balLabel.setText("Balance: " + owais.getBalance());
                    } else {
                        Alert notEnough = new Alert(Alert.AlertType.WARNING);
                        notEnough.setTitle("WARNING");
                        notEnough.setContentText("Low on funds/Not enough");
                        notEnough.showAndWait();
                    }
                } catch (NumberFormatException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setContentText("Please enter a valid amount");
                    alert.showAndWait();
                }
            }
        });

        back.setOnAction((ActionEvent e) -> {
            customerWindow(primaryStage, owais);
        });

        // Set the layout more dynamically and align items for better visual appeal
        purchasePane.setAlignment(Pos.CENTER);
        purchasePane.add(purchaseText, 0, 0);
        purchasePane.add(purchaseField, 0, 1);
        purchasePane.add(purchase, 1, 1);
        purchasePane.add(back, 0, 2);
        purchasePane.add(levelLabel, 0, 3);
        purchasePane.add(balLabel, 0, 4);

        // Center the buttons within their cells for a cleaner look
        GridPane.setHalignment(purchase, HPos.CENTER);
        GridPane.setHalignment(back, HPos.CENTER);

        Scene scene = new Scene(purchasePane, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
