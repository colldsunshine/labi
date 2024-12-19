public class Main {
    public static void main(String[] args) {
        // 1 синглтон
        AchievementTracker tracker = AchievementTracker.getInstance();
        tracker.addAchievement("ХЭДШОТ");
        tracker.addAchievement("ХЭДШОТ 2.0");
        System.out.println(tracker.getAchievements());

        // 2 смотря какой фэбрик
        SpellFactory spellFactory = new SpellFactory();
        Spell fire = spellFactory.createSpell("Огонь");
        fire.cast();
        Spell ice = spellFactory.createSpell("Лед");
        ice.cast();

        // 3 наблюдатель
        Clock clock = new Clock();
        clock.addObserver(new TimeSubscriber("Наблюдатель 1"));
        clock.addObserver(new TimeSubscriber("Наблюдатель 2"));

        clock.tick("12:00");
        clock.tick("12:01");

        // 4 команда
        Tower tower = new Tower();

        Command activateTurrets = new ActivateTurrets(tower);
        Command deployShield = new DeployShield(tower);

        TowerController controller = new TowerController();

        controller.setCommand(activateTurrets);
        controller.pressButton();

        controller.setCommand(deployShield);
        controller.pressButton();

        // 5 летающий вес (приспособленец)
        NPCFactory npcFactory = new NPCFactory();

        NPC elf = npcFactory.getNPC("Эльф");
        elf.setPosition(10, 20);

        NPC vampire = npcFactory.getNPC("Вампир");
        vampire.setPosition(30, 40);

        NPC human = npcFactory.getNPC("Человек");
        human.setPosition(50, 60);
    }
}