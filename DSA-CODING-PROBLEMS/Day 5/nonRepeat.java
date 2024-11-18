import java.util.*;

class nonRepeat {
    static char nonRepeatingChar(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        for (char c : s.toCharArray()) {
            if (frequencyMap.get(c) == 1) {
                return c;
            }
        }
        return '$';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();
        System.out.println("First non-repeating character: " + nonRepeatingChar(s));
    }
}
