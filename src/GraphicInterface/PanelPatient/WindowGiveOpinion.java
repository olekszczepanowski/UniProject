package GraphicInterface.PanelPatient;

import Controllers.PatientController;
import Service.Opinion;
import GraphicInterface.Components.GeneralPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.RGBImageFilter;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class WindowGiveOpinion extends JPanel {

    private static JDialog MainDialog;
    private static int value;
    private static String opinion;
    private static JFrame frame = new JFrame("Rate Your Doctor");
    private static GeneralPanel.HintTextField jTextArea = new GeneralPanel.HintTextField("Write your opinion here");

    WindowGiveOpinion() throws IOException {
        super(new GridLayout(3, 2, 4, 4));
        Image img = ImageIO.read(new File("Resources/mark.jpg"));
        ImageIcon defaultIcon = new ImageIcon(img);
        ImageIcon star = makeStarImageIcon(img, new SelectedImageFilter(1f, 1f, 0f));
        java.util.List<ImageIcon> list4 = Arrays.asList(star, star, star, star, star);
        add(makeStarRatingPanel(new LevelBar(defaultIcon, list4, 1)));
        add(MakeTextField());
        add(AddButton());
        setPreferredSize(new Dimension(320, 180));
    }

    private JPanel makeStarRatingPanel(LevelBar label) {
        JPanel MainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        MainPanel.setBorder(BorderFactory.createTitledBorder("Evaluated doctor: " + PatientController.getDoctor().getFirstName() + " " + PatientController.getDoctor().getSurname()));
        MainPanel.add(label);
        return MainPanel;
    }

    private JPanel MakeTextField() {
        JPanel PanelTextArea = new JPanel(new GridLayout(1, 1, 0, 0));
        jTextArea.setBounds(0, 0, 320, 120);
        jTextArea.setBackground(Color.white);
        PanelTextArea.add(jTextArea);
        return PanelTextArea;
    }

    private JPanel AddButton() {
        JPanel PanelButton = new JPanel(new GridLayout(1, 1, 0, 0));
        JButton ButtonSubmit = new JButton("Submit");
        ButtonSubmit.setIgnoreRepaint(true);
        ButtonSubmit.setBounds(0, 0, 100, 40);
        ButtonSubmit.addActionListener(e -> {
            opinion = jTextArea.getText();
            if ((Objects.equals(opinion, "")) && (value == 0)) {
                jTextArea.setText("");
                jTextArea.setBackground(Color.white);
                LevelBar.setClicked(0);
                LevelBar.setValue(0);
                MainDialog.dispose();
            } else {
                jTextArea.setText("");
                jTextArea.setBackground(Color.white);
                LevelBar.setClicked(0);
                LevelBar.setValue(0);
                PatientController.loggedPatient().addOpinion(new Opinion(value + 1, opinion), PatientController.getDoctor());
                MainDialog.dispose();
            }
        });
        PanelButton.add(ButtonSubmit);
        return PanelButton;
    }

    private static ImageIcon makeStarImageIcon(Image image, ImageFilter filter) {
        FilteredImageSource producer = new FilteredImageSource(image.getSource(), filter);
        return new ImageIcon(Toolkit.getDefaultToolkit().createImage(producer));
    }

    public static void createAndShowGui() throws IOException {
        MainDialog = new JDialog();
        MainDialog.setTitle(frame.getTitle());
        MainDialog.setModal(true);
        MainDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        MainDialog.getContentPane().add(new WindowGiveOpinion());
        MainDialog.pack();
        MainDialog.setLocationRelativeTo(null);
        MainDialog.setVisible(true);
        jTextArea.requestFocus();
    }

    class LevelBar extends JPanel {
        private final int gap;
        private final java.util.List<ImageIcon> iconList;
        private final java.util.List<JLabel> labelList = Arrays.asList(
                new JLabel(), new JLabel(), new JLabel(), new JLabel(), new JLabel()
        );
        protected final ImageIcon defaultIcon;
        private static int clicked = -1;
        private transient MouseAdapter handler;

        public static void setValue(int value) {
            clicked = value;
        }

        public static void setClicked(int clicked) {
            LevelBar.clicked = clicked;
        }

        protected LevelBar(ImageIcon defaultIcon, List<ImageIcon> list, int gap) {
            super(new GridLayout(1, 5, gap * 2, gap * 5));
            this.defaultIcon = defaultIcon;
            this.iconList = list;
            this.gap = gap;
            repaintIcon(clicked);
            for (JLabel l : labelList) {
                l.setIcon(defaultIcon);
                add(l);
            }
        }

        @Override
        public void updateUI() {
            removeMouseListener(handler);
            removeMouseMotionListener(handler);
            super.updateUI();
            handler = new MouseAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    repaintIcon(getSelectedIconIndex(e.getPoint()));
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    repaintIcon(getSelectedIconIndex(e.getPoint()));
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    clicked = getSelectedIconIndex(e.getPoint());
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    repaintIcon(clicked);
                }
            };
            addMouseListener(handler);
            addMouseMotionListener(handler);
        }


        protected int getSelectedIconIndex(Point p) {
            for (int i = 0; i < labelList.size(); i++) {
                Rectangle r = labelList.get(i).getBounds();
                r.grow(gap, gap);
                if (r.contains(p)) {
                    return i;
                }
            }
            return -1;
        }

        public void repaintIcon(int index) {
            for (int i = 0; i < labelList.size(); i++) {
                if (labelList.get(i).getClass() == JLabel.class) {
                    labelList.get(i).setIcon(i <= index ? iconList.get(i) : defaultIcon);
                }
            }
            value = index;
            repaint();
        }
    }

    static class SelectedImageFilter extends RGBImageFilter {
        private final float rf;
        private final float gf;
        private final float bf;

        protected SelectedImageFilter(float rf, float gf, float bf) {
            super();
            this.rf = Math.min(1f, rf);
            this.gf = Math.min(1f, gf);
            this.bf = Math.min(1f, bf);
            canFilterIndexColorModel = false;
        }

        @Override
        public int filterRGB(int x, int y, int argb) {
            int r = Math.round(((argb >> 16) & 0xFF) * rf);
            int g = Math.round(((argb >> 8) & 0xFF) * gf);
            int b = Math.round((argb & 0xFF) * bf);
            return (argb & 0xFF_00_00_00) | (r << 16) | (g << 8) | b;
        }
    }
}
