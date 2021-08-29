/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes,
only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */

/*
Solution:
1. find middle of the linked list  O(N)
2. reverse the second half of the list O(N/2)
3. merge two linked list O(N/2)
Time: O(N)
Space:O(1)
 */

public class Q143_Reorder_List {
    public ListNode reorderList(ListNode head) {
        //sanity check if null return null
        if (head == null) return null;
        //1. find middle of linked list
        //if even number, return second one  123456--> 4
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the second part of the list
        //convert 1 2 3 4 5 6 into 1 2 3 4, and 6 5 4
        ListNode prev = null, curr = slow,tmp;
        while (curr != null){
            tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
            //1->2->3->4
            //    cur = 2, tmp = 3, cur.next = 1, prev = cur, cur = 3
        }

        //merge two sorted linked lists
        //merge 1-2-3-4 and 6-5-4 into 1-6-2-5-3-4
        ListNode first = head, second = prev;
        while (second.next != null){
            tmp = first.next;
            first.next = second;
            first = tmp;

            tmp = second.next;
            second.next = first;
            second = tmp;
        }
        return head;
    }

    public String printList(ListNode head) {
        ListNode cur = head;
        String s = "";
        while (cur != null) {
            s += Integer.toString(cur.val);
            if (cur.next != null) {
                s += "->";
            }
            cur = cur.next;
        }
        return s;
    }


    public static void main(String[] args) {
        Q143_Reorder_List s = new Q143_Reorder_List();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        //ListNode resultRecursion = s.reverseList2(node1);
        ListNode result = s.reorderList(node1);

        //System.out.println(s.printList(resultRecursion));
        System.out.println(s.printList(result));
    }
}
