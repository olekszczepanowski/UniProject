package GraphicInterface.PanelDoctor;

import GraphicInterface.Components.Frame;
import GraphicInterface.Components.GeneralPanel;
import GraphicInterface.Menu.PanelMenu;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PanelIOpinionsandAppointments extends GeneralPanel {

    public PanelIOpinionsandAppointments() throws IOException {

        JLabel LabelRateDoctor = new JLabel("Check your Opinions");
        JButton ButtonRateDoctor = new JButton("Check");
        JLabel LabelShowAppointments = new JLabel("Show my appointments");
        JButton ButtonPrescribedDrugs = new JButton("Show");
        ButtonRateDoctor.addActionListener(a -> {
            try {
                WindowOpinions.createAndShowGui();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        ButtonPrescribedDrugs.addActionListener(a -> {
            try {
                WindowAppointments.createAndShowGui();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        LabelShowAppointments.setFont(new Font("Now", Font.BOLD, 27));
        LabelRateDoctor.setFont(new Font("Now", Font.BOLD, 27));
        add(LabelShowAppointments, getC(10, 6, 0, 0, 200, 0));
        add(ButtonPrescribedDrugs, getC(10, 7, 0, 0, 200, 0));
        add(ButtonLogOut, getC(14, 1, 0, 0, 0, 0));
        add(LabelRateDoctor, getC(5, 6, 0, 0, 200, 0));
        add(ButtonRateDoctor, getC(5, 7, 0, 0, 200, 0));
        ButtonLogOut.addActionListener(e -> {
            try {
                Frame.getFrame().set(new PanelMenu());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
