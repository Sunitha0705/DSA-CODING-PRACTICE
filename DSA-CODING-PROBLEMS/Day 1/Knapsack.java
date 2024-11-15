import java.util.Scanner;
 
public class Knapsack {
    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];
 
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][capacity];
    }
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        // Get weights as a single line of space-separated integers
        System.out.print("Enter weights (space-separated): ");
        String[] weightsInput = scanner.nextLine().split(" ");
        int[] weights = new int[weightsInput.length];
        for (int i = 0; i < weightsInput.length; i++) {
            weights[i] = Integer.parseInt(weightsInput[i]);
        }
 
        // Get values as a single line of space-separated integers
        System.out.print("Enter values (space-separated): ");
        String[] valuesInput = scanner.nextLine().split(" ");
        int[] values = new int[valuesInput.length];
        for (int i = 0; i < valuesInput.length; i++) {
            values[i] = Integer.parseInt(valuesInput[i]);
        }
 
        // Get capacity as a single integer
        System.out.print("Enter knapsack capacity: ");
        int capacity = scanner.nextInt();
 
        // Calculate the maximum value for the knapsack
        int maxValue = knapsack(weights, values, capacity);
        System.out.println("Maximum value in Knapsack = " + maxValue);
 
        scanner.close();
    }
}
