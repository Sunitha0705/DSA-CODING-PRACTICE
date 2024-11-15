import java.util.*;

class Problem3 {
    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch);
            } else if (ch == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (ch == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                return false;
            }
        }
        
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the expression: ");
        String s = sc.nextLine();
        
        System.out.println(isBalanced(s));
        
        sc.close();
    }
}
