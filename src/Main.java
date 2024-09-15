import entities.Predator;
import navigation.GameMap;

public class Main {
    public static void main(String[] args) {
        Intializer init = new Intializer();
        GameMap map = new GameMap();
        map.addEntity(init.rabbit(1,1));
        map.addEntity(init.wolf(2,2));
        map.displayMap();

    }
}