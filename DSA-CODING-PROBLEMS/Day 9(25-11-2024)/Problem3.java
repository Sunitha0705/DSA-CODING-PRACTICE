import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}

class Problem3 {

    static ArrayList<Integer> topView(Node root) {
        class Pair {
            Node node;
            int hd;

            Pair(Node node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            Node node = current.node;
            int hd = current.hd;

            if (!map.containsKey(hd)) {
                map.put(hd, node.data);
            }

            if (node.left != null) queue.add(new Pair(node.left, hd - 1));
            if (node.right != null) queue.add(new Pair(node.right, hd + 1));
        }

        for (int value : map.values()) {
            result.add(value);
        }
        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.right = new Node(20);

        ArrayList<Integer> result = topView(root);
        System.out.println("Top view of the tree: " + result);
    }
}
