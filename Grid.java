public class Grid {

    private int rows = 6;
    private int columns = 7;

    private Disk[][] board = new Disk[rows][columns];

    Grid() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                board[row][col] = new Disk('_', row, col);
            }
        }
    }

    public Disk[][] getGrid() {
        return this.board;
    }

    public int lowestAvailableRow(int column) {
        for (int row = rows - 1; row >= 0; row--) {
            if (board[row][column].getSymbol() == '_') {
                return row;
            }
        }
        // return known out of bounds number to indicate row is full
        return 999;
    }

    public gameState checkGameState() {

        
        
        return gameState.noWinner;
    }

    public String toString() {
        String line = "";
        for (Disk[] row : board) {
            for (Disk col : row) {
                line += String.valueOf(col.getSymbol()) + " ";
            }
            line += "\n";
        }

        return line;
    }
}
