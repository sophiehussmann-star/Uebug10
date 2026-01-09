package h2;

public class Spielstein {

    private int currentRow, currentCol;
    private Spielbrett brett;

    public Spielstein(Spielbrett brett, int indexRow, int indexCol) {
        currentRow = indexRow;
        currentCol = indexCol;
        this.brett = brett;
    }

    private Coord determineNextFeld() {
        Coord modifier = Coord.DIRECTIONS.get(getCurrentFeld().getDirection());
        return Coord.of(currentRow + modifier.row(), currentCol + modifier.column());
    }

    private boolean movesOut() {
        return !determineNextFeld().isValid(getBrett().getBrett());
    }

    public void go(int n) {
        while (n >= 1) {
            n--;
            Feld currentFeld = getCurrentFeld();
            if (movesOut()) continue;
            if (!currentFeld.isBoese()) {
                Coord nextFeldCoord = determineNextFeld();
                currentRow = nextFeldCoord.row();
                currentCol = nextFeldCoord.column();
            }
        }
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public int getCurrentCol() {
        return currentCol;
    }

    public void setCurrentCol(int currentCol) {
        this.currentCol = currentCol;
    }

    public Spielbrett getBrett() {
        return brett;
    }

    public void setBrett(Spielbrett brett) {
        this.brett = brett;
    }

    private Feld getCurrentFeld() {
        return getBrett().getBrett()[currentRow][currentCol];
    }
}
