package Controllers;

import GraphicInterface.Components.Frame;
import GraphicInterface.Menu.PanelMenu;

import java.io.IOException;

public class MenuController {
    public static void ChangePanel() throws IOException {
        Frame.getFrame().set(new PanelMenu());
    }
}
