import java.util.Stack;
import java.util.Scanner;

public class Problem11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the absolute Unix path: ");
        String path = scanner.nextLine();
        
        System.out.println("Simplified Canonical Path: " + simplifyPath(path));
    }

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        
        String[] components = path.split("/");
        
        for (String component : components) {
            if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (component.equals(".") || component.isEmpty()) {
                continue;
            } else {
                stack.push(component);
            }
        }
        
        StringBuilder simplifiedPath = new StringBuilder();
        
        if (stack.isEmpty()) {
            simplifiedPath.append("/");
        } else {
            while (!stack.isEmpty()) {
                simplifiedPath.insert(0, "/" + stack.pop());
            }
        }
        
        return simplifiedPath.toString();
    }
}
