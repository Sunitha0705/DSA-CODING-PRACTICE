import java.util.Scanner;

public class Problem19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the length of the array: ");
        int n = scanner.nextInt();
        
        int[] nums = new int[n];
        
        System.out.print("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        
        System.out.print("Enter the target: ");
        int target = scanner.nextInt();
        
        int[] result = searchRange(nums, target);
        
        System.out.print("Result: [");
        System.out.print(result[0] + "," + result[1]);
        System.out.println("]");
    }
    
    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        
        // Find the starting position
        result[0] = binarySearch(nums, target, true);
        
        // Find the ending position
        result[1] = binarySearch(nums, target, false);
        
        return result;
    }
    
    private static int binarySearch(int[] nums, int target, boolean findStart) {
        int left = 0, right = nums.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                result = mid;
                if (findStart) {
                    right = mid - 1; // Move to the left half to find the start position
                } else {
                    left = mid + 1; // Move to the right half to find the end position
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
}
