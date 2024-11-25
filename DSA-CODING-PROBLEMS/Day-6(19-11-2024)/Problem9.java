import java.util.*;

public class Problem9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the begin word:");
        String beginWord = sc.next();
        System.out.println("Enter the end word:");
        String endWord = sc.next();
        System.out.println("Enter the number of words in the word list:");
        int n = sc.nextInt();
        List<String> wordList = new ArrayList<>();
        System.out.println("Enter the words in the word list:");
        for (int i = 0; i < n; i++) wordList.add(sc.next());
        
        List<List<String>> result = findLadders(beginWord, endWord, wordList);
        System.out.println("All shortest transformation sequences: " + result);
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();
        if (!wordSet.contains(endWord)) return result;

        Map<String, List<String>> graph = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        Map<String, Integer> distance = new HashMap<>();
        distance.put(beginWord, 0);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                for (String neighbor : getNeighbors(current, wordSet)) {
                    if (!distance.containsKey(neighbor)) {
                        distance.put(neighbor, distance.get(current) + 1);
                        queue.add(neighbor);
                    }
                    graph.computeIfAbsent(current, k -> new ArrayList<>()).add(neighbor);
                }
            }
        }

        List<String> path = new ArrayList<>();
        path.add(beginWord);
        dfs(beginWord, endWord, graph, distance, path, result);
        return result;
    }

    private static void dfs(String current, String endWord, Map<String, List<String>> graph, 
                            Map<String, Integer> distance, List<String> path, List<List<String>> result) {
        if (current.equals(endWord)) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (!graph.containsKey(current)) return;

        for (String neighbor : graph.get(current)) {
            if (distance.get(neighbor) == distance.get(current) + 1) {
                path.add(neighbor);
                dfs(neighbor, endWord, graph, distance, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    private static List<String> getNeighbors(String word, Set<String> wordSet) {
        List<String> neighbors = new ArrayList<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char original = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                String newWord = new String(chars);
                if (wordSet.contains(newWord) && !newWord.equals(word)) {
                    neighbors.add(newWord);
                }
            }
            chars[i] = original;
        }
        return neighbors;
    }
}
