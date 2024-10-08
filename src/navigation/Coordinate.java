package navigation;

import settings.IMapSize;

import java.util.Arrays;
import java.util.Objects;

/**
 * The Coordinate class represents a position on a 2D grid map. It provides methods
 * for retrieving coordinates, calculating new coordinates based on movement directions,
 * and changing the current position either by specific directions or by another coordinate.
 * The class implements the IMapSize interface for map size constraints.
 */
public class Coordinate implements IMapSize {
    private int row;
    private int column;


    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Coordinate calculateNewCoordinate(MovementDirection direction) {
        int newRow = row;
        int newColumn = column;

        switch (direction) {
            case UP:
                if (row > 0) {
                    newRow = row - 1;
                }
                break;
            case DOWN:
                if (row < MAP_HEIGHT) {
                    newRow = row + 1;
                }
                break;
            case LEFT:
                if (column > 0) {
                    newColumn = column - 1;
                }
                break;
            case RIGHT:
                if (column < MAP_WIDTH) {
                    newColumn = column + 1;
                }
                break;
        }

        return new Coordinate(newRow, newColumn);
    }

    public void changePosition(Coordinate toCoordinate) {
        if (isInMapRange(toCoordinate) && isInNeighbourhood(toCoordinate)) {
            row = toCoordinate.getRow();
            column = toCoordinate.getColumn();
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Coordinate that = (Coordinate) object;

        return row == that.row && column == that.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    private boolean isInMapRange(Coordinate coordinate) {
        return coordinate.getRow() >= 0 && coordinate.getRow() < MAP_HEIGHT &&
                coordinate.getColumn() >= 0 && coordinate.getColumn() < MAP_WIDTH;
    }

    private boolean isInNeighbourhood(Coordinate coordinate) {
        Coordinate[] neighbourhood = new Coordinate[4];

        neighbourhood[0] = calculateNewCoordinate(MovementDirection.UP);
        neighbourhood[1] = calculateNewCoordinate(MovementDirection.DOWN);
        neighbourhood[2] = calculateNewCoordinate(MovementDirection.LEFT);
        neighbourhood[3] = calculateNewCoordinate(MovementDirection.RIGHT);

        return Arrays.asList(neighbourhood).contains(coordinate);
    }
}
