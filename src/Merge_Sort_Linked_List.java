/*
29. Merge Sort Linked List laicode
Given a singly-linked list, where each node contains an integer value, sort it in ascending order. The merge sort algorithm should be used to solve this problem.

Examples

null, is sorted to null
1 -> null, is sorted to 1 -> null
1 -> 2 -> 3 -> null, is sorted to 1 -> 2 -> 3 -> null
4 -> 2 -> 6 -> -3 -> 5 -> null, is sorted to -3 -> 2 -> 4 -> 5 -> 6
 */
public class Merge_Sort_Linked_List {
    public ListNode mergeSort(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        //split the list into two halves
        ListNode middle = findMiddle(head);
        ListNode middleNext = middle.next;
        middle.next = null;
        //sort each half
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(middleNext);
        //combine two halves
        return merge(left, right);
    }
    private ListNode findMiddle(ListNode head){
        if (head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode one, ListNode two){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (one != null && two != null){
            if (one.val < two.val){
                cur.next = one;
                one = one.next;
            } else {
                cur.next = two;
                two = two.next;
            }
            cur = cur.next;
        }
        //link the remaining possible nodes
        if (one != null){
            cur.next = one;
        } else {
            cur.next = two;
        }
        return dummy.next;
    }
}
