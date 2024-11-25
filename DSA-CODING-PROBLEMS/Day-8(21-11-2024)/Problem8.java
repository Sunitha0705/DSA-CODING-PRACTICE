import java.util.*;

public class Problem8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the string s:");
        String s = sc.nextLine();
        
        System.out.println("Enter the number of words:");
        int n = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Enter the words:");
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }
        
        List<Integer> result = findSubstring(s, words);
        
        System.out.println("Output:");
        if (result.isEmpty()) {
            System.out.println("[]");
        } else {
            System.out.println(result);
        }
    }
    
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }
        
        int wordLength = words[0].length();
        int wordCount = words.length;
        int substringLength = wordLength * wordCount;
        
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        for (String word : words) {
            wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
        }
        
        for (int i = 0; i <= s.length() - substringLength; i++) {
            Map<String, Integer> seenWords = new HashMap<>();
            int j = 0;
            
            while (j < wordCount) {
                int wordStart = i + j * wordLength;
                String word = s.substring(wordStart, wordStart + wordLength);
                
                if (!wordFrequencyMap.containsKey(word)) {
                    break;
                }
                
                seenWords.put(word, seenWords.getOrDefault(word, 0) + 1);
                
                if (seenWords.get(word) > wordFrequencyMap.get(word)) {
                    break;
                }
                
                j++;
            }
            
            if (j == wordCount) {
                result.add(i);
            }
        }
        
        return result;
    }
}
