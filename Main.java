import java.util.Scanner;

enum gameState {
    noWinner,
    Player1Wins,
    Player2Wins,
    Draw
}

enum turnState {
    Player1Turn,
    Player2Turn,
    None
}

public class Main {
    public static void main(String[] args) {
        // initialize variables
        gameState gamestate = gameState.noWinner;

        // create player objects
        Player player1 = new Player(true);
        Player player2 = new Player(false);

        // initialize scanner object
        Scanner scanner = new Scanner(System.in);

        // initialize board
        Grid gameBoard = new Grid();

        while (gamestate == gameState.noWinner) {
            userInput(gameBoard, player1, scanner);
            userInput(gameBoard, player2, scanner);
        }
    }

    public static void userInput(Grid board, Player player, Scanner scanner) {
        System.out.println(board);
        System.out.println("Player " + player + " Specify Column [0,1,2,3,4,5,6]:");
        int column = scanner.nextInt();
        scanner.nextLine();
        int row = board.lowestAvailableRow(column);

        if (row == 999) {
            System.out.println("That column is already full!!");
            userInput(board, player, scanner);
        } else {
            player.placeDisk(board, column);
        }

        return;
    }

}
