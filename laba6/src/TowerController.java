interface Command {
    void execute();
}

class Tower {
    public void activateTurrets() {
        System.out.println("Башни активированы");
    }

    public void deployShield() {
        System.out.println("Щиты развернуты!");
    }
}

class ActivateTurrets implements Command {
    private final Tower tower;

    public ActivateTurrets(Tower tower) {
        this.tower = tower;
    }

    public void execute() {
        tower.activateTurrets();
    }
}

class DeployShield implements Command {
    private final Tower tower;

    public DeployShield(Tower tower) {
        this.tower = tower;
    }

    public void execute() {
        tower.deployShield();
    }
}

class TowerController {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

