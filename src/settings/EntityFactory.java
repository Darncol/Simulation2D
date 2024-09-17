package settings;

import entities.Herbivore;
import entities.Predator;
import entities.StaticObject;

public class EntityFactory {
    public Predator wolf(int row, int col) {
        return new Predator("w", 10, 3, 2, row, col);
    }

    public Herbivore rabbit(int row, int col) {
        return new Herbivore("r", 5, 3, row, col);
    }

    public StaticObject stone(int row, int col) {
        return new StaticObject("s", false, row, col);
    }

    public StaticObject grass(int row, int col) {
        return new StaticObject("g", true, row, col);
    }
}
