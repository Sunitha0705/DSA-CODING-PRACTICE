import java.util.Scanner;

public class Problem5 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        
        return profit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of days:");
        int n = scanner.nextInt();
        
        int[] prices = new int[n];
        
        System.out.println("Enter the stock prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }
        
        Problem5 solver = new Problem5();
        int result = solver.maxProfit(prices);
        
        System.out.println("Maximum profit: " + result);
        
        scanner.close();
    }
}
