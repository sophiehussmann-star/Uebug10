package h2;

import java.util.Map;

public record Coord(int row, int column) {
    public static final Map<Character, Coord> DIRECTIONS = Map.of(
            'U', Coord.of(-1, 0),
            'D', Coord.of(1, 0),
            'L', Coord.of(0, -1),
            'R', Coord.of(0, 1)
    );

    public static Coord of(int row, int column) {
        return new Coord(row, column);
    }

    public boolean isValid(Feld[][] brett) {
        if (brett == null) return false;
        final int maxRow = brett.length;
        if (brett.length == 0) return false;
        final int maxColumn = brett[0].length;

        if (row() < 0 || column() < 0)
            return false;

        if (row() >= maxRow || column() >= maxColumn)
            return false;

        return true;
    }
}
