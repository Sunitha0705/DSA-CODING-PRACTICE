import java.util.Scanner;

public class Coin {
    
    public static int countWays(int[] coins, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        
        for (int coin : coins) {
            for (int i = coin; i <= sum; i++) {
                dp[i] += dp[i - coin];
            }
        }
        
        return dp[sum];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of coins: ");
        int n = sc.nextInt();
        
        int[] coins = new int[n];
        System.out.println("Enter the coin denominations: ");
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        
        System.out.print("Enter the sum: ");
        int sum = sc.nextInt();
        
        int result = countWays(coins, sum);
        
        System.out.println("Number of ways to make sum " + sum + ": " + result);
        
        sc.close();
    }
}
