package h1;

public class H1_main {
    public static void main(String[] args) {
        Cell[] cellsAlive = {
                new Cell(0, 4),
                new Cell(1, 1),
                new Cell(2, 2),
                new Cell(2, 3),
                new Cell(3, 1),
                new Cell(3, 2),
        };
        Grid grid = new Grid(cellsAlive, 4, 5);
        System.out.println(grid);
        grid.computeNextGen();
        System.out.println("1\n" + grid);
        grid.computeGeneration(1);
        System.out.println("2\n" + grid);
        grid.computeGeneration(2);
        System.out.println("4\n" + grid);

    }
}