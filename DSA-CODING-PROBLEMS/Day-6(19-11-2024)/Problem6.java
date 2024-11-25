import java.util.*;

public class Problem6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = sc.nextInt();
        System.out.println("Enter the number of columns:");
        int cols = sc.nextInt();
        int[][] grid = new int[rows][cols];
        System.out.println("Enter the elements of the grid:");
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                grid[i][j] = sc.nextInt();
        System.out.println("Minimum path sum: " + minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        for (int i = 1; i < grid.length; i++) grid[i][0] += grid[i - 1][0];
        for (int j = 1; j < grid[0].length; j++) grid[0][j] += grid[0][j - 1];
        for (int i = 1; i < grid.length; i++)
            for (int j = 1; j < grid[0].length; j++)
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
