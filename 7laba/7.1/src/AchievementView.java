import java.util.List;

public class AchievementView {
    public void displayAchievements(List<Achievement> achievements) {
        System.out.println("Достижения:");
        for (Achievement achievement : achievements) {
            System.out.println(achievement.getName() + " - " + (achievement.isUnlocked() ? "Заблокировано" : "Разблокировано"));
        }
    }
}