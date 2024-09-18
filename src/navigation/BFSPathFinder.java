package navigation;

import java.util.*;
import settings.IMapSize;

public class BFSPathFinder implements IMapSize {
    private final boolean[][] visited;
    private final Coordinate[][] parent;

    public BFSPathFinder() {
        visited = new boolean[MAP_HEIGHT][MAP_WIDTH];
        parent = new Coordinate[MAP_HEIGHT][MAP_WIDTH];
    }

    public List<Coordinate> findPath(Coordinate start, Coordinate goal, boolean[][] obstacles) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.getRow()][start.getColumn()] = true;

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            if (current.equals(goal)) {
                return reconstructPath(start, goal);
            }

            for (MovementDirection direction : MovementDirection.values()) {
                Coordinate next = current.calculateNewCoordinate(direction);

                if (isValid(next) && !visited[next.getRow()][next.getColumn()] && !obstacles[next.getRow()][next.getColumn()]) {
                    queue.offer(next);
                    visited[next.getRow()][next.getColumn()] = true;
                    parent[next.getRow()][next.getColumn()] = current;
                }
            }
        }

        return null;
    }

    private boolean isValid(Coordinate coord) {
        return coord.getRow() >= 0 && coord.getRow() < MAP_HEIGHT &&
                coord.getColumn() >= 0 && coord.getColumn() < MAP_WIDTH;
    }

    private List<Coordinate> reconstructPath(Coordinate start, Coordinate goal) {
        List<Coordinate> path = new ArrayList<>();
        Coordinate current = goal;

        while (!current.equals(start)) {
            path.add(current);
            current = parent[current.getRow()][current.getColumn()];
        }

        path.add(start);
        Collections.reverse(path);

        return path;
    }
}
