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
        // Запускаем поток, который обновляет время каждую секунду
        Thread clockThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);  // Пауза 1 секунда
                    updateTime();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        clockThread.start();
    }

    // Добавление наблюдателя
    public void addListener(AlarmListener listener) {
        listeners.add(listener);
    }

    // Обновление времени и уведомление наблюдателей
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

        // Уведомление всех наблюдателей
        notifyListeners();
    }

    // Уведомление наблюдателей
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