package GraphicInterface.Components;

import Controllers.AdminController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;

public class Frame extends JFrame {

    private static Frame frame = new Frame();

    public static void setFrame(Frame frame) {
        Frame.frame = frame;
    }

    public static Frame getFrame() {
        return frame;
    }

    public Frame() throws HeadlessException {
        super("eHospital");
        try {
            setIconImage(ImageIO.read(new File("Resources/icon.png")));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(exitListener);
        pack();
        setSize(1200, 800);
        setVisible(true);
    }

    WindowListener exitListener = new WindowAdapter() {

        @Override
        public void windowClosing(WindowEvent e) {
            int confirm = JOptionPane.showOptionDialog(
                    null, "Are you sure you want to close the app?",
                    "Exit Confirmation", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (confirm == 0) {
                AdminController.saveAllData();
                System.exit(0);
            }
        }
    };

    public void set(JPanel panel) {
        setContentPane(panel);
        revalidate();
        repaint();
    }

    public void setTab(JTabbedPane panel) {
        setContentPane(panel);
        revalidate();
        repaint();
    }
}
