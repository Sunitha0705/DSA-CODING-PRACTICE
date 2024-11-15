import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();

        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of intervals: ");
        int n = scanner.nextInt();

        int[][] intervals = new int[n][2];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter start of interval " + (i + 1) + ": ");
            intervals[i][0] = scanner.nextInt();
            System.out.print("Enter end of interval " + (i + 1) + ": ");
            intervals[i][1] = scanner.nextInt();
        }

        scanner.close();
        int[][] mergedIntervals = merge(intervals);

        System.out.println("Merged intervals:");
        for (int[] interval : mergedIntervals) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
