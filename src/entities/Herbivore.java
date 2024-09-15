package entities;

public class Herbivore extends Creature {

    public Herbivore(String name, int maxHP, int movementSpeed, int row, int col) {
        super(name, maxHP, movementSpeed, row, col);
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
        return food.isConsumable;
    }
}
