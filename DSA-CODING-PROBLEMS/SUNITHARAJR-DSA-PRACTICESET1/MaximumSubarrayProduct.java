import java.util.Scanner;

public class MaximumSubarrayProduct{

    public static int maxSubArrayProduct(int[] arr) {
        int maxProduct = arr[0];
        int minProduct = arr[0];
        int result = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }
            maxProduct = Math.max(arr[i], maxProduct * arr[i]);
            minProduct = Math.min(arr[i], minProduct * arr[i]);

            // Update result if the current maxProduct is greater
            result = Math.max(result, maxProduct);
        }

        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the elements of the array separated by spaces: ");
        String inputLine = scanner.nextLine(); 
        
        String[] inputStrings = inputLine.split(" ");
        int[] arr = new int[inputStrings.length];
        for (int i = 0; i < inputStrings.length; i++) {
            arr[i] = Integer.parseInt(inputStrings[i]); 
        }

        int maxSum = maxSubArrayProduct(arr); 
        System.out.println("Maximum subarray product is: " + maxSum); 

        scanner.close(); 
    }
}

