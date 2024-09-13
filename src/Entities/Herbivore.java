package Entities;

public class Herbivore extends Creature {

    public Herbivore(String name, int maxHP, int movementSpeed) {
        super(name, maxHP, movementSpeed);
    }

    @Override
    boolean eat(Entity food) {
        boolean isEaten = false;

        if (eateble(food)) {
            restoreHealth();
            isEaten = true;
        }

        return isEaten;
    }

    @Override
    void makeMove() {

    }

    boolean eateble(Entity food) {
        return food instanceof Grass;
    }
}
