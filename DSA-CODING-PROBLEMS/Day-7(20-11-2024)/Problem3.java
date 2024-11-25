import java.util.*;

public class Problem3 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            
            if (!anagramMap.containsKey(sortedStr)) {
                anagramMap.put(sortedStr, new ArrayList<>());
            }
            anagramMap.get(sortedStr).add(str);
        }
        
        return new ArrayList<>(anagramMap.values());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of strings:");
        int n = scanner.nextInt();
        scanner.nextLine();  // consume the newline
        
        String[] strs = new String[n];
        
        System.out.println("Enter the strings:");
        for (int i = 0; i < n; i++) {
            strs[i] = scanner.nextLine();
        }
        
        Problem3 solver = new Problem3();
        List<List<String>> result = solver.groupAnagrams(strs);
        
        System.out.println("Grouped Anagrams:");
        System.out.println(result);
        
        scanner.close();
    }
}
