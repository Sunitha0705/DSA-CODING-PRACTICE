import java.util.Scanner;

public class Problem10 {
    public int interpolationSearch(int[] arr, int left, int right, int target) {
        if (left <= right && target >= arr[left] && target <= arr[right]) {
            int pos = left + ((right - left) / (arr[right] - arr[left])) * (target - arr[left]);
            if (arr[pos] == target) return pos;
            if (arr[pos] < target) return interpolationSearch(arr, pos + 1, right, target);
            if (arr[pos] > target) return interpolationSearch(arr, left, pos - 1, target);
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
        
        Problem10 searcher = new Problem10();
        int result = searcher.interpolationSearch(arr, 0, arr.length - 1, target);
        
        System.out.println("Element found at index: " + result);
        scanner.close();
    }
}
