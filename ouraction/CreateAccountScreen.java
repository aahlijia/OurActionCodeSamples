package ouraction;


import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class CreateAccountScreen extends LoginScreen{
    static protected  Button confirm = new Button("Confirm");
    static protected  Button backButton = new Button();
    //protected  Scene createScene = new Scene(grid, 600,400);
    static protected TextField emailField = new TextField();
    static protected TextField usernameField = new TextField();
    static protected PasswordField passwordField = new PasswordField();
    static protected PasswordField password1Field = new PasswordField();
    static protected Text createAccountText = new Text();


     GridPane changeGrid;
     public static BorderPane newPane;
     static VBox textFieldGroup = new VBox();
     static public   String username;
     static public  String password;
     static public  String email;



    public static void changeScene() {
        newPane = new BorderPane();
        //cAC = new AccountClick();
       // changeGrid = new GridPane();

        loginWindow.setTitle("Create an Account");

        try {
            buttonSetUp();
        } catch (Exception e) {
            e.printStackTrace();
        }
        textBoxes();

        newPane.setStyle("-fx-background-color: #1e1f1e");
        System.out.println(passwordField.getText());
        //Scene loginScene = new Scene(newPane, 600, 400);

        Scene loginScene = new Scene(newPane,600,400);

        loginWindow.setScene(loginScene);
        loginWindow.show();
    }


    public static void textBoxes(){
        //changeGrid = new GridPane();
        textFieldGroup = new VBox();

        textFieldGroup.setAlignment(Pos.CENTER);
        textFieldGroup.setSpacing(27.0);

        usernameField.setPromptText("Username");
        usernameField.setFocusTraversable(false);
        usernameField.setStyle("-fx-background-radius: 0; -fx-background-color: #a1a1a1; -fx-prompt-text-fill: white; -fx-text-fill: white");

        passwordField = new PasswordField();
        password1Field = new PasswordField();

        passwordField.setPromptText("Password");
        passwordField.setStyle("-fx-background-radius: 0; -fx-background-color: #a1a1a1; -fx-prompt-text-fill: white; -fx-text-fill: white");
        password1Field.setPromptText("Verify Password");
        password1Field.setStyle("-fx-background-radius: 0; -fx-background-color: #a1a1a1; -fx-prompt-text-fill: white; -fx-text-fill: white");

        emailField = new TextField();

        emailField.setPromptText("E-mail");
        emailField.setFocusTraversable(false);
        emailField.setStyle("-fx-background-radius: 0; -fx-background-color: #a1a1a1; -fx-prompt-text-fill: white; -fx-text-fill: white");

        createAccountText.setText("Create Account");

        createAccountText.setFill(Color.AQUA);
        createAccountText.setStyle("-fx-font: 14 arial");

        textFieldGroup.setMaxSize(150,100);
        textFieldGroup.getChildren().addAll(createAccountText,usernameField,emailField,passwordField,password1Field,confirm);

        newPane.setCenter(textFieldGroup);
        newPane.setTop(backButton);

        BorderPane.setAlignment(confirm, Pos.BOTTOM_CENTER);

    }

    public static void buttonSetUp() throws Exception{
        //Back button image
        backButton.setStyle("-fx-focus-color: white");
        Image backArrow = new Image(CreateAccountScreen.class.getResource("back_adobespark_original.png").toExternalForm());
        ImageView imageView = new ImageView(backArrow);
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        backButton.setStyle("-fx-background-radius: 2; -fx-background-color: transparent");
        backButton.setGraphic(imageView);
        backButton.setAlignment(Pos.TOP_LEFT);
        backButton.setOnAction(e -> backButtonOnClick());
        confirm.setStyle("-fx-background-radius: 2; -fx-font: 10 arial; -fx-base:#00a3cc");
        confirm.setPrefSize(100,15);
        newPane.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent k) {
                if (k.getCode().equals(KeyCode.ENTER)) {
                    CreateAccountClick.createAccountOnClick();
                }
            }
        });
        confirm.setOnAction(e -> CreateAccountClick.createAccountOnClick());

    }



    private static void backButtonOnClick(){
        loginScreen(loginWindow);
    }



    public static BorderPane getChangeGrid() {
        return newPane;

    }


    public static boolean parseEmail(String email){
        if(email.contains("@") && email.contains(".com")){
            return true;
        }
        else {
            return false;
        }

    }


    public static boolean isSpace(){
        if (usernameField.getText().contains(" "))
            return false;

        else if (passwordField.getText().contains(" "))
            return false;

        else if (password1Field.getText().contains(" "))
            return false;

        else if (emailField.getText().contains(" "))
            return false;

        else return true;

    }

    public static boolean checkPass(String pass){
        int capitalCount = 0;
        int symbolCount = 0;
        if (passwordField.getText().length() < 5){
            return false;
        }
        char[] passArray = passwordField.getText().toCharArray();
        for (int i = 0; i < passArray.length; i++){
                int ascii = passArray[i];
                if (ascii >= 65 && ascii <= 90){
                    capitalCount++;
                }
                if (ascii <= 65 && ascii >= 32){
                    symbolCount++;
                }
            }
        if (symbolCount > 0 && capitalCount > 0){
            return true;
        }
        return false;
    }

}
