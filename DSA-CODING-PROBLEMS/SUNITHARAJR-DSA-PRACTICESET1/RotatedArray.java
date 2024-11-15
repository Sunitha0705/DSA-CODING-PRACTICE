import java.util.Scanner;

public class RotatedArray {

    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i; 
            }
        }
        return -1; 
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

        System.out.print("Enter the key to search for: ");
        int key = scanner.nextInt();

        int index = linearSearch(arr, key);
        if (index != -1) {
            System.out.println("Key found at index: " + index);
        } else {
            System.out.println("-1");
        }

        scanner.close();
    }
}


