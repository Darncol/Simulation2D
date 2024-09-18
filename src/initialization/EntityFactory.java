package initialization;

import entities.Entity;
import entities.Herbivore;
import entities.Predator;
import entities.StaticObject;
import navigation.Coordinate;
import settings.IMapSymbols;

public class EntityFactory implements IMapSymbols{

    enum EntityType {
        RABBIT,
        WOLF,
        STONE,
        GRASS
    }

    public Entity Create(EntityType type, Coordinate coordinates) {
        return switch (type) {
            case RABBIT -> new Herbivore(RABBIT, 5, 3, coordinates.getRow(), coordinates.getColumn());
            case WOLF -> new Predator(WOLF, 10, 3, 2, coordinates.getRow(), coordinates.getColumn());
            case STONE -> new StaticObject(STONE, false, coordinates.getRow(), coordinates.getColumn());
            case GRASS -> new StaticObject(GRASS, true, coordinates.getRow(), coordinates.getColumn());
            default -> throw new IllegalArgumentException("Unknown entity type: " + type);
        };
    }
}
