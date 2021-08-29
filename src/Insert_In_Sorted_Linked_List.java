/*
39. Insert In Sorted Linked List lai

Insert a value in a sorted linked list.

Examples

L = null, insert 1, return 1 -> null
L = 1 -> 3 -> 5 -> null, insert 2, return 1 -> 2 -> 3 -> 5 -> null
L = 1 -> 3 -> 5 -> null, insert 3, return 1 -> 3 -> 3 -> 5 -> null
L = 2 -> 3 -> null, insert 1, return 1 -> 2 -> 3 -> null

 */
public class Insert_In_Sorted_Linked_List {
public ListNode insert(ListNode head, int value) {
    ListNode newNode = new ListNode(value);
    //1. determine if inserted node is before head;
    if (head == null || head.val >= value){
        newNode.next = head;
        return newNode;
    }
    //2. insert new node to the right position
    //use previous node to traverse the linked list
    //the inserted position should be betwen prev and prev.next
    ListNode prev = head;
    while (prev.next != null && prev.next.val < value){
        prev = prev.next;
    }
    newNode.next = prev.next;
    prev.next = newNode;
    return head;
}
}
