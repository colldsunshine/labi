import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import java.text.SimpleDateFormat;
import java.util.Date;

class AlarmClock {
    private int minutes;
    private int seconds;
    private Timer timer;
    private Timer updateTimeTimer;

    public AlarmClock() {
        timer = new Timer();
        updateTimeTimer = new Timer();
    }

    public void setAlarm(int minutes, int seconds) {
        this.minutes = minutes;
        this.seconds = seconds;

        // Суммарное время для срабатывания будильника в миллисекундах
        long alarmTime = (minutes * 60 + seconds) * 1000;

        // Отменяем предыдущие задачи таймера, если они есть
        timer.cancel();
        timer = new Timer();

        // Устанавливаем новую задачу для будильника
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                triggerAlarm();  // Срабатывание будильника
            }
        }, alarmTime);
    }

    private void triggerAlarm() {
        // Логика срабатывания будильника
        System.out.println("Будильник сработал!");  // Можете заменить на более подходящее действие

        // Звуковое уведомление о срабатывании будильника
        Toolkit.getDefaultToolkit().beep();

        // Окно уведомления
        JOptionPane.showMessageDialog(null, "Время вышло! Будильник сработал!");
    }

    // Метод для начала обновления текущего времени
    public void startClockUpdate(JLabel timeLabel) {
        updateTimeTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updateTime(timeLabel);  // Обновляем время каждую секунду
            }
        }, 0, 1000); // 1000 миллисекунд = 1 секунда
    }

    // Обновляем метку с временем
    private void updateTime(JLabel timeLabel) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); // Формат времени
        String currentTime = sdf.format(new Date()); // Получаем текущее время
        timeLabel.setText(currentTime); // Обновляем текст метки
    }
}