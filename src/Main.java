import entities.Entity;
import entities.Herbivore;
import entities.Predator;
import entities.StaticObject;
import navigation.BFSPathFinder;
import navigation.Coordinate;
import navigation.MapRenderer;
import navigation.MovementDirection;
import simulation.World;
import settings.EntityFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityFactory init = new EntityFactory();
        MapRenderer renderer = new MapRenderer();
        World map = new World();
        ArrayList<Entity> entities = new ArrayList<>();

        Herbivore rabbit1 = init.rabbit(5, 7);
        Herbivore rabbit2 = init.rabbit(5, 11);
        Herbivore rabbit3 = init.rabbit(0, 1);
        StaticObject grass = init.grass(5, 12);
        Predator wolf = init.wolf(3, 6);
        StaticObject stone = init.stone(0, 2);

        entities.add(rabbit1);
        entities.add(rabbit2);
        entities.add(rabbit3);
        entities.add(grass);
        entities.add(wolf);
        entities.add(stone);

        renderer.displayMap(entities);
        System.out.println();

        BFSPathFinder bfs = new BFSPathFinder();

        List<Coordinate> goals = new ArrayList<>();
        goals.add(rabbit2.coordinates);
        goals.add(rabbit1.coordinates);
        goals.add(rabbit1.coordinates);

        List<Coordinate> path = bfs.findPath(wolf.coordinates, goals, entities);

        for (Coordinate coordinate : path) {
            System.out.println(coordinate.getRow() + " " + coordinate.getColumn());
        }
    }
}