import java.util.Scanner;

public class Containerwater{
    public static int maxArea(int[] arr) {
        int maxArea = 0;
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int height=Math.min(arr[left], arr[right]);
            int width=right - left;
            int area=height * width;
            maxArea=Math.max(maxArea, area);

            if (arr[left]<arr[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the heights:");
        String inputLine = scanner.nextLine(); 
        String[] inputStrings = inputLine.split(" ");
        int[] arr = new int[inputStrings.length];
        for (int i = 0; i < inputStrings.length; i++) {
            arr[i] = Integer.parseInt(inputStrings[i]); 
        }

        System.out.println("Output:"+maxArea(arr));
        scanner.close();
          
    }
}