import java.util.*;

public class Problem9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter string s:");
        String s = sc.nextLine();
        
        System.out.println("Enter string t:");
        String t = sc.nextLine();
        
        String result = minWindow(s, t);
        
        System.out.println("Output:");
        System.out.println(result);
    }
    
    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        
        Map<Character, Integer> windowMap = new HashMap<>();
        int left = 0, right = 0;
        int required = tMap.size();
        int formed = 0;
        
        int[] ans = {-1, 0, 0}; // length, left, right
        
        while (right < s.length()) {
            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
            
            if (tMap.containsKey(c) && windowMap.get(c).intValue() == tMap.get(c).intValue()) {
                formed++;
            }
            
            while (left <= right && formed == required) {
                c = s.charAt(left);
                
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }
                
                windowMap.put(c, windowMap.get(c) - 1);
                if (tMap.containsKey(c) && windowMap.get(c).intValue() < tMap.get(c).intValue()) {
                    formed--;
                }
                
                left++;
            }
            
            right++;
        }
        
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
