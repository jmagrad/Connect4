public class Player {
    // true is red or X, false is blue or O
    private boolean color;
    private char symbol;

    Player(boolean color) {
        this.color = color;

        if (color) {
            this.symbol = 'X';
        } else {
            this.symbol = 'O';
        }
    }

    public void placeDisk(Grid gameBoard, int column) {
        int row = gameBoard.lowestAvailableRow(column);
        gameBoard.getGrid()[row][column].setSymbol(this.symbol);
    }

    public boolean getColor() {
        return this.color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public String toString() {
        return String.valueOf(this.symbol);
    }

}
