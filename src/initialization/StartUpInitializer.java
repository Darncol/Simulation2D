package initialization;

import entities.Entity;
import navigation.Coordinate;
import settings.IEntitiesCount;
import settings.IMapSize;

import java.util.ArrayList;
import java.util.Random;


/**
 * The StartUpInitializer class is responsible for setting up the initial state of the game world.
 * It populates the game map with various entities such as rabbits, wolves, stones, and grass.
 * This class utilizes the EntityFactory to create entities and assigns them random coordinates on the map.
 * It implements the IEntitiesCount and IMapSize interfaces to define the number of entities and the map dimensions.
 */
public class StartUpInitializer implements IEntitiesCount, IMapSize, IEntityKind {
    private final EntityFactory entityFactory;
    private final ArrayList<Entity> entities = new ArrayList<>();
    private final Random random = new Random();
    private final ArrayList<Coordinate> availableCoordinates = new ArrayList<>();

    public StartUpInitializer() {
        this.entityFactory = new EntityFactory();
    }

    public ArrayList<Entity> populateMapWithEntities() {
        generateAllAvailableCoordinates();
        generateEntities(RABBITS_COUNT, Kind.RABBIT);
        generateEntities(WOLFS_COUNT, Kind.WOLF);
        generateEntities(STONES_COUNT, Kind.STONE);
        generateEntities(GRASS_COUNT, Kind.GRASS);
        availableCoordinates.clear();
        return entities;
    }

    private void generateEntities(int count, Kind kind) {
        for (int i = 0; i < count; i++) {
            Coordinate randomCoordinate = availableCoordinates.remove(random.nextInt(availableCoordinates.size()));
            Entity entity = entityFactory.Create(kind, randomCoordinate);
            entities.add(entity);
        }
    }

    private void generateAllAvailableCoordinates() {
        for (int i = 0; i < MAP_HEIGHT; i++) {
            for (int j = 0; j < MAP_WIDTH; j++) {
                availableCoordinates.add(new Coordinate(i, j));
            }
        }
    }
}
