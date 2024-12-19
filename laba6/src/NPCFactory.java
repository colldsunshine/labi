import java.util.HashMap;
import java.util.Map;

class NPC {
    private final String model;

    public NPC(String model) {
        this.model = model;
    }

    public void setPosition(int x, int y) {
        System.out.println(model + " расположен на (" + x + ", " + y + ")");
    }
}

class NPCFactory {
    private Map<String, NPC> pool = new HashMap<>();

    public NPC getNPC(String model) {
        if (!pool.containsKey(model)) {
            pool.put(model, new NPC(model));
            System.out.println("Создан новый NPC: " + model);
        }
        return pool.get(model);
    }
}
