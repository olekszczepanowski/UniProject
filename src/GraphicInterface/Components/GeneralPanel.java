package GraphicInterface.Components;

import GraphicInterface.Menu.PanelMenu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public abstract class GeneralPanel extends JPanel {

    private final GridBagConstraints Constrains = new GridBagConstraints();
    private static final JButton ButtonReturn = new JButton("<-");
    protected static JButton ButtonLogOut = new JButton("Log out");
    private Image scaled = null;

    public GeneralPanel() throws IOException {
        ButtonLogOut.addActionListener(e -> {
            Frame.getFrame().set(PanelMenu.getMenu());
        });

        ButtonReturn.addActionListener(e -> {
            Frame.getFrame().set(PanelMenu.getMenu());
        });
        Image backgroundImage = ImageIO.read(new File("Resources/background.jpg"));
        scaled = backgroundImage.getScaledInstance(Frame.getFrame().getWidth(), Frame.getFrame().getHeight(), Image.SCALE_SMOOTH);
        setLayout(new GridBagLayout());
        for (int i = 0; i < 15; i++) {
            getC(i, i, 0.5, 0.5, 0, 0);
            add(new EmptyPanel(), Constrains);
        }
    }

    public static JButton getButtonReturn() {
        return ButtonReturn;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension d = Frame.getFrame().getSize();
        g.drawImage(scaled, 0, 0, (int) d.getWidth(), (int) d.getHeight(), this);
    }

    protected GridBagConstraints getC(int gridx, int gridy, double weightx, double weighty, int ipadx, int ipady) {
        Constrains.gridx = gridx;
        Constrains.gridy = gridy;
        Constrains.weightx = weightx;
        Constrains.weighty = weighty;
        Constrains.ipadx = ipadx;
        Constrains.ipady = ipady;
        Constrains.fill = GridBagConstraints.BOTH;
        return Constrains;
    }

    public static class HintTextField extends JTextField {
        public HintTextField(String hint) {
            _hint = hint;
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            if (getText().length() == 0) {
                int h = getHeight();
                ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                Insets ins = getInsets();
                FontMetrics fm = g.getFontMetrics();
                int c0 = getBackground().getRGB();
                int c1 = getForeground().getRGB();
                int m = 0xfefefefe;
                int c2 = ((c0 & m) >>> 1) + ((c1 & m) >>> 1);
                g.setColor(new Color(c2, true));
                g.drawString(_hint, ins.left, h / 2 + fm.getAscent() / 2 - 2);
            }
        }

        private final String _hint;
    }
}
