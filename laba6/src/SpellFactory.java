interface Spell {
    void cast();
}

class FireSpell implements Spell {
    public void cast() {
        System.out.println("Наложено заклинание огня");
    }
}

class IceSpell implements Spell {
    public void cast() {
        System.out.println("Наложено заклинание льда");
    }
}

class SpellFactory {
    public Spell createSpell(String type) {
        if (type.equalsIgnoreCase("Огонь")) {
            return new FireSpell();
        } else if (type.equalsIgnoreCase("Лед")) {
            return new IceSpell();
        }
        return null;
    }
}
