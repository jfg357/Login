/* 2 Creating a Form in JavaFX
    Creating a form is a common activity when developing an application.
    This tutorial teaches you the basics of screen layout, how to add controls to a layout pane,
    and how to create input events.
    In this tutorial, you will use JavaFX to build the login form
*/

package login;

/* Import required packages for application */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) { // This is where the magic happens

    /* Stage settings */
    primaryStage.setTitle("JavaFX Welcome"); // Set the title
    GridPane grid = new GridPane(); // Using a GridPane layout because flexibility
    grid.setAlignment(Pos.CENTER); // Center the GridPane
    grid.setHgap(10); // Space between columns
    grid.setVgap(10); // Space between rows
    grid.setPadding(new Insets(25, 25, 25, 25)); // Padding the context

    /* Scene Title settings */
    Text scenetitle = new Text("Welcome"); // Set scene title
    scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20)); // Make it pretty
    grid.add(scenetitle, 0, 0, 2, 1); // Position of title

    /* Labels and Text fields */
    Label userName = new Label("User Name:"); // Create and set userName label
    grid.add(userName, 0, 1); // Position the userName label

    TextField userTextField = new TextField(); // Create the userTextField text field
    grid.add(userTextField, 1, 1); // Position the userTextField text field

    Label pw = new Label("Password:"); // Create and set pw label
    grid.add(pw, 0, 2); // Position the pw label

    PasswordField pwBox = new PasswordField(); // Create the pwBox password field
    grid.add(pwBox, 1, 2); // Position the pwBox password field

    Button btn = new Button("Sign in"); // Create the button
    HBox hbBtn = new HBox(10);
    hbBtn.setAlignment(Pos.BOTTOM_RIGHT); // Position button on the bottom right
    hbBtn.getChildren().add(btn); // The button is added as a child of the HBox pane
    grid.add(hbBtn, 1, 4);// HBox pane is added to the grid in column 1, row 4

    final Text actiontarget = new Text(); // Display text
    grid.add(actiontarget, 1, 6); // Text position

    btn.setOnAction(new EventHandler<ActionEvent>() { // Event handler for sign in button
      @Override
      public void handle(ActionEvent e) {
        actiontarget.setFill(Color.GREEN);
        actiontarget.setText("Sign in button pressed!");
      }
    });

    Scene scene = new Scene(grid, 300, 275);
    primaryStage.setScene(scene);
    primaryStage.show(); // Display the scene composed above
  }
}