/*
Merge two sorted linked lists and return it
as a sorted list.
The list should be made by splicing together
the nodes of the first two lists.



Example 1:


Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: l1 = [], l2 = []
Output: []
Example 3:

Input: l1 = [], l2 = [0]
Output: [0]


Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both l1 and l2 are sorted in non-decreasing order.
 */

//solution 1: recursion
//recursively define the result of a merge operation on two lists
//list1[0] + merge(list1[1:] , list2) list1[0]<list2[0]
//list2[0] + merge(list1, list2[1:]) otherwise
//time: O(m + n)
//Space: O(m + n)
public class Q21_Merge_Two_Sorted_Lists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //corner case
        if (l1 == null){
            return l2;
        } else if (l2 == null){
            return l1;
        //compare
        } else if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}

//iteration
//time O(m+n)
//Space O(1) only allocates a few pointers, so it has a constant overall memory footprint.
/*
public class Q21_Merge_Two_Sorted_Lists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode prehead = new ListNode(0);
        ListNode prev = prehead;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;

        }
        //post processing
        if (l1 != null){
            prev.next = l1;
        } else {
            prev.next = l2;
        }
        return prehead.next;
    }
    }
 */

