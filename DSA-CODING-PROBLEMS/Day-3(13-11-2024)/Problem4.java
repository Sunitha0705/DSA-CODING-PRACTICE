import java.util.*;

class Problem4 {
    public static int equilibriumPoint(int[] arr, int n) {
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }
        
        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum -= arr[i];
            
            if (leftSum == totalSum) {
                return i + 1; // 1-based index
            }
            
            leftSum += arr[i];
        }
        
        return -1;
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
        
        System.out.println(equilibriumPoint(arr, n));
        
        sc.close();
    }
}
