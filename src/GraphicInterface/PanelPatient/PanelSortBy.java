package GraphicInterface.PanelPatient;

import GraphicInterface.Components.Frame;
import GraphicInterface.Components.GeneralPanel;

import javax.swing.*;
import java.io.IOException;

public class PanelSortBy extends GeneralPanel {
    private static JLabel SortBy = new JLabel("Sort by:");
    private static JButton ButtonFast = new JButton("Shortest amount to wait");
    private static JButton ButtonGood = new JButton("Best Average Opinion");
    private static JButton ButtonReturn = new JButton("Return");

    public static JLabel getSortBy() {
        return SortBy;
    }

    public static JButton getButtonFast() {
        return ButtonFast;
    }

    public static JButton getButtonGood() {
        return ButtonGood;
    }

    public PanelSortBy(String spetialization) throws IOException {
        add(SortBy, getC(8, 4, 0, 0, 0, 0));
        add(ButtonFast, getC(8, 7, 0, 0, 0, 0));
        add(ButtonGood, getC(8, 9, 0, 0, 0, 0));
        add(ButtonReturn, getC(3, 12, 0, 0, 0, 0));
        ButtonReturn.addActionListener(e -> {
            try {
                Frame.getFrame().setTab(new PanelPatient());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        ButtonFast.addActionListener(e -> {
            try {
                WindowAppointmentByTime.createAndShowGui(spetialization);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        ButtonGood.addActionListener(e -> {
            try {
                WindowAppointmentByOpinion.createAndShowGui(spetialization);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

    }
}
