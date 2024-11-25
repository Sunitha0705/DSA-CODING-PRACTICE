import java.util.HashSet;
import java.util.Scanner;

public class Sequence {
    public static int findLongestConsecutiveSubsequence(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int longestStreak = 0;

        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = findLongestConsecutiveSubsequence(nums);
        System.out.println("Length of the longest consecutive subsequence: " + result);

        sc.close();
    }
}
