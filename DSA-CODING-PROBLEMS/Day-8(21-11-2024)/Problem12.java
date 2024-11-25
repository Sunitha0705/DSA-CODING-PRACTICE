import java.util.Stack;
import java.util.Scanner;

public class Problem12 {
    static class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);
            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
            } else {
                minStack.push(minStack.peek());
            }
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MinStack minStack = new MinStack();

        System.out.println("Enter the sequence of operations:");
        String[] operations = scanner.nextLine().split(",");

        for (String operation : operations) {
            operation = operation.trim();
            if (operation.startsWith("push")) {
                int value = Integer.parseInt(operation.substring(5, operation.length() - 1).trim());
                minStack.push(value);
                System.out.println("null");
            } else if (operation.equals("pop")) {
                minStack.pop();
                System.out.println("null");
            } else if (operation.equals("top")) {
                System.out.println(minStack.top());
            } else if (operation.equals("getMin")) {
                System.out.println(minStack.getMin());
            }
        }

        scanner.close();
    }
}
