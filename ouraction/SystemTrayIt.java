package ouraction;

import java.awt.*;

public class SystemTrayIt extends Dashboard{

    static void SystemTrayIt(){
        if(!SystemTray.isSupported()){
            System.out.println("System tray not supported");
            return;
        }

    }
}
