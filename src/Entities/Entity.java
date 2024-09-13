package Entities;

public abstract class Entity {
    final String name;
    final boolean isConsumable;

    public Entity(String name, boolean isConsumable) {
        this.name = name;
        this.isConsumable = isConsumable;
    }
}
