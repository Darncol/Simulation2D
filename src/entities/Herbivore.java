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
    public void makeMove(ArrayList<Entity> entities, MovementDirection direction) {
        Coordinate newCoordinates = coordinates.calculateNewCoordinate(direction);
        Entity entity = getEntityByCoordinates(entities, newCoordinates);

        if (!checkCollision(entities, newCoordinates) || isEdible(entity)) {
            coordinates.changePosition(direction);

            if (eat(entity)) {
                entities.remove(entity);
            }
        }
    }
}
