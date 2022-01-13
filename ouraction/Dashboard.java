package ouraction;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.LocalDateTime;

public class Dashboard extends LoginScreen  {
    private Text userDisplay = new Text();
    private CheckBox checkBoxCoffee = new CheckBox();
    private BorderPane parentDashPane;
    private LocalDateTime clock = LocalDateTime.now();
    private HBox leftSide;
    private VBox topDown;
    private HBox rightSide;

    private String currUser = LocalDB.user;

    private TextArea graphPlaceHolder1 = new TextArea();
    private TextArea graphPlaceHolder2 = new TextArea();
    private TextArea graphPlaceHolder3 = new TextArea();
    private TextArea graphPlaceHolder4 = new TextArea();
    private TextArea graphPlaceHolder5 = new TextArea();
    private TextArea graphPlaceHolder6 = new TextArea();

    int mouseClickCount = 0;
    int keyStrokes = 0;

    Scene dashScene;

    static Person currentPerson;

    //ON CLOSE CLICK ADD VALUES OF CLICK, KEYSTROKES ETC TO THE PERSONS MAP

    public void dashboardMain(Person person){
        Image loginImage = new Image(LoginScreen.class.getResource("LoginLogo.png").toExternalForm());
        currentPerson = person;

        loginWindow.setTitle("ActionBoard");
        //parentDashPane.setStyle("-fx-background-color: #1e1f1e");

        MouseMoveOnScreen mm = new MouseMoveOnScreen();
        boxInit();
        //mm.mouseMoveOnScreen();
        parentDashPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(event.getScreenX());
                System.out.println(event.getScreenY());
            }
        });


        loginWindow.setOnCloseRequest(e -> {
            Main.data.personMap.get(currentPerson.getUsername()).setMouseClicks(mouseClickCount);
            loginWindow.close();
        });

        //parentDashPane.setTop(userDisplay);
        //Scene loginScene = new Scene(newPane, 600, 400);
        //Scene dashScene = new Scene(parentDashPane,800,600);
        loginWindow.setScene(getDashScene());
        loginWindow.show();


    }



    public BorderPane getParentDashPane(){
        return parentDashPane;
    }

    public int getMouseClickCount(){
        int mouseClickCount = 0;
        while(checkBoxCoffee.isSelected()) {
            this.getParentDashPane().setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    System.out.println(event.getScreenX());
                    System.out.println(event.getScreenY());
                }
            });
        }
        return mouseClickCount;
    }


    public void boxInit(){
        parentDashPane = new BorderPane();
        leftSide = new HBox();
        rightSide = new HBox();
        topDown = new VBox();
        currUser = currentPerson.getUsername();

        parentDashPane.setTop(userDisplay);
        parentDashPane.setLeft(topDown);

        leftSide.setAlignment(Pos.CENTER_LEFT);
        rightSide.setAlignment(Pos.CENTER_RIGHT);
        topDown.setAlignment(Pos.TOP_LEFT);

        userDisplay.setStyle("-fx-font: 14 verdana; -fx-base: #00a3cc");
        userDisplay.setFill(Color.AQUAMARINE);
        userDisplay.setText("Welcome, " + currUser);

        leftSide.setAlignment(Pos.TOP_LEFT);

        parentDashPane.setStyle("-fx-background-color: #1e1f1e");

        topDown.getChildren().addAll(checkBoxCoffee,graphPlaceHolder2,graphPlaceHolder3
                ,graphPlaceHolder4,graphPlaceHolder5,graphPlaceHolder6);
        topDown.setSpacing(20.00);
        //setScene
        dashScene = new Scene(parentDashPane,800,600);
        getMouseClickCount();
    }


    public Scene getDashScene(){
        boxInit();
        return dashScene;

    }

}
