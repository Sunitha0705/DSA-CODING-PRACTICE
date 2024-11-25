import java.util.Scanner;

public class Problem7 {

    private int[] segmentTree;
    private int n;

    public Problem7(int[] arr) {
        n = arr.length;
        segmentTree = new int[4 * n];
        buildTree(arr, 0, 0, n - 1);
    }

    private void buildTree(int[] arr, int node, int start, int end) {
        if (start == end) {
            segmentTree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            int leftChild = 2 * node + 1;
            int rightChild = 2 * node + 2;

            buildTree(arr, leftChild, start, mid);
            buildTree(arr, rightChild, mid + 1, end);

            segmentTree[node] = segmentTree[leftChild] + segmentTree[rightChild];
        }
    }

    public int query(int L, int R) {
        return query(0, 0, n - 1, L, R);
    }

    private int query(int node, int start, int end, int L, int R) {
        if (R < start || end < L) {
            return 0;
        }

        if (L <= start && end <= R) {
            return segmentTree[node];
        }

        int mid = (start + end) / 2;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;

        int leftSum = query(leftChild, start, mid, L, R);
        int rightSum = query(rightChild, mid + 1, end, L, R);

        return leftSum + rightSum;
    }

    public void update(int i, int newValue) {
        update(0, 0, n - 1, i, newValue);
    }

    private void update(int node, int start, int end, int i, int newValue) {
        if (start == end) {
            segmentTree[node] = newValue;
        } else {
            int mid = (start + end) / 2;
            int leftChild = 2 * node + 1;
            int rightChild = 2 * node + 2;

            if (i <= mid) {
                update(leftChild, start, mid, i, newValue);
            } else {
                update(rightChild, mid + 1, end, i, newValue);
            }

            segmentTree[node] = segmentTree[leftChild] + segmentTree[rightChild];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        Problem7 segmentTree = new Problem7(arr);

        System.out.print("Enter the range [L, R] for query: ");
        int L = scanner.nextInt();
        int R = scanner.nextInt();
        System.out.println("Sum of values in range [" + L + ", " + R + "]: " + segmentTree.query(L, R));

        System.out.print("Enter the index and new value for update: ");
        int index = scanner.nextInt();
        int newValue = scanner.nextInt();
        segmentTree.update(index, newValue);

        System.out.print("Enter the range [L, R] for query after update: ");
        L = scanner.nextInt();
        R = scanner.nextInt();
        System.out.println("Sum of values in range [" + L + ", " + R + "] after update: " + segmentTree.query(L, R));
        
        scanner.close();
    }
}
