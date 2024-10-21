import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // TODO: game loop here
        int gamestate = 0;
        enum gameState {
            noWinner,
            Player1Wins,
            Player2Wins,
            Draw
        }

        // create board here

        // create player objects
        Player player1 = new Player(true);
        Player player2 = new Player(false);

        // initialize scanner object
        Scanner scanner = new Scanner(System.in);

        // initialize board
        Grid gameBoard = new Grid();

        while (gamestate == 0) {

        }
    }

    public static void userInput(char[][] board, boolean player, Scanner scanner) {

        for (char[] row : board) {
            System.out.println(row);
        }

        System.out.println("PlayerOne Specify Row [0,1,2]:");
        int x = scanner.nextInt();
        scanner.nextLine();
        System.out.println("PlayerOne Specify Column [0,1,2]:");
        int y = scanner.nextInt();
        scanner.nextLine();

        if (board[x][y] != '_') {
            System.out.println("Location aready taken!!");
            userInput(board, player, scanner);
        } else {
            if (player) {
                board[x][y] = 'X';
            } else {
                board[x][y] = 'O';
            }
        }

        return;
    }
}
