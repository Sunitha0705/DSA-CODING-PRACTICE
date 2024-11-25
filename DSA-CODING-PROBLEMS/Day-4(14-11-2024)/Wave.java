import java.util.Scanner;

class Wave {
    void waveArray(int arr[]) {
        int n = arr.length;
        
        // Traverse the array in steps of 2, and swap adjacent elements
        for (int i = 0; i < n - 1; i += 2) {
            // Swap arr[i] and arr[i+1] to satisfy the condition for wave-like array
            if (arr[i] < arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
            // If i > 0 and arr[i-1] is smaller than arr[i], swap them again
            if (i > 0 && arr[i] < arr[i - 1]) {
                int temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
       Wave solution = new Wave();
        solution.waveArray(arr);
        
        // Print the modified array
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        
        sc.close();
    }
}




