package initialization;

import entities.Entity;
import navigation.Coordinate;
import settings.IEntitiesCount;
import settings.IMapSize;

import java.util.ArrayList;
import java.util.Random;


public class StartUpInitializer implements IEntitiesCount, IMapSize {
    private final EntityFactory entityFactory;
    private final ArrayList<Entity> entities = new ArrayList<>();
    private final Random random = new Random();
    private final ArrayList<Coordinate> availableCoordinates = new ArrayList<>();

    public StartUpInitializer() {
        this.entityFactory = new EntityFactory();
    }

    public ArrayList<Entity> initialize() {
        generateAllAvailableCoordinates();
        generateEntities(RABBITS_COUNT, EntityFactory.EntityType.RABBIT);
        generateEntities(WOLFS_COUNT, EntityFactory.EntityType.WOLF);
        generateEntities(STONES_COUNT, EntityFactory.EntityType.STONE);
        generateEntities(GRASS_COUNT, EntityFactory.EntityType.GRASS);
        availableCoordinates.clear();
        return entities;
    }

    private void generateEntities(int count, EntityFactory.EntityType type) {
        for (int i = 0; i < count; i++) {
            Coordinate randomCoordinate = availableCoordinates.remove(random.nextInt(availableCoordinates.size()));
            Entity entity = entityFactory.Create(type, randomCoordinate);
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
