package Entities;

public class Predator extends Creature {
    private final int damage;

    public Predator(String name, int maxHP, int damage, int movementSpeed) {
        super(name, maxHP, movementSpeed);
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
