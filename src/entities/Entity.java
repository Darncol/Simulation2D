package entities;

import navigation.Coordinate;

public abstract class Entity {
    final String name;
    final boolean isConsumable;

    Coordinate coordinates;

    public Entity(String name, boolean isConsumable, int row, int col) {
        this.name = name;
        this.isConsumable = isConsumable;
        this.coordinates = new Coordinate(row, col);
    }
}
