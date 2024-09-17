package entities;

import navigation.Coordinate;
import navigation.MovementDirection;

import java.util.ArrayList;

public class Herbivore extends Creature {

    public Herbivore(String name, int maxHP, int movementSpeed, int row, int col) {
        super(name, maxHP, movementSpeed, row, col);
    }

    boolean eateble(Entity food) {
        return food.isConsumable;
    }

    @Override
    public void makeMove(ArrayList<Entity> entities, MovementDirection direction) {
        Coordinate newCoordinates = coordinates.calculateNewCoordinate(direction);
        Entity entity = getEntityByCoordinates(entities, newCoordinates);

        if (!checkCollision(entities, newCoordinates) || checkIsEatableEntity(entity)) {
            coordinates.changePosition(direction);

            if (checkIsEatableEntity(entity)) {
                eat(entity);
                entities.remove(entity);
            }
        }
    }

    private boolean checkCollision(ArrayList<Entity> entities, Coordinate newCoordinates) {
        return entities.stream().anyMatch(entity -> entity.coordinates.equals(newCoordinates));
    }

    private Entity getEntityByCoordinates(ArrayList<Entity> entities, Coordinate newCoordinates) {
        return entities.stream().filter(entity -> entity.coordinates.equals(newCoordinates)).findFirst().orElse(null);
    }

    private boolean checkIsEatableEntity(Entity entity) {
        return entity instanceof StaticObject && entity.isConsumable;
    }
}
