package GraphicInterface.PanelPatient;

import Controllers.PatientController;
import Model.Medicine;
import Service.Diagnosis;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class WindowIllnessHistory extends JPanel {
    private static JDialog MainDialog;
    private static JFrame frame = new JFrame("History of diseases");

    WindowIllnessHistory() {
        JPanel test = new JPanel();
        test.setPreferredSize(new Dimension(400, Math.min(200, PatientController.showDiagnoses().size() * 50)));
        JScrollPane scrollFrame = new JScrollPane(test);
        test.setAutoscrolls(true);
        scrollFrame.setPreferredSize(new Dimension(400, 200));
        this.add(scrollFrame);
        for (Diagnosis diagnosis : PatientController.showDiagnoses()) {
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3 + diagnosis.getMedicines().size(), 1, 0, 0));
            panel.add(new JLabel("Date: " + diagnosis.getDate()));
            panel.add(new JLabel("Diagnosis: " + diagnosis.getDiagnosis()));
            panel.add(new JLabel("Prescribed medicines: "));
            for (Medicine medicine : diagnosis.getMedicines())
                panel.add(new JLabel(medicine.getName()));
            test.add(panel);
            add(scrollFrame);
        }
    }

    public static void createAndShowGui() throws IOException {
        MainDialog = new JDialog();
        MainDialog.setTitle(frame.getTitle());
        MainDialog.setModal(true);
        MainDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        MainDialog.getContentPane().add(new WindowIllnessHistory());
        MainDialog.pack();
        MainDialog.setLocationRelativeTo(null);
        MainDialog.setVisible(true);
    }
}
