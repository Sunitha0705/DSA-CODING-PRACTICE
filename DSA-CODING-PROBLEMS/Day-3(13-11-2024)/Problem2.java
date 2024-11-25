import java.util.*;

class Problem2 {
    public static int minDifference(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int ans = arr[n - 1] - arr[0]; 
        
        for (int i = 1; i < n; i++) {
            int min = Math.min(arr[0] + k, arr[i] - k);
            int max = Math.max(arr[i - 1] + k, arr[n - 1] - k);
            ans = Math.min(ans, max - min);
        }
        
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        System.out.print("Enter the value of k: ");
        int k = sc.nextInt();
        
        System.out.println(minDifference(arr, n, k));
        
        sc.close();
    }
}
