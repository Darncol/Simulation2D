package Entities;

public class Predator extends Creature{
    private final int damage;

    public Predator(String name, int maxHP, int damage, int movementSpeed) {
        super(name, maxHP, movementSpeed);
        this.damage = damage;
    }

    int attack(){
        return damage;
    }

    @Override
    boolean eat(Entity food) {
        boolean isEaten = false;

        if(isEateble(food)){
            restoreHealth();
            isEaten = true;
        }

        return isEaten;
    }

    @Override
    void makeMove() {

    }

    private boolean isEateble(Entity food){
        return food.isAlive;
    }
}
