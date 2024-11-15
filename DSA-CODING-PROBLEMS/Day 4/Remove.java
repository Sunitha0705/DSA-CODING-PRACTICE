import java.util.*;

class Remove {
    int removeDuplicates(int arr[]) {
        if (arr.length == 0) {
            return 0;
        }
        
        int uniqueIndex = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[uniqueIndex] = arr[i];
                uniqueIndex++;
            }
        }
        return uniqueIndex;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
       Remove solution = new Remove();
        int newSize = solution.removeDuplicates(arr);
        System.out.println(newSize);
        
        for (int i = 0; i < newSize; i++) {
            System.out.print(arr[i] + " ");
        }
        
        sc.close();
    }
}
