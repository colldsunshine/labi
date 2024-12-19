import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class AchievementTracker {
    private static AchievementTracker instance;
    private final List<String> achievements = new ArrayList<>();

    private AchievementTracker() {}

    public static AchievementTracker getInstance() {
        if (instance == null) {
            instance = new AchievementTracker();
        }
        return instance;
    }

    public void addAchievement(String achievement) {
        achievements.add(achievement);
        try (FileWriter writer = new FileWriter("achievements.txt", true)) {
            writer.write(achievement + "\n");
        } catch (IOException e) {
            System.out.println("Одна ошибка и ты ошибся. Файл не создан.");
        }
    }

    public List<String> getAchievements() {
        return achievements;
    }
}