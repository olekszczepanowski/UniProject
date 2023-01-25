package GraphicInterface.PanelDoctor;

import Controllers.DoctorController;
import Service.Opinion;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.IOException;

public class WindowOpinions extends JPanel {
    private static JDialog MainDialog;
    private static JFrame frame = new JFrame("Opinions");

    public WindowOpinions() {
        JPanel test = new JPanel();
        test.setLayout(new GridLayout(DoctorController.loggedDoctor().getOpinions().size(), 1, -20, 0));
        test.setPreferredSize(new Dimension(400, 2000));
        JScrollPane scrollFrame = new JScrollPane(test);
        test.setAutoscrolls(true);
        scrollFrame.setPreferredSize(new Dimension(400, 600));
        this.add(scrollFrame);
        int i = 0;
        Border blackline = BorderFactory.createLineBorder(Color.black);
        for (Opinion opinion : DoctorController.loggedDoctor().getOpinions()) {
            i++;
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3, 1, 0, 0));
            panel.add(new JLabel("Opinion nr: " + i));
            panel.add(new JLabel("Value: " + opinion.getValue()));
            String html = "<html><body style='width: %1spx'>%1s";
            String text= "<html>"+opinion.getContent()+"</html>";
            panel.add(new JLabel(String.format(html, 200, text)));
            panel.setBorder(blackline);
            test.add(panel);
        }
        add(scrollFrame);
        if (DoctorController.loggedDoctor().getOpinions().size() == 0) {
            JOptionPane.showMessageDialog(null, "No opinions yet", "",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void createAndShowGui() throws IOException {
        MainDialog = new JDialog();
        MainDialog.setTitle(frame.getTitle());
        MainDialog.setModal(true);
        MainDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        MainDialog.getContentPane().add(new WindowOpinions());
        MainDialog.pack();
        MainDialog.setLocationRelativeTo(null);
        MainDialog.setVisible(true);
    }
}
