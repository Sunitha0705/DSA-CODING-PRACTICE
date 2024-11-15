import java.util.*;

class Problem7 {
    public static int unionCount(int[] a, int[] b) {
        Set<Integer> set = new HashSet<>();
        
        for (int num : a) {
            set.add(num);
        }
        
        for (int num : b) {
            set.add(num);
        }
        
        return set.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the size of array a: ");
        int n = sc.nextInt();
        
        int[] a = new int[n];
        System.out.println("Enter elements of array a: ");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        
        System.out.print("Enter the size of array b: ");
        int m = sc.nextInt();
        
        int[] b = new int[m];
        System.out.println("Enter elements of array b: ");
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }
        
        int result = unionCount(a, b);
        
        System.out.println("Number of elements in the union: " + result);
        
        sc.close();
    }
}
