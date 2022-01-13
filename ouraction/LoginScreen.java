package ouraction;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class LoginScreen {
    static private Button btnLogin = new Button("Login");
    static private Button btnCreateAccount = new Button("Create Account");
    static private TextField logUsernameField = new TextField();
    static private PasswordField logPasswordField = new PasswordField();
    static GridPane grid = new GridPane();
    static public Stage loginWindow = new Stage();
    static Dashboard dash;
     //CreateAccountScreen cs = new CreateAccountScreen();
    static PasswordHash hash;


    public static void loginScreen(Stage primaryStage)  {
        //set title for initial screen
        //initialize gridpane & set

        Image loginImage = new Image(LoginScreen.class.getResource("LoginLogo.png").toExternalForm());
        ImageView iv = new ImageView(loginImage);
        grid = new GridPane();
        loginWindow.setTitle("OurAction Login");
        loginWindow.setResizable(false);
        String words = "the Guy";
        StringBuilder sb = new StringBuilder(50);
        Integer j = 0;
        String[] wordsArray = words.split(" ");
        for(Integer i = 0; i < wordsArray.length; i ++){
            if(wordsArray[j].contains(i.toString()));
        }

        Image image = new Image(LoginScreen.class.getResource("icon.png").toExternalForm());
        HBox buttonGroup = new HBox();
        buttonGroup.setSpacing(27.0);
        int a = 0;
        int b = 1;
        int c = b/a;
        System.out.println(c);

        //create login button and set action to corresponding method
        btnLogin.setOnAction(e -> loginClick());

        //create account button and set action to corresponding methgod
        btnCreateAccount.setOnAction(e -> createAccountClick());
        btnCreateAccount.setStyle("-fx-background-radius: 2;");
        btnLogin.setStyle("-fx-background-radius: 2;");
        buttonGroup.getChildren().addAll(btnLogin,btnCreateAccount);
        buttonGroup.setPrefSize(100,15);

        //set layout of button, default centered
        //column constraints
        GridPane grid = new GridPane();
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setHalignment(HPos.RIGHT);
        grid.getColumnConstraints().add(column1);

        ColumnConstraints column2 = new ColumnConstraints();
        column2.setHalignment(HPos.LEFT);
        grid.getColumnConstraints().add(column2);
        //grid H/V gap settings & alignment
        grid.setHgap(10);
        grid.setVgap(12);
        grid.setAlignment(Pos.CENTER);

        //button & text field styling
        buttonGroup.setStyle("-fx-font: 10 arial; -fx-base: #00a3cc");
        logUsernameField.setPromptText("Email or Username");
        logUsernameField.setFocusTraversable(false);
        logPasswordField.setPromptText("Password");
        logPasswordField.setFocusTraversable(false);
        logUsernameField.setStyle("-fx-background-radius: 0; -fx-background-color: #a1a1a1; -fx-prompt-text-fill: white; -fx-text-fill: white");
        logPasswordField.setStyle("-fx-background-radius: 0; -fx-background-color: #a1a1a1; -fx-prompt-text-fill: white; -fx-text-fill: white");

        //populate user/password text fields
        grid.add(iv,0,0);
        grid.add(logUsernameField, 0,1);
        grid.add(logPasswordField, 0,2);
        grid.add(buttonGroup, 0,3,3,1);

        grid.setStyle("-fx-background-color: #1e1f1e");

        loginWindow.getIcons().add(image);
        Scene loginScene = new Scene(grid, 600,400);;
        loginWindow.setScene(loginScene);
        loginWindow.show();

    }

    static void doFadeIn() {

    }

    //THIS SHOULD WORK, BUT WHO KNOWS
    public static void loginClick(){
        dash = new Dashboard();
        hash = new PasswordHash();
        String currHashPass = hash.hashMethod(logPasswordField.getText());
        String passToCompare = Main.data.personMap.get(logUsernameField.getText()).getPassword();


        if(logUsernameField.getText() == logUsernameField.getPromptText() || logUsernameField.getText() == null){
            nullField();
        }
        //Main.data.personMap.get(logUsernameField.getText()).getPassword().equals(currHashPass)
        //I BELIEVE THIS SHOULD WO
        // ){
        else if(currHashPass != passToCompare){
            dash.dashboardMain(Main.data.personMap.get(logUsernameField.getText()));
        } else if (currHashPass == passToCompare){
            loginWindow.setScene(dash.getDashScene());
        }
        else{
            //just trying to get scene to change based on return scene from Dashboard boxInit method
            loginWindow.setScene(dash.getDashScene());
            nullField();
        }
    }

    public static GridPane getGrid(){
        return grid;
    }

    public static void nullField(){
        Alert wrongLogin = new Alert(Alert.AlertType.ERROR);
        wrongLogin.setTitle("Login Error");
        wrongLogin.setContentText("Username and/or password is incorrect or empty");
        wrongLogin.show();
    }


    public static void createAccountClick()  {
       CreateAccountScreen.changeScene();
    }
}
