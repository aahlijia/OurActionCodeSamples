package ouraction;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MouseMoveOnScreen {
   MouseEvent newMouse;
   Dashboard dashBoard;

    public void mouseMoveOnScreen(){

        dashBoard.getParentDashPane().setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(event.getScreenX());
                System.out.println(event.getScreenY());
            }
        });
    }
}
