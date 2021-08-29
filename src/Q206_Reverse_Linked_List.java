/*
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either
iteratively or recursively. Could you implement both?
 */
public class Q206_Reverse_Linked_List {
    //Method1: Iteration
    //Space: O(1)
    //Time: O(n)
    public ListNode reverseList(ListNode head){
        if (head == null || head.next == null){
            return head; //sanity check
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

    //Method2: recursion
    //Space: O(n)
    //Time: O(n)

    //1->2->3
//    newhead = head.next, 2
//    head.next.next = head; 1.next(2).next = 1
//    head.next = null
    public ListNode reverseList2(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head; //翻转指针
        head.next = null; //头.next 设为null
        return newHead;
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
    public static void main(String[] args){
        Q206_Reverse_Linked_List s = new Q206_Reverse_Linked_List();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        //ListNode resultRecursion = s.reverseList2(node1);
        ListNode resultIter = s.reverseList(node1);

        //System.out.println(s.printList(resultRecursion));
        System.out.println(s.printList(resultIter));




    }


}





