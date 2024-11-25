import java.util.Scanner;

public class FindOccurrences {

    public static int[] findFirstAndLast(int[] arr, int x) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;

        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                result[0] = mid;
                result[1] = mid;
                while (result[0] > 0 && arr[result[0] - 1] == x) {
                    result[0]--;
                }
                while (result[1] < arr.length - 1 && arr[result[1] + 1] == x) {
                    result[1]++;
                }
                break;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
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
        System.out.print("Enter the element to search for: ");
        int x = sc.nextInt();
        int[] result = findFirstAndLast(arr, x);
        System.out.println("First and last occurrence of " + x + ": [" + result[0] + ", " + result[1] + "]");
        sc.close();
    }
}
