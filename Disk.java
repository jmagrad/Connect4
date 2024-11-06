public class Disk {
    // class variables
    private char symbol;
    private int[] position;

    // constructor takes a symbol character and its position in the grid
    Disk(char symbol, int row, int column) {
        this.symbol = symbol;

        this.position = new int[2];
        this.position[0] = row;
        this.position[1] = column;
    }

    // getter for the disk's assigned symbol
    public char getSymbol() {
        return this.symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    // getter and setter for position
    public int[] getPosition() {
        return this.position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public String toString() {
        return String.valueOf(symbol);
    }

    // assign a given symbe and use check neighbors for a win condition
    public void placDisk(Grid gameBoard, char symbol) {
        setSymbol(symbol);
        // let gameboard know that this is the most recently placed disk
        gameBoard.setLastPiece(position[0], position[1]);
    }

    // checks all 4 vectors for a string of like symbols totaling 4 or greater
    public boolean checkNeighbors(Grid gameBoard) {
        // if this is called on an empty space return
        if (symbol == '_') {
            return false;
        }
        // possible directions to connnect
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 1, 1 }, { 1, -1 } };

        // loop through and call check direction being sure to check the opposite way
        // too for the total
        for (int[] direction : directions) {
            if (checkDirection(gameBoard.getGrid(), direction[0], direction[1]) +
                    checkDirection(gameBoard.getGrid(), -direction[0], -direction[1]) - 1 >= 4) {
                return true;
            }
        }
        // no win condition found, return false
        return false;
    }

    // takes a given direction and its gameboard and counts how many matching
    // symbols exist on that vector
    private int checkDirection(Disk[][] grid, int rowDir, int colDir) {
        int count = 0;
        int row = position[0];
        int col = position[1];
        // continue along a vector until you are out of bounds or ecounter a symbol that
        // does not match this disk
        // count matching disks along the way and return count
        while (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length
                && grid[row][col].symbol == symbol) {
            count++;
            row += rowDir;
            col += colDir;
        }

        return count;
    }
}
