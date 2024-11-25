import java.util.Arrays;
import java.util.Scanner;
 
public class Equal {
    public static boolean areArraysEqual(int[] arr1, int[] arr2) {
        // Check if both arrays are of the same length and contain the same elements
        return Arrays.equals(arr1, arr2);
    }
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        // Get the first array from the user
        System.out.print("Enter elements of the first array (space-separated): ");
        String[] input1 = scanner.nextLine().split(" ");
        int[] arr1 = new int[input1.length];
        for (int i = 0; i < input1.length; i++) {
            arr1[i] = Integer.parseInt(input1[i]);
        }
 
        // Get the second array from the user
        System.out.print("Enter elements of the second array (space-separated): ");
        String[] input2 = scanner.nextLine().split(" ");
        int[] arr2 = new int[input2.length];
        for (int i = 0; i < input2.length; i++) {
            arr2[i] = Integer.parseInt(input2[i]);
        }
 
        // Check if the arrays are equal
        if (areArraysEqual(arr1, arr2)) {
            System.out.println("The arrays are equal.");
        } else {
            System.out.println("The arrays are not equal.");
        }
 
        scanner.close();
    }
}
