package GraphicInterface.Menu;

import GraphicInterface.Components.GeneralPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import GraphicInterface.Components.Frame;

public class PanelMenu extends GeneralPanel {

    static Image scaled;
    private static PanelMenu menu;

    static {
        try {
            menu = new PanelMenu();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static PanelMenu getMenu() {
        return menu;
    }

    public PanelMenu() throws IOException {
        super();
        Image backgroundImage = ImageIO.read(new File("Resources/loginbackground.jpg"));
        scaled = backgroundImage.getScaledInstance(Frame.getFrame().getWidth(), Frame.getFrame().getHeight(), Image.SCALE_SMOOTH);

        JLabel LabelLogin = new JLabel("Log in");
        LabelLogin.setForeground(Color.WHITE);
        JLabel LabelChooseLogin = new JLabel("<html>" + "Choose logging<br> option:" + "</html>");
        LabelChooseLogin.setFont(new Font("Inter", Font.BOLD, 40));
        LabelChooseLogin.setForeground(Color.WHITE);
        JLabel LabelRegistration = new JLabel("<html>" + "Are you here for the first time? Register for free" + "<html>");
        LabelLogin.setHorizontalAlignment(0);
        LabelChooseLogin.setHorizontalAlignment(0);
        LabelRegistration.setHorizontalAlignment(0);

        JButton ButtonLoginDoctor = new JButton("Doctor");
        JButton ButtonLoginPatient = new JButton("Patient");
        JButton ButtonRegistration = new JButton("Register");
        JButton ButtonAdmin = new JButton("Admin panel");

        ButtonLoginPatient.addActionListener(e -> {
            try {
                Frame.getFrame().set(new PanelLoginPatient());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        ButtonLoginDoctor.addActionListener(e -> {
            try {
                Frame.getFrame().set(new PanelLoginDoctor());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        ButtonRegistration.addActionListener(e -> {
            try {
                Frame.getFrame().set(new RegisterPanel());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        ButtonAdmin.addActionListener(e -> {
            try {
                Frame.getFrame().set(new PanelLoginAdmin());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        LabelLogin.setFont(new Font("Now", Font.PLAIN, 18));
        LabelLogin.setOpaque(false);
        add(LabelLogin, getC(1, 7, 0.6, 0.6, 0, 10));

        LabelChooseLogin.setFont(new Font("Now", Font.PLAIN, 18));
        LabelChooseLogin.setOpaque(false);
        add(LabelChooseLogin, getC(1, 9, 0, 0, 80, 20));

        add(ButtonLoginPatient, getC(1, 10, 0, 0, 0, 40));

        add(ButtonLoginDoctor, getC(1, 11, 0, 0, 0, 40));

        LabelRegistration.setFont(new Font("Now", Font.ITALIC, 13));
        LabelRegistration.setOpaque(true);
        add(LabelRegistration, getC(12, 11, 0, 0, 110, 20));

        add(ButtonRegistration, getC(12, 12, 0, 0, 0, 40));

        add(ButtonAdmin, getC(13, 1, 0, 0, 20, 20));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension d = Frame.getFrame().getSize();
        g.drawImage(scaled, 0, 0, (int) d.getWidth(), (int) d.getHeight(), this);
    }
}
