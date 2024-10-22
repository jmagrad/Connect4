public class Grid {

    private int rows = 7;
    private int columns = 7;

    private Disk[][] board = new Disk[rows][columns];

    Grid() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                board[row][col] = new Disk('_', row, col);
            }
        }
    }

    public int checkGameState() {
        return 0;
    }

    public Disk[][] getGrid() {
        return this.board;
    }

    public int lowestAvailableRow(int column) {
        for (int row = 0; row < board[0].length; row++) {
            if (board[row][column].getSymbol() == '_') {
                return row;
            }
        }
        // return known out of bounds number to indicate row is full
        return 999;
    }

    public String toString() {
        String line = "";
        for (Disk[] row : board) {
            for (Disk col : row) {
                line = String.valueOf(col.getSymbol()) + " ";
            }
            line += "/n";
        }

        return line;
    }
}
