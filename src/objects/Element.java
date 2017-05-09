package objects;

public enum Element {
    NONE("None"),
    NORMAL("Normal"),
    FIRE("Fire"),
    WATER("Water"),
    ELECTRIC("Electric"),
    GRASS("Grass"),
    BUG("Bug"),
    POISON("Poison"),
    ICE("Ice"),
    DRAGON("Dragon"),
    FAIRY("Fairy"),
    STEEL("Steel"),
    ROCK("Rock"),
    GROUND("Ground"),
    FIGHTING("Fighting"),
    FLYING("Flying"),
    PSYCHIC("Psychic"),
    DARK("Dark"),
    GHOST("Ghost");

    public final String name;

    Element(String name) { this.name = name; }
}
