package Entities;

public abstract class Entity {
    final String name;
    final boolean isAlive;

    public Entity(String name, boolean isAlive) {
        this.name = name;
        this.isAlive = isAlive;
    }
}
