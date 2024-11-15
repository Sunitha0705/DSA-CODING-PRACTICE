import java.util.Arrays;
import java.util.Scanner;

public class ChocoDistribution{
      public static int findminDiff(int[] arr,int n,int m){
          if(m==0 || n==0){
             return 0;
          }
          Arrays.sort(arr);
          if(n<m){
              return -1;
          }
          int minDiff = Integer.MAX_VALUE;
          for(int i =0;i+m-1 < n;i++){
             int diff = arr[i+m-1] - arr[i];
             minDiff = Math.min(minDiff,diff);
          }
          return minDiff;
      }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the packets of chocolates separated by space: ");
        String[] input = scanner.nextLine().split(" ");
        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        
        System.out.print("Enter the number of students: ");
        int m = scanner.nextInt();

       
        int result = findminDiff(arr, arr.length, m);
        if (result == -1) {
            System.out.println("Not enough packets for each student.");
        } else {
            System.out.println("Minimum difference is " + result);
        }
        
        scanner.close();
    }
}