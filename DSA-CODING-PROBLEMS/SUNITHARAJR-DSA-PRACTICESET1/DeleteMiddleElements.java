import java.util.Stack;
import java.util.Scanner;

public class DeleteMiddleElements {

    public static void deleteMiddle(Stack<Integer> stack, int size, int current) {
        if (stack.isEmpty() || current == size / 2) {
            stack.pop();
            return;
        }

        int temp = stack.pop();
        deleteMiddle(stack, size, current + 1);
        stack.push(temp);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the stack: ");
        int n = scanner.nextInt();
        
        Stack<Integer> stack = new Stack<>();
        System.out.println("Enter the elements of the stack:");
        for (int i = 0; i < n; i++) {
            stack.push(scanner.nextInt());
        }

        int size = stack.size();
        deleteMiddle(stack, size, 0);

        System.out.println("Stack after deleting middle element: " + stack);
    }
}
