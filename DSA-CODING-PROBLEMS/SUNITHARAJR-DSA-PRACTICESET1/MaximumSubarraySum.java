import java.util.Scanner;

public class MaximumSubarraySum{

    public static int maxSubArraySum(int[] arr) {
        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the elements of the array separated by spaces: ");
        String inputLine = scanner.nextLine();  // Read the entire line of input

        
        String[] inputStrings = inputLine.split(" ");
        int[] arr = new int[inputStrings.length];
        for (int i = 0; i < inputStrings.length; i++) {
            arr[i] = Integer.parseInt(inputStrings[i]); 
        }

        int maxSum = maxSubArraySum(arr); 
        System.out.println("Maximum subarray sum is: " + maxSum); 

        scanner.close(); 
    }
}