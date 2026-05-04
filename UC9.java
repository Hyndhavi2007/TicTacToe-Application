import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static char[][] board = {
        {'-', '-', '-'},
        {'-', '-', '-'},
        {'-', '-', '-'}
    };

    static boolean isHumanTurn = true;
    static boolean gameOver = false;

    static char humanSymbol = 'X';
    static char computerSymbol = 'O';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            printBoard();

            if (isHumanTurn) {
                System.out.println("Your turn (enter row and column 0-2): ");
                int row = scanner.nextInt();
                int col = scanner.nextInt();

                if (isValidMove(row, col)) {
                    placeMove(row, col, humanSymbol);

                    if (hasWon(humanSymbol)) {
                        printBoard();
                        System.out.println("🎉 You win!");
                        gameOver = true;
                    } else {
                        isHumanTurn = false;
                    }
                } else {
                    System.out.println("Invalid move, try again.");
                }

            } else {
                computerMove();

                if (hasWon(computerSymbol)) {
                    printBoard();
                    System.out.println("💻 Computer wins!");
                    gameOver = true;
                } else {
                    isHumanTurn = true;
                }
            }

            if (!gameOver && isBoardFull()) {
                printBoard();
                System.out.println("🤝 It's a draw!");
                gameOver = true;
            }
        }

        scanner.close();
    }

    // UC5: Validate move
    static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 &&
               col >= 0 && col < 3 &&
               board[row][col] == '-';
    }

    // UC6: Place move
    static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // UC7: Computer random move
    static void computerMove() {
        Random random = new Random();
        int row, col;

        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (!isValidMove(row, col));

        placeMove(row, col, computerSymbol);
        System.out.println("Computer played: " + row + ", " + col);
    }

    // UC9: Win check
    static boolean hasWon(char symbol) {

        // Rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol &&
                board[i][1] == symbol &&
                board[i][2] == symbol) {
                return true;
            }
        }

        // Columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == symbol &&
                board[1][j] == symbol &&
                board[2][j] == symbol) {
                return true;
            }
        }

        // Diagonals
        if (board[0][0] == symbol &&
            board[1][1] == symbol &&
            board[2][2] == symbol) {
            return true;
        }

        if (board[0][2] == symbol &&
            board[1][1] == symbol &&
            board[2][0] == symbol) {
            return true;
        }

        return false;
    }

    // Check draw
    static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    // Print board
    static void printBoard() {
        System.out.println("\nBoard:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}