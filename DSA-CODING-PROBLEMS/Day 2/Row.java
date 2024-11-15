import java.util.Scanner;

public class Row {

    public static int rowWithMaxOnes(int[][] matrix) {
        int maxRow = -1;
        int maxCount = 0;

        for (int i = 0; i < matrix.length; i++) {
            int count = countOnes(matrix[i]);
            if (count > maxCount) {
                maxCount = count;
                maxRow = i;
            }
        }

        return maxRow;
    }

    private static int countOnes(int[] row) {
        int left = 0;
        int right = row.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (row[mid] == 1 && (mid == 0 || row[mid - 1] == 0)) {
                return row.length - mid; // Number of 1s in the row
            } else if (row[mid] == 1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return 0; // No 1s in the row
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];

        System.out.println("Enter the elements of the matrix row by row (0 or 1 only):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
                if (matrix[i][j] != 0 && matrix[i][j] != 1) {
                    System.out.println("Invalid input! Only 0 and 1 are allowed.");
                    return;
                }
            }
        }

        int maxRow = rowWithMaxOnes(matrix);
        System.out.println("Row with max 1s: " + maxRow);

        sc.close();
    }
}
