package settings;

import entities.Herbivore;
import entities.Predator;

public class Intializer {
    public Predator wolf(int row, int col) {
        return new Predator("w", 10, 3, 2, row, col);
    }

    public Herbivore rabbit(int row, int col) {
        return new Herbivore("r", 5, 3, row, col);
    }
}
