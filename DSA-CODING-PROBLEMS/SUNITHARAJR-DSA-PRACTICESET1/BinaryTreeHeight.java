import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class BinaryTreeHeight {

    public int findHeight(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public TreeNode createTreeFromInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the root node value:");
        int rootVal = scanner.nextInt();

        TreeNode root = new TreeNode(rootVal);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();

            System.out.println("Enter left child of " + currentNode.val + " (or -1 for no child):");
            int leftVal = scanner.nextInt();
            if (leftVal != -1) {
                currentNode.left = new TreeNode(leftVal);
                queue.add(currentNode.left);
            }

            System.out.println("Enter right child of " + currentNode.val + " (or -1 for no child):");
            int rightVal = scanner.nextInt();
            if (rightVal != -1) {
                currentNode.right = new TreeNode(rightVal);
                queue.add(currentNode.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        BinaryTreeHeight tree = new BinaryTreeHeight();
        TreeNode root = tree.createTreeFromInput();
        int height = tree.findHeight(root);
        System.out.println("The height of the binary tree is: " + height);
    }
}
