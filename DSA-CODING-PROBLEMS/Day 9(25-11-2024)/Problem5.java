import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}

class Problem5 {

    static Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }

        if (value < root.data) {
            root.left = insert(root.left, value);
        } else if (value > root.data) {
            root.right = insert(root.right, value);
        }

        return root;
    }

    static void leftViewUtil(Node root, int level, int[] maxLevel, ArrayList<Integer> result) {
        if (root == null) return;

        if (level > maxLevel[0]) {
            result.add(root.data);
            maxLevel[0] = level;
        }

        leftViewUtil(root.left, level + 1, maxLevel, result);
        leftViewUtil(root.right, level + 1, maxLevel, result);
    }

    static ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        int[] maxLevel = new int[] {-1};
        leftViewUtil(root, 0, maxLevel, result);
        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(10);

        root = insert(root, 5);
        root = insert(root, 15);
        root = insert(root, 3);
        root = insert(root, 7);
        root = insert(root, 12);
        root = insert(root, 18);

        ArrayList<Integer> result = leftView(root);
        System.out.println(result);
    }
}
