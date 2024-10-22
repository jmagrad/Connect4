public class Player {
    // true is red or X, false is blue or O
    private boolean color;

    Player(boolean color) {
        this.color = color;
    }

    public void placeDisk(Grid gameBoard, int column) {

    }

    public boolean getColor() {
        return this.color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

}
