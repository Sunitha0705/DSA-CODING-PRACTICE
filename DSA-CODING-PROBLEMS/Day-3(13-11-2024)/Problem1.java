import java.util.*;

class Problem1 {
    public static int kthSmallest(int[] arr, int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(arr[i]);
        }
        int result = -1;
        for (int i = 1; i <= k; i++) {
            result = pq.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        System.out.print("Enter the value of k: ");
        int k = sc.nextInt();
        
        System.out.println(kthSmallest(arr, n, k));
        
        sc.close();
    }
}
