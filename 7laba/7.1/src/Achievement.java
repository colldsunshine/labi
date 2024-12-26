public class Achievement {
    private String name;
    private boolean isUnlocked;

    public Achievement(String name) {
        this.name = name;
        this.isUnlocked = false;
    }

    public String getName() {
        return name;
    }

    public boolean isUnlocked() {
        return isUnlocked;
    }

    public void unlock() {
        this.isUnlocked = true;
    }
}