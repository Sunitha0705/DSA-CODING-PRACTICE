import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class Tree {
    public static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private static int checkHeight(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) return -1;

        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static TreeNode buildTree(int[] nodes) {
        if (nodes.length == 0) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(nodes[0]);
        queue.add(root);

        int index = 1;
        while (!queue.isEmpty() && index < nodes.length) {
            TreeNode current = queue.poll();

            if (nodes[index] != -1) {
                current.left = new TreeNode(nodes[index]);
                queue.add(current.left);
            }
            index++;

            if (index < nodes.length && nodes[index] != -1) {
                current.right = new TreeNode(nodes[index]);
                queue.add(current.right);
            }
            index++;
        }

        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of nodes in the tree: ");
        int n = scanner.nextInt();

        System.out.print("Enter the tree nodes (value -1 for null nodes, enter in level-order): ");
        int[] nodes = new int[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = scanner.nextInt();
        }

        TreeNode root = buildTree(nodes);

        if (isBalanced(root)) {
            System.out.println("The tree is balanced.");
        } else {
            System.out.println("The tree is not balanced.");
        }

        scanner.close();
    }
}
