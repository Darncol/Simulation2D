package entities;

import navigation.Coordinate;
import navigation.MovementDirection;

import java.util.ArrayList;

public class Herbivore extends Creature {

    public Herbivore(String name, int maxHP, int movementSpeed, int row, int col) {
        super(name, maxHP, movementSpeed, row, col);
    }

    boolean isEdible(Entity food) {
        return food instanceof StaticObject && food.isConsumable;
    }

    @Override
    void interactWithEntity(Entity entity) {

    }
}
