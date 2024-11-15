import java.util.Scanner;

public class maze {
    private static final int N = 4;

    private static void printSolution(int[][] solution) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isSafe(int[][] maze, int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
    }

    private static boolean solveMaze(int[][] maze) {
        int[][] solution = new int[N][N];
        if (!solveMazeUtil(maze, 0, 0, solution)) {
            System.out.println("Solution doesn't exist");
            return false;
        }
        printSolution(solution);
        return true;
    }

    private static boolean solveMazeUtil(int[][] maze, int x, int y, int[][] solution) {
        if (x == N - 1 && y == N - 1 && maze[x][y] == 1) {
            solution[x][y] = 1;
            return true;
        }
        if (isSafe(maze, x, y)) {
            solution[x][y] = 1;
            if (solveMazeUtil(maze, x + 1, y, solution)) {
                return true;
            }
            if (solveMazeUtil(maze, x, y + 1, solution)) {
                return true;
            }
            solution[x][y] = 0;
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] maze = new int[N][N];
        System.out.println("Enter the maze matrix (4x4) with 1s and 0s:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        solveMaze(maze);
        sc.close();
    }
}
