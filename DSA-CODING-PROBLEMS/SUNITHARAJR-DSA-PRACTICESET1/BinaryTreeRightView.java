import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class BinaryTreeRightView {

    public void printRightView(TreeNode root, int maxDepth) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int currentDepth = 0;

        while (!queue.isEmpty() && currentDepth < maxDepth) {
            int levelSize = queue.size();
            currentDepth++;

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                if (i == levelSize - 1) {
                    System.out.print(currentNode.val + " ");
                }

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }
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
        BinaryTreeRightView tree = new BinaryTreeRightView();
        TreeNode root = tree.createTreeFromInput();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the maximum depth for the right view:");
        int maxDepth = scanner.nextInt();

        System.out.println("Right view of the binary tree up to depth " + maxDepth + ":");
        tree.printRightView(root, maxDepth);
    }
}
