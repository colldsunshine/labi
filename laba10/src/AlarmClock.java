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

        long alarmTime = (minutes * 60 + seconds) * 1000;

        timer.cancel();
        timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                triggerAlarm();
            }
        }, alarmTime);
    }

    private void triggerAlarm() {
        System.out.println("Будильник установлен");
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(null, "Пора просыпаться!");
    }

    public void startClockUpdate(JLabel timeLabel) {
        updateTimeTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updateTime(timeLabel);
            }
        }, 0, 1000);
    }

    private void updateTime(JLabel timeLabel) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String currentTime = sdf.format(new Date());
        timeLabel.setText(currentTime);
    }
}