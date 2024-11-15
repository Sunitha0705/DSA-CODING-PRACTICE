import java.util.Stack;
import java.util.Scanner;

public class NextGreaterElement {

    public static void nextGreaterElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = -1; // Initialize all elements as -1

            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                result[stack.pop()] = arr[i];
            }

            stack.push(i);
        }

        
        for (int i = 0; i < n; i++) {
            System.out.println(result[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        nextGreaterElement(arr);
    }
}
