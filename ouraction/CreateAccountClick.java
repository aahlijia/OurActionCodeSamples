package ouraction;

import javafx.scene.control.Alert;

import java.io.IOException;

public class CreateAccountClick extends CreateAccountScreen{
    //Declare new object for non-static reference
    CreateAccountScreen cAS = new CreateAccountScreen();

    //CREATE A TEMP PERSON FOR INSTANT ACCESS TO THEIR ACCOUNT

    public static void createAccountOnClick() {
        //Get text from text boxes and assign accordingly
        String username = usernameField.getText().toLowerCase();
        String email = emailField.getText().toLowerCase();
        String pass = passwordField.getText();

        //ASSIGN ALERT BOXES FOR THE FOLLOWING SCENARIOS:
        //BLANK TEXT FIELDS, EXSISTING EMAIL OR USERNAME WITHIN THE DATABASE, EMAIL NOT CONTAINING ".com || @ "
        //SPACES WITHIN A TEXT FIELD
        //PASSWORD REQUIREMENTS: CONTAIN 1 NUMERIC VALUE, SPECIAL CHARACTER, AND CAPITAL LETTER
        if (passwordField.getText().isEmpty() || usernameField.getText().isEmpty()
                || password1Field.getText().isEmpty()
                || emailField.getText().isEmpty()) {
            Alert emptyField = new Alert(Alert.AlertType.ERROR);
            emptyField.setContentText("You cannot complete account creation with any blank fields.");
            emptyField.setHeaderText("Error: Empty field(s)");
            emptyField.setTitle("Error");
            emptyField.show();
        }

        //WILL NEED TO CHECK DATABASE AGAINST EXISTING EMAIL ADDRESSES
        else if (!parseEmail(emailField.getText())) {
            Alert invalidEmail = new Alert(Alert.AlertType.INFORMATION);
            invalidEmail.setHeaderText("Invalid E-Mail");
            invalidEmail.show();
        }

        //WILL NEED TO CHECK DATABASE AGAINST EXISTING USERNAMES
        else if (usernameField.getText().length() < 6) {
            Alert invalidUser = new Alert(Alert.AlertType.ERROR);
            invalidUser.setTitle("Invalid Username");
            invalidUser.setHeaderText("Username must be a minimum of 6 characters.");
            invalidUser.show();
        } else if (checkPass(passwordField.getText()) == false) {
            Alert invalidPass = new Alert(Alert.AlertType.ERROR);
            invalidPass.setTitle("Password Error");
            invalidPass.setContentText("Password must contain at least 1 capital letter, 6 characters and at least 1 number.");
            invalidPass.show();
        } else if (!passwordField.getText().equals(password1Field.getText())) {
            Alert passMatch = new Alert(Alert.AlertType.ERROR);
            passMatch.setTitle("Password Error");
            passMatch.setContentText("Passwords do not match.");
            passMatch.show();
        } else if (!isSpace()) {
            Alert space = new Alert(Alert.AlertType.ERROR);
            space.setTitle("Entry Error");
            space.setContentText("Please do not enter any spaces in the text fields.");
            space.show();
        } else if (LocalDB.personMap.containsKey(username) == true) {
            Alert dupUser = new Alert(Alert.AlertType.ERROR);
            dupUser.setTitle("User already exists");
            dupUser.setContentText("That username is already registered");
            dupUser.show();
        } else if (LocalDB.userEmailMap.containsValue(email)){
            Alert dupEmail = new Alert(Alert.AlertType.ERROR);
            dupEmail.setTitle("E-mail already registered");
            dupEmail.setContentText("Please check if you have already registered an e-mail with us.");
            dupEmail.show();
        }

        //ELSE SUCCESSFULLY CREATE THE ACCOUNT
        else {
            Alert success = new Alert(Alert.AlertType.CONFIRMATION);
            success.setTitle("Success!");
            success.setContentText("Please check " + email + " for a confirmation code!");
            success.show();
            username = usernameField.getText();
            password = passwordField.getText();
            email = emailField.getText();
            loginScreen(loginWindow);

            try {
                WriteTo.writerUserInfo(username, password, email,0, 0, 0);
            } catch (IOException e) {
                System.out.println(e);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
