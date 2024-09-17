package entities;

import navigation.Coordinate;
import navigation.MovementDirection;

import java.util.ArrayList;

public class Predator extends Creature {
    private final int damage;

    public Predator(String name, int maxHP, int damage, int movementSpeed, int row, int col) {
        super(name, maxHP, movementSpeed, row, col);
        this.damage = damage;
    }

    int calculateDamage() {
        return damage;
    }

    boolean isEdible(Entity food) {
        return food instanceof Herbivore herbivore && herbivore.isDead();
    }

    void interactWithEntity(Entity entity) {
        if (entity instanceof Herbivore herbivore && !herbivore.isDead()) {
            herbivore.takeDamage(calculateDamage());
        }
    }
}
