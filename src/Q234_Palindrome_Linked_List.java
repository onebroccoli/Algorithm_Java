/*
Given the head of a singly linked list,
return true if it is a palindrome.



Example 1:


Input: head = [1,2,2,1]
Output: true
Example 2:


Input: head = [1,2]
Output: false

 */

public class Q234_Palindrome_Linked_List {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        //use two pointers, fast pointer move 2 steps a time,
        //so when slow pointer is at the middle of the list, fast already reaches the end
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //when slow reaches the middle, reverse the 2nd half
        ListNode secondHalfHead = reverse(slow.next);
        ListNode firstHalfHead = head;
        while (secondHalfHead != null && firstHalfHead != null) {
            if (secondHalfHead.val != firstHalfHead.val) {
                return false;
            }
            secondHalfHead = secondHalfHead.next;
            firstHalfHead = firstHalfHead.next;
        }
        return true;
    }
    private ListNode reverse(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        while (head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
