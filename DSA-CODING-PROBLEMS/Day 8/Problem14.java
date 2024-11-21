import java.util.Stack;
import java.util.Scanner;

public class Problem14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the expression: ");
        String s = scanner.nextLine();
        
        System.out.println("Result: " + calculate(s));
    }
    
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int sign = 1;
        int num = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            
            if (ch == '+' || ch == '-' || i == s.length() - 1 || ch == '(' || ch == ')') {
                if (ch == '(') {
                    stack.push(result);
                    stack.push(sign);
                    result = 0;
                    sign = 1;
                } else if (ch == ')') {
                    result += sign * num;
                    num = 0;
                    result *= stack.pop();
                    result += stack.pop();
                } else {
                    result += sign * num;
                    num = 0;
                    sign = (ch == '-') ? -1 : 1;
                }
            }
        }
        
        if (num != 0) {
            result += sign * num;
        }
        
        return result;
    }
}
