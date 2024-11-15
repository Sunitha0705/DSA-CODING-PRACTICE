import java.util.ArrayList;
import java.util.Scanner;

public class Buy {
    ArrayList<ArrayList<Integer>> stockBuySell(int A[], int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int i = 0;
        while (i < n - 1) {
            while (i < n - 1 && A[i + 1] <= A[i]) {
                i++;
            }
            if (i == n - 1) {
                break;
            }
            int buy = i++;
            while (i < n && A[i] >= A[i - 1]) {
                i++;
            }
            int sell = i - 1;
            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(buy);
            pair.add(sell);
            result.add(pair);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of days: ");
        int n = sc.nextInt();
        int[] A = new int[n];
        System.out.println("Enter stock prices for each day: ");
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        Buy solution = new Buy();
        ArrayList<ArrayList<Integer>> result = solution.stockBuySell(A, n);
        
        if (result.isEmpty()) {
            System.out.println("No Profit");
        } else {
            System.out.println("The buy and sell days are: ");
            for (ArrayList<Integer> pair : result) {
                System.out.println("(" + pair.get(0) + " " + pair.get(1) + ")");
            }
        }
        sc.close();
    }
}
