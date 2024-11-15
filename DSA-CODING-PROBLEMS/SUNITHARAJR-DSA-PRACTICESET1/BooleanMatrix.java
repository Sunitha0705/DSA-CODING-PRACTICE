import java.util.Scanner;

public class BooleanMatrix{
    public static void modifyMatrix(int[][] mat) {
        int M = mat.length;
        int N = mat[0].length;

        boolean[] rows = new boolean[M];
        boolean[] cols = new boolean[N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (mat[i][j] == 1) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (rows[i] || cols[j]) {
                    mat[i][j] = 1;
                }
            }
        }
    }

    public static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rows (M): ");
        int M = scanner.nextInt();

        System.out.print("Enter number of columns (N): ");
        int N = scanner.nextInt();

        int[][] mat = new int[M][N];

        System.out.println("Enter the matrix elements (0 or 1):");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                mat[i][j] = scanner.nextInt();
            }
        }

        System.out.println("\nOriginal Matrix:");
        printMatrix(mat);

        modifyMatrix(mat);

        System.out.println("\nModified Matrix:");
        printMatrix(mat);

        scanner.close();
    }
}