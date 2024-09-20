package simulation;

import entities.*;
import initialization.StartUpInitializer;
import navigation.BFSPathFinder;
import navigation.Coordinate;
import navigation.MapRenderer;
import settings.IGameSpeed;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class World implements IGameSpeed {
    private ArrayList<Entity> entities = new ArrayList<>();
    private final MapRenderer gameMap = new MapRenderer();
    private final StartUpInitializer initializer = new StartUpInitializer();
    private final Random random = new Random();
    private boolean isRunning = true;

    public void start() {
        entities = initializer.populateMapWithEntities();
        gameMap.displayMap(entities);

        gameLoop();
    }

    private void gameLoop() {
        while (isRunning) {
            update();
            stopSimulationIfNoHerbivores();
        }
    }

    private void update() {
        ArrayList<Creature> creatures = getCreaturesList();
        Creature creature = getRandomCreature(creatures);
        handleCreatureMovement(creature);
    }

    private void handleCreatureMovement(Creature creature) {
        switch (creature) {
            case Predator predator -> {
                ArrayList<Coordinate> herbivores = collectHerbivores();
                performCreatureMovement(predator, herbivores);
            }

            case Herbivore herbivore -> {
                ArrayList<Coordinate> grass = collectGrass();
                performCreatureMovement(herbivore, grass);
            }

            default -> System.out.println("unknown creature " + creature);
        }
    }

    private void performCreatureMovement(Creature creature, ArrayList<Coordinate> goals) {
        BFSPathFinder pathFinder = new BFSPathFinder();
        List<Coordinate> path = pathFinder.findPath(creature.coordinates, goals, entities);

        if (path != null && !path.isEmpty()) {
            for (int i = 0; i < creature.movementSpeed; i++) {
                if (!path.isEmpty()) {
                    creature.makeMove(entities, path.removeFirst());
                    gameSleep();
                    gameMap.displayMap(entities);
                }
            }
        }
    }

    private void stopSimulationIfNoHerbivores() {
        if (collectHerbivores().isEmpty()) {
            isRunning = false;
            System.out.println("Simulation over!");
        }
    }

    private ArrayList<Coordinate> collectHerbivores() {
        return entities.stream()
                .filter(e -> e.getClass() == Herbivore.class)
                .map(e -> e.coordinates)
                .collect(Collectors.toCollection(ArrayList::new));

    }

    private ArrayList<Coordinate> collectGrass() {
        return entities.stream()
                .filter(e -> e.getClass() == StaticObject.class && e.isConsumable)
                .map(e -> e.coordinates)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private void gameSleep() {
        try {
            Thread.sleep(TIMER); // Пауза на 1 секунду
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    private Creature getRandomCreature(ArrayList<Creature> creatures) {
        int randomIndex = random.nextInt(creatures.size());
        return creatures.get(randomIndex);
    }

    private ArrayList<Creature> getCreaturesList() {
        return entities.stream()
                .filter(e -> e instanceof Creature)
                .map(e -> (Creature) e)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
