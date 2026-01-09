package h1;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Grid {
    private Cell[][] gridArray;

    public Grid(Cell[] cells, int gridRows, int gridCols) {
        gridArray = new Cell[gridRows][gridCols];
        setAllCellsDead();
        setLivingCells(cells);
        calculateCellAttributes();
    }

    private void setAllCellsDead() {
        iterateOverCells((x, y) -> {
            gridArray[x][y]
                    = new Cell(x, y, false);
        });
    }

    private void setLivingCells(Cell[] cells) {
        for (Cell dummyCell : cells) {
            Coord cellCord = Coord.of(dummyCell.getIndexRow(), dummyCell.getIndexCol());
            if (!cellCord.isValid(gridArray)) continue;
            Cell cell = gridArray[cellCord.row()][cellCord.column()];
            cell.setAlive(true);
        }
    }

    private void calculateCellAttributes() {
        iterateOverCells(cell -> {
            cell.countLivingNeighbors(gridArray);
        });
    }

    public void computeNextGen() {
        iterateOverCells(cell -> {
            cell.setAlive(cell.isAliveNextGen());
        });
        calculateCellAttributes();
    }

    public void computeGeneration(int n) {
        while (n >= 1) {
            computeNextGen();
            n--;
        }
    }

    private void iterateOverCells(Consumer<Cell> consumer) {
        for (Cell[] cells : gridArray) {
            for (Cell cell : cells) {
                consumer.accept(cell);
            }
        }
    }

    private void iterateOverCells(BiConsumer<Integer, Integer> biConsumer) {
        for (int x = 0; x < gridArray.length; x++) {
            for (int y = 0; y < gridArray[x].length; y++) {
                biConsumer.accept(x, y);
            }
        }
    }

    public Cell[][] getGridArray() {
        return gridArray;
    }

    public void setGridArray(Cell[][] gridArray) {
        this.gridArray = gridArray;
    }

    @Override
    public String toString() {
        if (gridArray == null || gridArray.length == 0) return "Leeres Grid";
        StringBuilder sb = new StringBuilder();
        for (Cell[] cells : gridArray) {
            for (Cell cell : cells) {
                sb.append(cell).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}