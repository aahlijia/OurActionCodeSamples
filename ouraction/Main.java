package ouraction;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    static LocalDB data;


    @Override
    public void start(Stage primaryStage) throws Exception{
        data = new LocalDB();

        LoginScreen logScreen = new LoginScreen();
        logScreen.loginScreen(primaryStage);



    }

    //ON STAGE CLOSE UPLOAD MOUSE CLICKS. SO FAR THIS IS...
    @Override
    public void stop(){
        System.out.println("Stage close");
        //GRABBING THE MAPPED PERSON VIA THE USERNAME THATS BROUGHT TO THE DASHBOARD
        //THE SET MOUSE CLICKS TO THAT DASHBOARD USER UPLOAD VIA SET MOUSE CLICKS
        //I DONT KNOW WHY ITS CALLING>>>           DASHBOARD.DASH                          THIS RIGHT HERE
        data.personMap.get(Dashboard.currentPerson.getUsername()).setMouseClicks(Dashboard.dash.mouseClickCount);
    }


    public static void main(String[] args) {
        launch(args);
    }
}




