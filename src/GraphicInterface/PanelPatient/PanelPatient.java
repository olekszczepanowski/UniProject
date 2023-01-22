package GraphicInterface.PanelPatient;

import javax.swing.*;
import java.io.IOException;

public class PanelPatient extends JTabbedPane {
    public PanelPatient() throws IOException {
        add("See my profile", new PanelShowProfile());
        add("My healthcare", new PanelIllnessAndDrugs());
        add("Book an appointment", new PanelAppointment());
    }
}
