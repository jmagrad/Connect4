public class Grid {

    private int rows = 7;
    private int columns = 7;

    private Disk[][] board = new Disk[rows][columns];

    Grid() {

    }

    public int checkGameState() {
        return 0;
    }

    public Disk[][] getGrid() {
        return this.board;
    }
}
