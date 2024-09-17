package entities;

import navigation.Coordinate;
import navigation.MovementDirection;

import java.util.ArrayList;

/**
 * The Creature class represents an abstract entity with health and movement capabilities within the game.
 * Creatures can move, take damage, restore health, and interact with other entities.
 * The isEdible method needs to manage what food can be eaten.
 */
public abstract class Creature extends Entity {
    private int currentHealth;
    final int maxHealth;
    final int movementSpeed;

    public Creature(String name, int maxHealth, int movementSpeed, int row, int col) {
        super(name, true, row, col);
        this.movementSpeed = movementSpeed;
        this.currentHealth = maxHealth;
        this.maxHealth = maxHealth;
    }

    abstract boolean isEdible(Entity food);

    public abstract void makeMove(ArrayList<Entity> entities, MovementDirection direction);

    public void takeDamage(int damage) {
        if (currentHealth > 0) {
            currentHealth -= damage;
        }
    }

    boolean isDead() {
        return currentHealth <= 0;
    }

    public boolean eat(Entity food) {
        boolean isEaten = false;

        if (isEdible(food)) {
            restoreHealth();
            isEaten = true;
        }

        return isEaten;
    }

    void restoreHealth() {
        currentHealth = maxHealth;
    }

    boolean hasCollision(ArrayList<Entity> entities, Coordinate newCoordinates) {
        return entities.stream().anyMatch(entity -> entity.coordinates.equals(newCoordinates));
    }

    Entity getEntityByCoordinates(ArrayList<Entity> entities, Coordinate newCoordinates) {
        return entities.stream().filter(entity -> entity.coordinates.equals(newCoordinates)).findFirst().orElse(null);
    }
}
