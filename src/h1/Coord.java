package h1;

public record Coord(int row, int column) {
    public static Coord of(int row, int column) {
        return new Coord(row, column);
    }

    public boolean isValid(Cell[][] gridArray) {
        if (gridArray == null) return false;
        final int maxRow = gridArray.length;
        if (gridArray.length == 0) return false;
        final int maxColumn = gridArray[0].length;

        if (row() < 0 || column() < 0)
            return false;

        if (row() >= maxRow || column() >= maxColumn)
            return false;

        return true;
    }
}