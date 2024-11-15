import java.util.Scanner;
 
public class Sort {
    public static int findFloor(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int floor = -1;
 
        while (left <= right) {
            int mid = left + (right - left) / 2;
 
            if (arr[mid] == target) {
                return arr[mid];
            } else if (arr[mid] < target) {
                floor = arr[mid];
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return floor;
    }
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        // Get array elements from user as a single line
        System.out.print("Enter sorted array elements (space-separated): ");
        String[] input = scanner.nextLine().split(" ");
        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
 
        // Get target value
        System.out.print("Enter target value: ");
        int target = scanner.nextInt();
 
        // Find and print the floor of the target in the array
        System.out.println("Floor of " + target + " is: " + findFloor(arr, target));
 
        scanner.close();
    }
}
