package entities;

public class Predator extends Creature {
    private final int damage;

    public Predator(String name, int maxHP, int damage, int movementSpeed, int row, int col) {
        super(name, maxHP, movementSpeed, row, col);
        this.damage = damage;
    }

    int attack() {
        return damage;
    }

    @Override
    void makeMove() {

    }

    boolean eateble(Entity food) {
        return food instanceof Herbivore herbivore && herbivore.isDead();
    }
}
