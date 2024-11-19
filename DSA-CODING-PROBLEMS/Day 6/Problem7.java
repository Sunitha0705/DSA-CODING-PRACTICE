import java.util.*;

public class Problem7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes:");
        int n = sc.nextInt();
        Integer[] nodes = new Integer[n];
        System.out.println("Enter the node values (use 'null' for empty nodes):");
        for (int i = 0; i < n; i++) {
            String input = sc.next();
            nodes[i] = input.equals("null") ? null : Integer.parseInt(input);
        }
        TreeNode root = buildTree(nodes, 0);
        System.out.println("Is valid BST: " + isValidBST(root));
    }

    public static TreeNode buildTree(Integer[] nodes, int index) {
        if (index >= nodes.length || nodes[index] == null) return null;
        TreeNode node = new TreeNode(nodes[index]);
        node.left = buildTree(nodes, 2 * index + 1);
        node.right = buildTree(nodes, 2 * index + 2);
        return node;
    }

    public static boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    public static boolean validate(TreeNode node, Integer low, Integer high) {
        if (node == null) return true;
        if ((low != null && node.val <= low) || (high != null && node.val >= high)) return false;
        return validate(node.left, low, node.val) && validate(node.right, node.val, high);
    }

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }
}
