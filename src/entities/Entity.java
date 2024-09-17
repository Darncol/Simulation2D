package entities;

import navigation.Coordinate;

public abstract class Entity {
    public final String name;
    public final boolean isConsumable;

    public Coordinate coordinates;

    public Entity(String name, boolean isConsumable, int row, int col) {
        this.name = name;
        this.isConsumable = isConsumable;
        this.coordinates = new Coordinate(row, col);
    }
}
