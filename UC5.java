/**
 * TicTacToe
 * UC5 validates whether a move is inside the board boundaries
 * and whether the selected cell is empty.
 */
public class UC5 {

    static char[][] board = {
        {'-', '-', '-'},
        {'-', '-', '-'},
        {'-', '-', '-'}
    };

    /**
     * Entry point of the program. Tests the validation logic
     * using sample row and column values.
     */
    public static void main(String[] args) {
        // Testing a move at the center of the board
        System.out.println(isValidMove(1, 1));
    }

    /**
     * Checks if the given row and column are within bounds
     * and if the target cell is empty.
     * Input: Row, Column
     * Output: true if valid, false otherwise.
     */
    static boolean isValidMove(int row, int col) {
        // 1. Check if row and column are between 0 and 2
        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
            // 2. Check if the specific cell is still a hyphen
            return board[row][col] == '-';
        }
        // If either condition fails, the move is invalid
        return false;
    }
}