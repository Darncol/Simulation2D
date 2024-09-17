package entities;

import navigation.Coordinate;
import navigation.MovementDirection;

import java.util.ArrayList;

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

    abstract boolean eateble(Entity food);

    public abstract void makeMove(ArrayList<Entity> entities, MovementDirection direction);

    public void takeDamage(int damage) {
        if (currentHealth > damage) {
            currentHealth -= damage;
        }
    }

    boolean isDead() {
        return currentHealth <= 0;
    }

    public boolean eat(Entity food) {
        boolean isEaten = false;

        if (eateble(food)) {
            restoreHealth();
            isEaten = true;
        }

        return isEaten;
    }

    void restoreHealth() {
        currentHealth = maxHealth;
    }
}
