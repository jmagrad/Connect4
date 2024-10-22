public class Disk {
    private char symbol;
    private int[] position;

    Disk(char symbol, int row, int column) {
        this.symbol = symbol;
        this.position[0] = row;
        this.position[1] = column;
    }

    public char getSymbol() {
        return this.symbol;
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
}
