package navigation;

import settings.IMapSize;

import java.util.Objects;

public class Coordinate implements IMapSize {
    private int row;
    private int column;


    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
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

    public void changePosition(MovementDirection direction) {
        switch (direction) {
            case UP:
                if (row > 0) {
                    row--;
                }
                break;
            case DOWN:
                if (row < MAP_HEIGHT) {
                    row++;
                }
                break;
            case LEFT:
                if (column > 0) {
                    column--;
                }
                break;
            case RIGHT:
                if (column < MAP_WIDTH) {
                    column++;
                }
                break;
        }
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
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
}
