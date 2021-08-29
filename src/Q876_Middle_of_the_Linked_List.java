/*
Given a non-empty, singly linked list with head node head,
return a middle node of linked list.

If there are two middle nodes, return the second middle node.



Example 1:

Input: [1,2,3,4,5]
slow 1 2
fast 2 4 .next.next ==null: slow.next is median

Output: Node 3 from this list (Serialization: [3,4,5])
The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
Note that we returned a ListNode object ans, such that:
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
Example 2:

Input: [1,2,3,4,5,6]
slow 1 2 3
fast 2 4 6  6.next == null slow and slow.next are median, return slow.next
Output: Node 4 from this list (Serialization: [4,5,6])
Since the list has two middle nodes with values 3 and 4, we return the second one.


Note:

The number of nodes in the given list will be between 1 and 100.
 */

/*
//         [1,2,3,4,5] odd
//         slow: 1 2 3
//         fast: 1 3 5 - break
//         return 3

//         [1,2,3,4,5,6] even, 需要返回4， 查找
//         slow: 1 2 3 4
//         fast: 1 3 5 null-break
When traversing the list with a pointer slow,
make another pointer fast that traverses twice as fast.
When fast reaches the end of the list, slow must be in the middle.
Time: O(N) which is number of nodes in the list
Space O(1) space used by slow and fast pointer
 */
public class Q876_Middle_of_the_Linked_List {
    public ListNode middleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        //during even list, need to return the second half, so not use fast.next != null & fast.next.next != null
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

    public String printList(ListNode head) {
        ListNode cur = head;
        String s = "";
        while(cur != null){
            s += Integer.toString(cur.val);
            if(cur.next != null){
                s+= "->";
            }
            cur = cur.next;
        }
        return s;
    }
//    public static void main(String[] args) {
//        Q876_Middle_of_the_Linked_List s = new Q876_Middle_of_the_Linked_List();
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        //ListNode resultRecursion = s.reverseList2(node1);
//        ListNode result = s.middleNode(node1);
//        System.out.println(s.printList(result));
//    }

    public static void main(String[] args) {
        Q876_Middle_of_the_Linked_List s = new Q876_Middle_of_the_Linked_List();
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
        ListNode result = s.middleNode(node1);
        System.out.println(s.printList(result));
    }
}
