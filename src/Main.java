import entities.Entity;
import entities.Herbivore;
import entities.StaticObject;
import navigation.MapRenderer;
import navigation.MovementDirection;
import simulation.World;
import settings.InitEntity;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        InitEntity init = new InitEntity();
        MapRenderer renderer = new MapRenderer();
        World map = new World();
        ArrayList<Entity> entities = new ArrayList<>();

        Herbivore rabbit1 = init.rabbit(1,1);
        Herbivore rabbit2 = init.rabbit(5,11);
        StaticObject grass = init.grass(5,12);
        entities.add(rabbit1);
        entities.add(rabbit2);
        entities.add(grass);

        renderer.displayMap(entities);
        System.out.println();

        rabbit1.makeMove(entities, MovementDirection.UP);
        rabbit2.makeMove(entities, MovementDirection.RIGHT);
        renderer.displayMap(entities);
        System.out.println();

        rabbit1.makeMove(entities, MovementDirection.UP);
        rabbit2.makeMove(entities, MovementDirection.UP);
        renderer.displayMap(entities);
    }
}