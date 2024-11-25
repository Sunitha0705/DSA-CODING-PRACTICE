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

public class Problem2 {

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

    private static void inOrderTraversal(Node node, List<Integer> values) {
        if (node == null) return;
        inOrderTraversal(node.left, values);
        values.add(node.value);
        inOrderTraversal(node.right, values);
    }

    private static Node convertToBST(List<Integer> values, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        Node node = new Node(values.get(mid));

        node.left = convertToBST(values, start, mid - 1);
        node.right = convertToBST(values, mid + 1, end);
        
        return node;
    }

    private static Node binaryTreeToBST(Node root) {
        List<Integer> values = new ArrayList<>();
        inOrderTraversal(root, values);
        Collections.sort(values);
        return convertToBST(values, 0, values.size() - 1);
    }

    private static void printTree(Node node, String prefix, boolean isLeft) {
        if (node == null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + "null");
            return;
        }
        System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.value);
        printTree(node.left, prefix + (isLeft ? "│   " : "    "), true);
        printTree(node.right, prefix + (isLeft ? "│   " : "    "), false);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Build the binary tree:");
        Node root = buildTree(scanner);

        System.out.println("\nOriginal Tree Structure:");
        printTree(root, "", true);

        Node bstRoot = binaryTreeToBST(root);

        System.out.println("\nConverted Binary Search Tree Structure:");
        printTree(bstRoot, "", true);

        scanner.close();
    }
}
