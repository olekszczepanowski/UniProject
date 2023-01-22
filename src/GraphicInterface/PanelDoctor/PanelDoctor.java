package GraphicInterface.PanelDoctor;

import javax.swing.*;
import java.io.IOException;

public class PanelDoctor extends JTabbedPane {

    public PanelDoctor() throws IOException {
        add("See my profile", new PanelShowProfileDoctor());
        add("Find patient", new PanelShowPatient());
        add("Opinions and Appointments", new PanelIOpinionsandAppointments());
        add("Make diagnosis", new PanelDiagnose());
    }
}
