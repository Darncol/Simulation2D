package initialization;

import entities.*;
import navigation.Coordinate;
import settings.IMapSymbols;

/**
 * The EntityFactory class is responsible for creating various types of entities
 * within the game world. It implements the IMapSymbols interface to utilize
 * predefined symbols for different entity types.
 */
public class EntityFactory implements IMapSymbols, IEntityKind {

    public Entity Create(Kind kind, Coordinate coordinates) {
        return switch (kind) {
            case RABBIT -> new Herbivore(RABBIT, 5, 3, coordinates.getRow(), coordinates.getColumn());
            case WOLF -> new Predator(WOLF, 10, 3, 2, coordinates.getRow(), coordinates.getColumn());
            case STONE -> new StaticObject(STONE, false, coordinates.getRow(), coordinates.getColumn());
            case GRASS -> new StaticObject(GRASS, true, coordinates.getRow(), coordinates.getColumn());
            default -> throw new IllegalArgumentException("Unknown entity kind: " + kind);
        };
    }
}
