import java.util.ArrayList;
import java.util.List;

interface AlarmListener {
    void onTimeUpdate(int hours, int minutes, int seconds);
}

class Clock {
    private List<AlarmListener> listeners = new ArrayList<>();
    private int hours = 0;
    private int minutes = 0;
    private int seconds = 0;

    public Clock() {
        Thread clockThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    updateTime();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        clockThread.start();
    }

    public void addListener(AlarmListener listener) {
        listeners.add(listener);
    }

    private void updateTime() {
        seconds++;
        if (seconds == 60) {
            seconds = 0;
            minutes++;
            if (minutes == 60) {
                minutes = 0;
                hours++;
                if (hours == 24) {
                    hours = 0;
                }
            }
        }

        notifyListeners();
    }

    private void notifyListeners() {
        for (AlarmListener listener : listeners) {
            listener.onTimeUpdate(hours, minutes, seconds);
        }
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
}