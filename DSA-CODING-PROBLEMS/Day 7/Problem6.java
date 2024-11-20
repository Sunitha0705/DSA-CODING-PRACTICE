import java.util.Scanner;

public class Problem6 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int islandCount = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    islandCount++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        
        return islandCount;
    }
    
    private void dfs(char[][] grid, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') {
            return;
        }
        
        grid[i][j] = '0';
        
        dfs(grid, i + 1, j, m, n);  // down
        dfs(grid, i - 1, j, m, n);  // up
        dfs(grid, i, j + 1, m, n);  // right
        dfs(grid, i, j - 1, m, n);  // left
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of rows:");
        int m = scanner.nextInt();
        System.out.println("Enter the number of columns:");
        int n = scanner.nextInt();
        
        char[][] grid = new char[m][n];
        
        System.out.println("Enter the grid (use '1' for land and '0' for water):");
        for (int i = 0; i < m; i++) {
            String row = scanner.next();
            grid[i] = row.toCharArray();
        }
        
        Problem6 solver = new Problem6();
        int result = solver.numIslands(grid);
        
        System.out.println("Number of islands: " + result);
        
        scanner.close();
    }
}
