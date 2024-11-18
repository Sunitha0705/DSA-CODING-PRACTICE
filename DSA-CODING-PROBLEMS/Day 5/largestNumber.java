import java.util.*;

class largestNumber {
    static String formLargestNumber(int[] arr) {
        String[] nums = Arrays.stream(arr).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(nums, (a, b) -> (b + a).compareTo(a + b));
        if (nums[0].equals("0")) return "0";
        StringBuilder result = new StringBuilder();
        for (String num : nums) {
            result.append(num);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Largest number formed: " + formLargestNumber(arr));
    }
}
