package navigation;

import entities.Entity;

import java.util.HashMap;
import java.util.Map;

public class GameMap {
    private Map<Coordinate, Entity> entityLocations = new HashMap<>();
    private final int mapWidth = 30;
    private final int mapHeight = 10;

    public void displayMap() {
        String[][] map = createMap();
        setEntitesOnMap(map);
        renderMap(map);
    }

    public void addEntity(Entity entity) {
        entityLocations.put(entity.coordinates, entity);
    }

    private String[][] createMap() {
        String[][] map = new String[mapHeight][mapWidth];

        for (int col = 0; col < mapHeight; col++) {
            for (int row = 0; row < mapWidth; row++) {
                map[col][row] = ".";
            }
        }

        return map;
    }

    private void setEntitesOnMap(String[][] map) {
        for (int col = 0; col < mapHeight; col++) {
            for (int row = 0; row < mapWidth; row++) {
                Coordinate coordinate = new Coordinate(col, row);

                if (entityLocations.containsKey(coordinate)) {
                    map[col][row] = entityLocations.get(coordinate).name;
                }
            }
        }
    }

    private void renderMap(String[][] map) {
        for (int col = 0; col < mapHeight; col++) {
            for (int row = 0; row < mapWidth; row++) {
                System.out.print(map[col][row]);
            }
            System.out.println();
        }
    }
}
