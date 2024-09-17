import entities.Entity;
import entities.Herbivore;
import entities.Predator;
import entities.StaticObject;
import navigation.MapRenderer;
import navigation.MovementDirection;
import simulation.World;
import settings.EntityFactory;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        EntityFactory init = new EntityFactory();
        MapRenderer renderer = new MapRenderer();
        World map = new World();
        ArrayList<Entity> entities = new ArrayList<>();

        Herbivore rabbit1 = init.rabbit(1,1);
        Herbivore rabbit2 = init.rabbit(5,11);
        Herbivore rabbit3 = init.rabbit(0,1);
        StaticObject grass = init.grass(5,12);
        Predator wolf = init.wolf(0,0);
        StaticObject stone = init.stone(0,2);


        entities.add(rabbit1);
        entities.add(rabbit2);
        entities.add(rabbit3);
        entities.add(grass);
        entities.add(wolf);
        entities.add(stone);

        renderer.displayMap(entities);
        System.out.println();

        rabbit1.makeMove(entities, MovementDirection.UP);
        rabbit2.makeMove(entities, MovementDirection.RIGHT);
        wolf.makeMove(entities, MovementDirection.RIGHT);
        renderer.displayMap(entities);
        System.out.println();

        wolf.makeMove(entities, MovementDirection.RIGHT);
        rabbit1.makeMove(entities, MovementDirection.RIGHT);
        rabbit2.makeMove(entities, MovementDirection.UP);
        renderer.displayMap(entities);

        System.out.println();
        wolf.makeMove(entities, MovementDirection.RIGHT);
        renderer.displayMap(entities);
    }
}