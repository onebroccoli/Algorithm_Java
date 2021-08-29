/*
Given the head of a linked list and a value x,
partition it such that all nodes less than x come before
nodes greater than or equal to x.
You should preserve the original relative order of the
nodes in each of the two partitions.

Example 1:

Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]

Example 2:
Input: head = [2,1], x = 2
Output: [1,2]


Constraints:
The number of nodes in the list is in the range [0, 200].
-100 <= Node.val <= 100
-200 <= x <= 200

 */
public class Q86_Partition_List {
    public ListNode partition(ListNode head, int target){
        //corner case
        if (head == null || head.next == null){
            return head;
        }
        ListNode smallHead = new ListNode(0);
        ListNode largeHead = new ListNode(0);
        ListNode small = smallHead;
        ListNode large = largeHead;
        while (head != null){
            if (head.val < target){
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        //connect two partitions
        small.next = largeHead.next;
        //unlink the last node in large partition
        large.next = null;
        return smallHead.next;
    }
}
