public class Player {
    // true is red or X, false is blue or O may use for GUI later
    private boolean color;
    private char symbol;
    private String name;
    private Grid gameBoard;

    // Initialize and set char symbol for player
    Player(boolean color, String name) {
        this.color = color;
        this.name = name;

        if (color) {
            this.symbol = 'X';
        } else {
            this.symbol = 'O';
        }
    }

    // getters and setters for relevant variables
    public boolean getColor() {
        return this.color;
    }

    public String getName() {
        return this.name;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    // assign a specific game
    public void assignGameBoard(Grid grid) {
        gameBoard = grid;
    }

    //player takes their turn in desired colum
    public void takeTurn(Grid grid, int column) {
        grid.dropDisk(column, this);
    }

    // tostring override prints symbol of player
    public String toString() {
        return String.valueOf(this.symbol);
    }

}
