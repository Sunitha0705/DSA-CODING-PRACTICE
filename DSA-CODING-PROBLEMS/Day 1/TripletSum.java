import java.util.Arrays;
import java.util.Scanner;
 
public class TripletSum {
 
    public static boolean findTriplet(int[] arr, int target) {
        Arrays.sort(arr);  // Sort the array to use two-pointer technique
 
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;
 
            while (left < right) {
                int currentSum = arr[i] + arr[left] + arr[right];
                if (currentSum == target) {
                    System.out.println("Triplet found: " + arr[i] + ", " + arr[left] + ", " + arr[right]);
                    return true;
                } else if (currentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return false;
    }
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        // Get array from user as a single line of space-separated integers
        System.out.print("Enter array elements (space-separated): ");
        String[] input = scanner.nextLine().split(" ");
        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
 
        // Get the target sum from user
        System.out.print("Enter target sum: ");
        int target = scanner.nextInt();
 
        // Check if a triplet exists
        if (!findTriplet(arr, target)) {
            System.out.println("No triplet found with the given sum.");
        }
 
        scanner.close();
    }
}
