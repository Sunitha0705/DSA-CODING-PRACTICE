import java.util.Scanner;

public class Problem9 {
    public int ternarySearch(int[] arr, int left, int right, int target) {
        if (right >= left) {
            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;

            if (arr[mid1] == target) return mid1;
            if (arr[mid2] == target) return mid2;

            if (target < arr[mid1]) return ternarySearch(arr, left, mid1 - 1, target);
            if (target > arr[mid2]) return ternarySearch(arr, mid2 + 1, right, target);
            return ternarySearch(arr, mid1 + 1, mid2 - 1, target);
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of elements:");
        int n = scanner.nextInt();
        
        int[] arr = new int[n];
        
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        System.out.println("Enter the target value:");
        int target = scanner.nextInt();
        
        Problem9 searcher = new Problem9();
        int result = searcher.ternarySearch(arr, 0, arr.length - 1, target);
        
        System.out.println("Element found at index: " + result);
        scanner.close();
    }
}
