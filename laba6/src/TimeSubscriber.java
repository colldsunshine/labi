import java.util.ArrayList;
import java.util.List;

interface TimeObserver {
    void update(String time);
}

class Clock {
    private final List<TimeObserver> observers = new ArrayList<>();

    public void addObserver(TimeObserver observer) {
        observers.add(observer);
    }

    public void tick(String time) {
        for (TimeObserver observer : observers) {
            observer.update(time);
        }
    }
}

class TimeSubscriber implements TimeObserver {
    private final String name;

    public TimeSubscriber(String name) {
        this.name = name;
    }

    public void update(String time) {
        System.out.println(name + " уведомлен: " + time);
    }
}

