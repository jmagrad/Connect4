public class Grid {
    // define variables
    private int rows = 6;
    private int columns = 7;
    private Disk[][] board = new Disk[rows][columns];
    private int[] lastPiece = new int[2];
    GameState gamestate = GameState.noWinner;

    // constructor populates the gameboard with empty disks
    Grid() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                board[row][col] = new Disk('_', row, col);
            }
        }
    }

    // getter for the gameboard array
    public Disk[][] getGrid() {
        return this.board;
    }

    // checks for the lowest free space to put a player disk
    public int lowestAvailableRow(int column) {
        // check if column is out of bounds
        if (column >= columns) {
            return 999;
        }
        for (int row = rows - 1; row >= 0; row--) {
            if (board[row][column].getSymbol() == '_') {
                return row;
            }
        }
        // return known out of bounds number to indicate row is full
        return 999;
    }

    // place disk method sets assignes a disk to this player then checks if a win
    // condition has been met,
    // If no win condition has been met then see if the board is full with
    // checkgamestate
    public void dropDisk(int column, Player player) {
        int row = lowestAvailableRow(column);
        board[row][column].placDisk(this, player.getSymbol());
        if (getGrid()[row][column].checkNeighbors(this) && player.getColor()) {
            setGameState(GameState.Player1Wins);
            return;
        } else if (getGrid()[row][column].checkNeighbors(this) && !player.getColor()) {
            setGameState(GameState.Player2Wins);
            return;
        } else {
            checkGameState();
        }
    }

    // looks for empty spaces to see if the grid is full
    public void checkGameState() {

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (board[row][col].getSymbol() == '_') {
                    gamestate = GameState.noWinner;
                    return;
                }
            }
        }
        gamestate = GameState.Draw;
    }

    // override of to string method to print out the gameboard
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

    // getter and setter for the gamestate of the board
    public GameState getGameState() {
        return this.gamestate;
    }

    public void setGameState(GameState state) {
        this.gamestate = state;
    }

    // getter and setter for the last piece placed
    public void setLastPiece(int row, int col) {
        this.lastPiece[0] = row;
        this.lastPiece[1] = col;
    }

    public int[] getLastPiece() {
        return this.lastPiece;
    }

    // undo last turn
    public void undoLastTurn() {
        board[lastPiece[0]][lastPiece[1]].setSymbol('_');
    }
}
