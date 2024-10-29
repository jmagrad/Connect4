public class Disk {
    private char symbol;
    private int[] position;
    private int streakSize;

    Disk(char symbol, int row, int column) {
        this.symbol = symbol;

        this.position = new int[2];
        this.position[0] = row;
        this.position[1] = column;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public void placDisk(Grid gameBoard, char symbol) {
        setSymbol(symbol);
        checkNeighbors(gameBoard);
        streakSize = 1;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int[] getPosition() {
        return this.position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public String toString() {
        return String.valueOf(symbol);
    }

    public void checkNeighbors(Grid gameBoard) {

        int vertCount = 0;
        int horzCount = 0;
        int posAngleCount = 0;
        int negAngleCount = 0;

        // check vertical
        gameBoard.getDisk(position[0] + 1, position[1]).getSymbol();
        gameBoard.getDisk(position[0] - 1, position[1]).getSymbol();

        // check horizontal
        gameBoard.getDisk(position[0], position[1] - 1);
        gameBoard.getDisk(position[0], position[1] + 1);

        // check positive angle
        gameBoard.getDisk(position[0] + 1, position[1] + 1);
        gameBoard.getGrid()[position[0] - 1][position[1] - 1].getSymbol();

        // check negative angle
        gameBoard.getGrid()[position[0] - 1][position[1] + 1].getSymbol();
        gameBoard.getGrid()[position[0] + 1][position[1] - 1].getSymbol();

    }

    private int checkNext(Grid gameBoard, int[] nextPosition, int count, char symbol) {
        if(gameBoard.getDisk(nextPosition[0], nextPosition[1]).getSymbol()==symbol)
        {
            count++;
            checkNext(gameBoard, nextPosition, count, symbol)
        }else{

        }
        return count;
    }
}
