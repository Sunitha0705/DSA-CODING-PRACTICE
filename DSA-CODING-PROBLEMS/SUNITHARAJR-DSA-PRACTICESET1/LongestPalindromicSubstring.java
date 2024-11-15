import java.util.Scanner;

public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        
        String longest = "";

        for (int i = 0; i < s.length(); i++) {
            String oddPalindrome = expandAroundCenter(s, i, i);
            if (oddPalindrome.length() > longest.length()) {
                longest = oddPalindrome;
            }
            String evenPalindrome = expandAroundCenter(s, i, i + 1);
            if (evenPalindrome.length() > longest.length()) {
                longest = evenPalindrome;
            }
        }
        return longest;
    }

    private static String expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = scanner.nextLine();

        System.out.println("Longest Palindromic Substring: " + longestPalindrome(str));
    }
}
