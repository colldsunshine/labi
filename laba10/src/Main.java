import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Alarm");
        AlarmClock alarmClock = new AlarmClock();
        AlarmPanel panel = new AlarmPanel(alarmClock);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        frame.add(panel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setVisible(true);

        panel.startClock();
    }
}