package Entities;

public abstract class Creature extends Entity {
    private int currentHealth;
    final int maxHealth;
    final int movementSpeed;

    public Creature(String name, int maxHealth, int movementSpeed) {
        super(name, true);
        this.movementSpeed = movementSpeed;
        this.currentHealth = maxHealth;
        this.maxHealth = maxHealth;
    }

    void takeDamage(int damage) {
        if (currentHealth > damage) {
            currentHealth -= damage;
        }
    }

    boolean isDead() {
        return currentHealth <= 0;
    }

    abstract boolean eat(Entity food);

    abstract void makeMove();

    protected final void restoreHealth() {
        currentHealth = maxHealth;
    }
}
