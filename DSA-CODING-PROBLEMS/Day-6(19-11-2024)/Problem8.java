import java.util.*;

public class Problem8 {
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
        System.out.println("Shortest transformation sequence length: " + ladderLength(beginWord, endWord, wordList));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int steps = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                char[] chars = word.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char original = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[j] = c;
                        String nextWord = new String(chars);
                        if (nextWord.equals(endWord)) return steps + 1;
                        if (wordSet.contains(nextWord)) {
                            queue.add(nextWord);
                            wordSet.remove(nextWord);
                        }
                    }
                    chars[j] = original;
                }
            }
            steps++;
        }
        return 0;
    }
}
