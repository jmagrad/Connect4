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
        // initialize scanner object
        Scanner scanner = new Scanner(System.in);

        // ask for player names
        System.out.println("Player One Enter Your Name:");
        String Xplayer = scanner.nextLine();

        System.out.println("Player Two Enter Your Name: ");
        String Oplayer = scanner.nextLine();

        // create player objects
        Player player1 = new Player(true, Xplayer);
        Player player2 = new Player(false, Oplayer);

        // initialize board
        Grid gameBoard = new Grid();

        // game loop
        while (true) {

            if(userInput(gameBoard, player1, scanner) != gameState.noWinner)break;
            if (userInput(gameBoard, player1, scanner) != gameState.noWinner)
                break;
        }
    }

    public static gameState userInput(Grid board, Player player, Scanner scanner) {
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
        return board.checkGameState();
    }
}
