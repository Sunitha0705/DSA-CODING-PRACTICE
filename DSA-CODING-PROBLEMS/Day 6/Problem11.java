import java.util.Scanner;

public class Problem11 {
    static class TicTacToe {
        private int[] rows, cols;
        private int diagonal, antiDiagonal, n;

        public TicTacToe(int n) {
            this.n = n;
            rows = new int[n];
            cols = new int[n];
            diagonal = 0;
            antiDiagonal = 0;
        }

        public int move(int row, int col, int player) {
            int add = (player == 1) ? 1 : -1;
            rows[row] += add;
            cols[col] += add;

            if (row == col) diagonal += add;
            if (row + col == n - 1) antiDiagonal += add;

            if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || 
                Math.abs(diagonal) == n || Math.abs(antiDiagonal) == n) {
                return player;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the board size:");
        int n = sc.nextInt();
        TicTacToe game = new TicTacToe(n);
        System.out.println("Enter the number of moves:");
        int moves = sc.nextInt();

        for (int i = 0; i < moves; i++) {
            System.out.println("Enter row, column, and player (1 or 2) for move " + (i + 1) + ":");
            int row = sc.nextInt();
            int col = sc.nextInt();
            int player = sc.nextInt();

            int result = game.move(row, col, player);
            if (result == 1) {
                System.out.println("Player 1 wins!");
                return;
            } else if (result == 2) {
                System.out.println("Player 2 wins!");
                return;
            }
        }
        System.out.println("No winner after all moves.");
    }
}
