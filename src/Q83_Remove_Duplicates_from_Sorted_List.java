/*
Given the head of a sorted linked list,
delete all duplicates such that each element
appears only once. Return the linked list sorted
as well.
Input: head = [1,1,2]
Output: [1,2]

Input: head = [1,1,2,3,3]
Output: [1,2,3]

Constraints:

The number of nodes in the list is in
the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted
in ascending order.

 */
public class Q83_Remove_Duplicates_from_Sorted_List {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
//        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head){
        ListNode curr = head;
        while (curr != null && curr.next != null){
            if (curr.val == curr.next.val){
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}
