import java.util.*;

class Node {
    int value;
    Node left, right;

    Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class Problem1 {
    private static Node buildTree(Scanner scanner) {
        System.out.println("Enter node value (or 'null' if no node):");
        String input = scanner.next();
        if (input.equals("null")) return null;

        Node node = new Node(Integer.parseInt(input));
        System.out.println("Enter left child of " + node.value + ":");
        node.left = buildTree(scanner);
        System.out.println("Enter right child of " + node.value + ":");
        node.right = buildTree(scanner);
        return node;
    }

    private static boolean isValidBST(Node node, Integer min, Integer max) {
        if (node == null) return true;
        if ((min != null && node.value <= min) || (max != null && node.value >= max)) return false;
        return isValidBST(node.left, min, node.value) && isValidBST(node.right, node.value, max);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Build the binary tree:");
        Node root = buildTree(scanner);
        boolean result = isValidBST(root, null, null);
        System.out.println(result ? "The tree is a valid BST." : "The tree is NOT a valid BST.");
        scanner.close();
    }
}
