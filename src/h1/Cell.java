package h1;

import java.util.List;


public class Cell {
    private int indexRow, indexCol;
    private boolean alive;
    private int numLivingNeighbors;
    private boolean isAliveNextGen;

    private static final List<Coord> NEIGHBORS =
            List.of(Coord.of(-1, -1), Coord.of(0, -1), Coord.of(1, -1),
                    Coord.of(-1, 0), Coord.of(1, 0),
                    Coord.of(-1, 1), Coord.of(0, 1), Coord.of(1, 1)
            );


    public Cell(int indexRow, int indexCol, boolean alive) {
        this.indexRow = indexRow;
        this.indexCol = indexCol;
        this.alive = alive;
    }

    public Cell(int indexRow, int indexCol) {
        this(indexRow, indexCol, false);
    }

    public void countLivingNeighbors(Cell[][] gridArray) {
        int living = 0;
        for (Coord neighborCoordinate : NEIGHBORS) {
            final int newX = indexRow + neighborCoordinate.row();
            final int newY = indexCol + neighborCoordinate.column();
            if (!Coord.of(newX, newY).isValid(gridArray)) continue;
            if (gridArray[newX][newY].isAlive()) living++;
        }
        setNumLivingNeighbors(living);
        decideNextStatus();
    }

    private void decideNextStatus() {
        if (isAlive()) { // Survive
            setAliveNextGen(numLivingNeighbors == 2 || numLivingNeighbors == 3);
            return;
        }
        setAliveNextGen(numLivingNeighbors == 3); // Birth

    }

    public int getIndexRow() {
        return indexRow;
    }

    public void setIndexRow(int indexRow) {
        this.indexRow = indexRow;
    }

    public int getIndexCol() {
        return indexCol;
    }

    public void setIndexCol(int indexCol) {
        this.indexCol = indexCol;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getNumLivingNeighbors() {
        return numLivingNeighbors;
    }

    public void setNumLivingNeighbors(int numLivingNeighbors) {
        this.numLivingNeighbors = numLivingNeighbors;
    }

    public boolean isAliveNextGen() {
        return isAliveNextGen;
    }

    public void setAliveNextGen(boolean aliveNextGen) {
        isAliveNextGen = aliveNextGen;
    }

    @Override
    public String toString() {
        return isAlive() ? "1" : "0";
    }
}
