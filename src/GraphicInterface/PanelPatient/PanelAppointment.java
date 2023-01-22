package GraphicInterface.PanelPatient;

import GraphicInterface.Components.Frame;
import GraphicInterface.Components.GeneralPanel;
import GraphicInterface.Menu.PanelMenu;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PanelAppointment extends GeneralPanel {
    private static JLabel LabelChosenData = new JLabel();

    public static JLabel getLabelChosenData() {
        return LabelChosenData;
    }

    public PanelAppointment() throws IOException {
        JLabel LabelsetAppointment = new JLabel("<html>Book an appointment<br> Choose your doctor:<html>");
        LabelsetAppointment.setFont(new Font("Nul", Font.BOLD, 26));

        JButton ButtonFamilyDoctor = new JButton("Family doctor");
        ButtonFamilyDoctor.addActionListener(e -> {
            try {
                Frame.getFrame().set(new PanelSortBy("Family doctor"));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        JButton ButtonLaryngolog = new JButton("Laryngologist");
        ButtonLaryngolog.addActionListener(e -> {
            PanelChoosingAppointmentByOpinion.setText("Laryngologist");
            try {
                Frame.getFrame().set(new PanelSortBy("Laryngologist"));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        JButton ButtonOrthopedist = new JButton("Orthopedist");
        ButtonOrthopedist.addActionListener(e -> {
            try {
                Frame.getFrame().set(new PanelSortBy("Orthopedist"));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        JButton ButtonDermatolog = new JButton("Dermatologist");
        ButtonDermatolog.addActionListener(e -> {
            try {
                Frame.getFrame().set(new PanelSortBy("Dermatologist"));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        JButton ButtonHeartSpecialist = new JButton("Cardiologist");
        ButtonHeartSpecialist.addActionListener(e -> {
            try {
                Frame.getFrame().set(new PanelSortBy("Cardiologist"));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        JButton ButtonOnkolog = new JButton("Oncologist");
        ButtonOnkolog.addActionListener(e -> {
            try {
                Frame.getFrame().set(new PanelSortBy("Oncologist"));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        JButton ButtonGynecologist = new JButton("Gynecologist");
        ButtonGynecologist.addActionListener(e -> {
            try {
                Frame.getFrame().set(new PanelSortBy("Gynecologist"));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        JButton ButtonOkulista = new JButton("Eye specialist");
        ButtonOkulista.addActionListener(e -> {
            try {
                Frame.getFrame().set(new PanelSortBy("Eye specialist"));
            } catch (IOException ignored) {
            }
        });
        JButton ButtonLogout = new JButton("Log out");
        ButtonLogout.addActionListener(e -> {
            try {
                Frame.getFrame().set(new PanelMenu());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        add(LabelsetAppointment, getC(7, 2, 0, 0, 0, 0));
        add(ButtonFamilyDoctor, getC(6, 4, 0, 0, 20, 10));
        add(ButtonOrthopedist, getC(6, 6, 0, 0, 40, 10));
        add(ButtonHeartSpecialist, getC(6, 8, 0, 0, 40, 10));
        add(ButtonGynecologist, getC(6, 10, 0, 0, 40, 10));
        add(ButtonLaryngolog, getC(8, 4, 0, 0, 40, 10));
        add(ButtonDermatolog, getC(8, 6, 0, 0, 40, 10));
        add(ButtonOnkolog, getC(8, 8, 0, 0, 40, 10));
        add(ButtonOkulista, getC(8, 10, 0, 0, 40, 10));
        add(ButtonLogout, getC(14, 1, 0, 0, 0, 10));
    }
}
