import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AlarmPanel extends JPanel {
    private JTextField minuteField, secondField;
    private JButton setAlarmButton;
    private AlarmClock alarmClock;
    private JLabel timeLabel;  // Метка для отображения времени

    public AlarmPanel(AlarmClock alarmClock) {
        this.alarmClock = alarmClock;

        // Устанавливаем компоновку (например, GridBagLayout для гибкости)
        setLayout(new BorderLayout());

        // Создаем метку для времени
        timeLabel = new JLabel("00:00:00");
        timeLabel.setFont(new Font("Serif", Font.BOLD, 50)); // Сделаем шрифт крупным
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER); // Выровнять по центру
        add(timeLabel, BorderLayout.CENTER); // Размещаем по центру

        // Панель для настроек будильника
        JPanel settingsPanel = new JPanel();
        settingsPanel.setLayout(new FlowLayout());

        minuteField = new JTextField(2);  // Поле для минут
        secondField = new JTextField(2);  // Поле для секунд
        setAlarmButton = new JButton("Set Alarm");

        setAlarmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Получаем текст из текстовых полей
                String minuteText = minuteField.getText();
                String secondText = secondField.getText();

                // Если минуты не введены, по умолчанию считаем их 0
                if (minuteText.isEmpty()) {
                    minuteText = "0";
                }

                try {
                    // Преобразуем строки в числа
                    int minutes = Integer.parseInt(minuteText);
                    int seconds = 0;  // Если секунды не введены, то считаем их 0

                    // Если секунды введены, то преобразуем их
                    if (!secondText.isEmpty()) {
                        seconds = Integer.parseInt(secondText);
                    }

                    // Устанавливаем будильник
                    alarmClock.setAlarm(minutes, seconds);
                    JOptionPane.showMessageDialog(null, "Будильник установлен!");

                } catch (NumberFormatException ex) {
                    // Обработка ошибки, если введено не число
                    JOptionPane.showMessageDialog(null, "Ошибка: введите корректные значения для минут и секунд.");
                }
            }
        });

        // Добавляем элементы на панель настроек
        settingsPanel.add(new JLabel("Minutes:"));
        settingsPanel.add(minuteField);
        settingsPanel.add(new JLabel("Seconds:"));
        settingsPanel.add(secondField);
        settingsPanel.add(setAlarmButton);

        // Размещаем панель настроек внизу
        add(settingsPanel, BorderLayout.SOUTH);
    }

    // Метод для начала обновления времени на экране
    public void startClock() {
        alarmClock.startClockUpdate(timeLabel);
    }
}