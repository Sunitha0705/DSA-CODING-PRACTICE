import java.util.Scanner;

public class Point {

    public static int findTransitionPoint(int[] arr) {
        int low = 0, high = arr.length - 1;
        
        if (arr[low] == 1) {
            return 0;
        }
        
        if (arr[high] == 0) {
            return -1;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == 1 && (mid == 0 || arr[mid - 1] == 0)) {
                return mid;
            } else if (arr[mid] == 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
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
        
        int result = findTransitionPoint(arr);
        System.out.println("The transition point is: " + result);
        sc.close();
    }
}
