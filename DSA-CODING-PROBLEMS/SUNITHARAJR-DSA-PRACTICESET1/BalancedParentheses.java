import java.util.Scanner;
import java.util.Stack;
public class BalancedParentheses{
       public static String isBalanced(String expression){
           Stack<Character> stack=new Stack<>();
           for(char ch:expression.toCharArray()){
               if(ch=='('){
                    stack.push(ch);
               }
               else if(ch == ')'){
                    if(stack.isEmpty()){
                          return "Not Balanced";
                    }
                    stack.pop();
               }
            }
            return stack.isEmpty()? "Balanced" : "Not Balanced";
       }
       public static void main(String args[]){
             Scanner scanner = new Scanner(System.in);
             System.out.println("Enter a paranthesis expression : ");
             String expression =scanner.nextLine();
             System.out.println(isBalanced(expression));
       }
}