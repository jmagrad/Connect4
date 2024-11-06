import java.util.Scanner;

/* Extra credit, 
 * I have implemented a method to undo the last move and let
 * the player place their tile again. This is done by adding a last placed
 * tile variable to grid that if the user types 'u' or 'U' it will negate
 * that disk and go back to the player who placed that tile's turn.
 */

public class Main {
    public static void main(String[] args) {
        // initialize scanner object
        Scanner scanner = new Scanner(System.in);

        // ask for player names
        System.out.println("'X' Player One Enter Your Name:");
        String Xplayer = scanner.nextLine();

        System.out.println("'O' Player Two Enter Your Name: ");
        String Oplayer = scanner.nextLine();

        // initialize board
        Grid gameBoard = new Grid();

        // create player objects give refernce to gameboard
        Player player1 = new Player(true, Xplayer);
        player1.assignGameBoard(gameBoard);
        Player player2 = new Player(false, Oplayer);
        player2.assignGameBoard(gameBoard);

        // game loop infinite unless a gamestate causes a break
        while (true) {
            // Player 1 turn
            userInput(gameBoard, player1, scanner);
            if (gameBoard.getGameState() != GameState.noWinner)
                break;
            // Player 2 turn
            userInput(gameBoard, player2, scanner);
            if (gameBoard.getGameState() != GameState.noWinner)
                break;
        }

        // Reach break out case and give appropriate message before exiting the program
        System.out.println(gameBoard);
        switch (gameBoard.gamestate) {
            case Player1Wins:
                System.out.println("Congratulations " + player1.getName());
                break;
            case Player2Wins:
                System.out.println("Congratulations " + player2.getName());
                break;
            case Draw:
                System.out.println("Draw!");
            case noWinner:
                System.out.println("Game Quite.");
        }

    }

    public static void userInput(Grid board, Player player, Scanner scanner) {

        int column = 999;
        // print out the current state of the board
        System.out.println(board);
        // ask user to specify column to drop into or undo the last turn
        System.out.println("To undo the previous move type 'u' otherwise.., \n Player " + player
                + " Specify Column [0,1,2,3,4,5,6]:");

        // if there is an integer read the column number, else check if the player is
        // undoing their turn or has put something not valid.
        if (scanner.hasNextInt()) {
            column = scanner.nextInt();
        } else {
            String input = scanner.next();
            if (input.equalsIgnoreCase("u")) {
                board.undoLastTurn();
                return;
            } else {
                System.out.println("Invalid Input, try again!");
                userInput(board, player, scanner);
            }
        }

        // find the lowest free row in the column, returns 999 if the column is full
        int row = board.lowestAvailableRow(column);

        // continue to call user input until a valid column is called then place disk
        if (row == 999) {
            System.out.println("That column is already full or out of bounds!!");
            userInput(board, player, scanner);
        } else {
            player.takeTurn(board, column);
        }
    }
}
