import java.util.Scanner;

enum gameState {
    noWinner,
    Player1Wins,
    Player2Wins,
    Draw
}

public class Main {
    public static void main(String[] args) {
        // TODO: game loop here

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
        System.out.println("PlayerOne Specify Column [0,1,2]:");
        int y = scanner.nextInt();
        scanner.nextLine();
        int x = board.lowestAvailableRow(y);

        if (x == 999) {
            System.out.println("That column is already full!!");
            userInput(board, player, scanner);
        } else {
            if (player.getColor()) {
                board.getGrid()[x][y].setSymbol('X');
            } else {
                board.getGrid()[x][y].setSymbol('O');
                ;
            }
        }

        return;
    }
}
