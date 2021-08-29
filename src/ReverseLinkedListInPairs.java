/*
Reverse pairs of elements in a singly-linked list.

Examples

L = null, after reverse is null
L = 1 -> null, after reverse is 1 -> null
L = 1 -> 2 -> null, after reverse is 2 -> 1 -> null
L = 1 -> 2 -> 3 -> null, after reverse is 2 -> 1 -> 3 -> null
 */
//1->2->3->4->5

public class ReverseLinkedListInPairs {
    //solution1: recursion
public ListNode reverseInPairs(ListNode head){
    if (head == null || head.next == null){
        return head;
    }
    ListNode newHead = head.next; //new head
    head.next = reverseInPairs(head.next.next);
    newHead.next = head;
    return newHead;
}

    //solution1: iterative
}
