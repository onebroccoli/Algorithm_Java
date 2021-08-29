/*
Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
 */


public class Q203_Remove_Linked_List_Elements {
//    public ListNode removeElements(ListNode head, int val) {
//        ListNode dummyHead = new ListNode(0);
//        dummyHead.next = head;
//        ListNode prev = dummyHead;
//        ListNode cur = head;
//        while (cur != null) {
//            if (cur.val == val) {
//                prev.next = cur.next;
//
//            } else {
//                prev = cur;
//            }
//            cur = cur.next;
//        }
//        return dummyHead.next;
//    }

    public ListNode removeElements2(ListNode head, int val){
        if (head == null){
            return head;
        }
        ListNode temp= head.next;
        ListNode prev = head;
        while (temp != null){
            if (temp.val == val){
                prev.next = temp.next;
                temp = prev.next;
            } else {
                temp = temp.next;
                prev = prev.next;
            }
        }
        if (head.val == val){
            head = head.next;
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
        Q203_Remove_Linked_List_Elements s = new Q203_Remove_Linked_List_Elements();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        int target = 2;
        ListNode result = s.removeElements2(node1, target);

        System.out.println(s.printList(result));
    }
}

