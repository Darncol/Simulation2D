package navigation;

import java.util.Objects;

public class Coordinate {
    private int row;
    private int column;

    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    void changePosition(movementDirection direction) {
        switch (direction) {
            case UP:
                column++;
                break;
            case DOWN:
                column--;
                break;
            case LEFT:
                row--;
                break;
            case RIGHT:
                row++;
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
