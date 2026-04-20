/**
 * TicTacToe
 * UC1 initializes and displays an empty Tic-Tac-Toe board in a proper
 * grid format. This use case introduces 2D arrays, nested loops,
 * and formatted console output.
 */
public class UC1 {
    static char[][] board = new char[3][3];

    public static void main(String[] args) {
        initializeBoard();
        printBoard();
    }

    /**
     * Initializes the 3x3 board by filling each cell with '-'
     */
    static void initializeBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = '-';
            }
        }
    }

    /**
     * Prints the Tic-Tac-Toe board in grid format
     */
    static void printBoard() {
        for (int row = 0; row < 3; row++) {
            System.out.println("-------------");
            for (int col = 0; col < 3; col++) {
                System.out.print("| " + board[row][col] + " ");
            }
            System.out.println("|");
        }
        System.out.println("-------------");
    }
}