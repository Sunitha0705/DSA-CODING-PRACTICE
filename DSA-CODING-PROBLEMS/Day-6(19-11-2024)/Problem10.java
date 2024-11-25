import java.util.*;

public class Problem10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of courses:");
        int numCourses = sc.nextInt();
        System.out.println("Enter the number of prerequisites:");
        int n = sc.nextInt();
        int[][] prerequisites = new int[n][2];
        System.out.println("Enter the prerequisites as pairs (course, prerequisite):");
        for (int i = 0; i < n; i++) {
            prerequisites[i][0] = sc.nextInt();
            prerequisites[i][1] = sc.nextInt();
        }
        System.out.println("Can finish all courses: " + canFinish(numCourses, prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            graph.putIfAbsent(pre[1], new ArrayList<>());
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) if (indegree[i] == 0) queue.add(i);
        int count = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            count++;
            if (graph.containsKey(curr)) {
                for (int next : graph.get(curr)) {
                    indegree[next]--;
                    if (indegree[next] == 0) queue.add(next);
                }
            }
        }
        return count == numCourses;
    }
}
