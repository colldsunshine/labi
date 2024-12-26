import java.util.List;

public class AchievementController {
    private List<Achievement> achievements;
    private AchievementView view;

    public AchievementController(List<Achievement> achievements, AchievementView view) {
        this.achievements = achievements;
        this.view = view;
    }

    public void unlockAchievement(String name) {
        for (Achievement achievement : achievements) {
            if (achievement.getName().equals(name)) {
                achievement.unlock();
                return;
            }
        }
        System.out.println("Достижение не найдено: " + name);
    }

    public void updateView() {
        view.displayAchievements(achievements);
    }
}