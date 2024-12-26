import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Achievement> achievements = new ArrayList<>();
        achievements.add(new Achievement("First blood"));
        achievements.add(new Achievement("Хэдшот"));
        achievements.add(new Achievement("Шахтер"));

        AchievementView view = new AchievementView();
        AchievementController controller = new AchievementController(achievements, view);

        controller.updateView();

        controller.unlockAchievement("Хэдшот");
        controller.unlockAchievement("First blood");

        controller.updateView();
    }
}