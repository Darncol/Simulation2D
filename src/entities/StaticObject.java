package entities;

/**
 * The StaticObject class represents static entities within the game world.
 * These entities are characterized by their immobility and can be either consumable or non-consumable.
 */
public class StaticObject extends Entity {
    public StaticObject(String name, boolean isConsumable, int row, int col) {
        super(name, isConsumable, row, col);
    }
}
