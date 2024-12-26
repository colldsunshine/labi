import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AlarmPanel extends JPanel {
    private JTextField minuteField, secondField;
    private JButton setAlarmButton;
    private AlarmClock alarmClock;
    private JLabel timeLabel;
    public AlarmPanel(AlarmClock alarmClock) {
        this.alarmClock = alarmClock;
        setLayout(new BorderLayout());

        timeLabel = new JLabel("00:00:00");
        timeLabel.setFont(new Font("Serif", Font.BOLD, 50));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(timeLabel, BorderLayout.CENTER);

        JPanel settingsPanel = new JPanel();
        settingsPanel.setLayout(new FlowLayout());

        minuteField = new JTextField(2);
        secondField = new JTextField(2);
        setAlarmButton = new JButton("Установить будильник");

        setAlarmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String minuteText = minuteField.getText();
                String secondText = secondField.getText();

                if (minuteText.isEmpty()) {
                    minuteText = "0";
                }

                try {
                    int minutes = Integer.parseInt(minuteText);
                    int seconds = 0;

                    if (!secondText.isEmpty()) {
                        seconds = Integer.parseInt(secondText);
                    }

                    alarmClock.setAlarm(minutes, seconds);
                    JOptionPane.showMessageDialog(null, "Будильник установлен");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Некорректный ввод");
                }
            }
        });

        settingsPanel.add(new JLabel("Min:"));
        settingsPanel.add(minuteField);
        settingsPanel.add(new JLabel("Sec:"));
        settingsPanel.add(secondField);
        settingsPanel.add(setAlarmButton);

        add(settingsPanel, BorderLayout.SOUTH);
    }

    public void startClock() {
        alarmClock.startClockUpdate(timeLabel);
    }
}