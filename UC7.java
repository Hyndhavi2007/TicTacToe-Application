import java.util.Random;

/**
 * TicTacToe
 * UC7 allows the computer to make a random valid move
 * by reusing slot conversion and validation logic.
 */
public class TicTacToe {

    static char[][] board = {
        {'-', '-', '-'},
        {'-', '-', '-'},
        {'-', '-', '-'}
    };

    static char computerSymbol = 'O';

    public static void main(String[] args) {
        computerMove();
        printBoard();
    }

    /**
     * Generates random slot values until a valid move is found,
     * then places the computer symbol on the board.
     */
    static void computerMove() {
        Random random = new Random();

        int row, col;

        do {
            row = random.nextInt(3); // 0 to 2
            col = random.nextInt(3); // 0 to 2
        } while (!isValidMove(row, col));

        placeMove(row, col, computerSymbol);

        System.out.println("Computer placed at: (" + row + ", " + col + ")");
    }

    // Reuse UC5 logic
    static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 &&
               col >= 0 && col < 3 &&
               board[row][col] == '-';
    }

    // Reuse UC6 logic
    static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // Helper to visualize board
    static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}