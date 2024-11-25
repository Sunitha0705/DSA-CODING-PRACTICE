import java.util.*;

public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the linked list:");
        int n = sc.nextInt();
        ListNode head = new ListNode(sc.nextInt()), curr = head;
        for (int i = 1; i < n; i++) {
            curr.next = new ListNode(sc.nextInt());
            curr = curr.next;
        }
        System.out.println("Is the linked list a palindrome? " + isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode temp = slow;
            slow = slow.next;
            temp.next = prev;
            prev = temp;
        }
        if (fast != null) slow = slow.next;
        while (prev != null && prev.val == slow.val) {
            prev = prev.next;
            slow = slow.next;
        }
        return prev == null;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
