package navigation;

import entities.Entity;
import settings.IMapSize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GameMapRenderer implements IMapSize {
    private Map<Coordinate, Entity> entityLocations = new HashMap<>();

    public void displayMap() {
        String[][] map = createMap();
        setEntitesOnMap(map);
        renderMap(map);
        entityLocations.clear();
    }

    public void addEntites(ArrayList<Entity> entities) {
        for (Entity entity : entities) {
            entityLocations.put(entity.coordinates, entity);
        }
    }

    private String[][] createMap() {
        String[][] map = new String[MAP_HEIGHT][MAP_WIDTH];

        for (int col = 0; col < MAP_HEIGHT; col++) {
            for (int row = 0; row < MAP_WIDTH; row++) {
                map[col][row] = ".";
            }
        }

        return map;
    }

    private void setEntitesOnMap(String[][] map) {
        for (int col = 0; col < MAP_HEIGHT; col++) {
            for (int row = 0; row < MAP_WIDTH; row++) {
                Coordinate coordinate = new Coordinate(col, row);

                if (entityLocations.containsKey(coordinate)) {
                    map[col][row] = entityLocations.get(coordinate).name;
                }
            }
        }
    }

    private void renderMap(String[][] map) {
        for (int col = 0; col < MAP_HEIGHT; col++) {
            for (int row = 0; row < MAP_WIDTH; row++) {
                System.out.print(map[col][row]);
            }
            System.out.println();
        }
    }
}
