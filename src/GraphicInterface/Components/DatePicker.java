package GraphicInterface.Components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.*;

public class DatePicker {
    private static int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
    private static int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
    ;
    JLabel l = new JLabel("", JLabel.CENTER);
    private static String day = "";
    JDialog d;
    JButton[] button = new JButton[49];

    public DatePicker(JFrame parent) {
        d = new JDialog();
        d.setModal(true);
        String[] header = {"Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat"};
        JPanel p1 = new JPanel(new GridLayout(7, 7));
        p1.setPreferredSize(new Dimension(430, 120));

        for (int x = 0; x < button.length; x++) {
            final int selection = x;
            button[x] = new JButton();
            button[x].setFocusPainted(false);
            button[x].setBackground(Color.white);
            if (x > 6)
                button[x].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        day = button[selection].getActionCommand();
                        d.dispose();
                    }
                });
            if (x < 7) {
                button[x].setText(header[x]);
                button[x].setForeground(Color.red);
            }
            p1.add(button[x]);
        }
        JPanel p2 = new JPanel(new GridLayout(1, 3));
        JButton next = new JButton("Next >>");
        JButton previous = new JButton("<< Previous");
        previous.setEnabled(false);
        previous.addActionListener(ae -> {
            month--;
            displayDate();
            next.setEnabled(true);
            if (month == Calendar.getInstance().get(Calendar.MONTH)) {
                previous.setEnabled(false);
            }
        });
        p2.add(previous);
        p2.add(l);
        next.addActionListener(ae -> {
            month++;
            displayDate();
            previous.setEnabled(true);
            if (month == Calendar.getInstance().get(Calendar.MONTH) + 4) {
                next.setEnabled(false);
            }
        });
        p2.add(next);
        d.add(p1, BorderLayout.CENTER);
        d.add(p2, BorderLayout.SOUTH);
        d.pack();
        d.setLocationRelativeTo(parent);
        displayDate();
        d.setVisible(true);
    }

    public static String getDay() {
        return day;
    }

    public static int getMonth() {
        return month;
    }

    public static int getYear() {
        return year;
    }

    public void displayDate() {
        for (int x = 7; x < button.length; x++)
            button[x].setText("");
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
                "MMMM yyyy");
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(year, month, 1);
        int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);
        int daysInMonth = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
        for (JButton button : button) {
            button.setEnabled(false);
        }
        for (int i = 0; i <= 6; i++) {
            button[i].setEnabled(true);
        }
        for (int x = 6 + dayOfWeek, day = 1; day <= daysInMonth; x++, day++) {
            button[x].setText("" + day);
            button[x].setEnabled(true);
            if (month == java.util.Calendar.getInstance().get(java.util.Calendar.MONTH) && day < java.util.Calendar.getInstance().get(Calendar.DAY_OF_MONTH)) {
                button[x].setEnabled(false);
            }
        }
        l.setText(sdf.format(cal.getTime()));
        d.setTitle("Date Picker");
    }

    public String setPickedDate() {
        if (day.equals(""))
            return day;
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
                "dd-MM-yyyy");
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(year, month, Integer.parseInt(day));
        return sdf.format(cal.getTime());
    }
}

