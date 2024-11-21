import java.util.Scanner;

public class Problem15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the array of numbers (comma-separated): ");
        String input = scanner.nextLine();
        String[] inputArr = input.split(",");
        int[] nums = new int[inputArr.length];
        
        for (int i = 0; i < inputArr.length; i++) {
            nums[i] = Integer.parseInt(inputArr[i].trim());
        }

        System.out.print("Enter the target value: ");
        int target = scanner.nextInt();
        
        System.out.println("Result: " + searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return left;
    }
}
