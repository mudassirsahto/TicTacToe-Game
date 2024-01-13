import java.util.Scanner;

public class TicTacToeGame {
    private char[][] board;
    private char currentPlayer;

    public TicTacToeGame() {
        board = new char[3][3];
        currentPlayer = 'X';
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    private void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean makeMove(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
            board[row][col] = currentPlayer;
            return true;
        }
        return false;
    }

    private boolean checkWin(char player) {
        // Implement your win condition checks here
        // For simplicity, you can start with a basic check
        for (int i = 0; i < 3; i++) {
        if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
            return true; // Found a winning row
        }
        
        for (int j = 0; j < 3; j++){
        if (board[0][j] == player && board[1][j] == player && board[2][j] == player){
            return true; // Found a winning column
        }
        }
        
        if(board[0][0]==player && board[1][1] == player && board[2][2] == player){
            return true;
        }
        
         if(board[0][2]==player && board[1][1] == player && board[2][0] == player){
            return true;
        }
    }
        return false; // No winning row found
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        int row, col;

        do {
            printBoard();
            System.out.println("Player " + currentPlayer + ", enter your move (row and column): ");
            row = scanner.nextInt();
            col = scanner.nextInt();

            if (makeMove(row, col)) {
                if (checkWin(currentPlayer)) {
                    printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                }

                switchPlayer();
            } else {
                System.out.println("Invalid move. Try again.");
            }

        } while (true);

        scanner.close();
    }

    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        game.playGame();
    }
}
