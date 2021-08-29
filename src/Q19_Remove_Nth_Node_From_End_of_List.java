/*
Given the head of a linked list, remove the nth node from
the end of the list and return its head.

Follow up: Could you do this in one pass?



Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]


Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
 */


/*
Solution:
Two pass:
先遍历find length, 然后找到该node进行skip操作

One pass:
two pointer, fast and slow with gap n , fast 是slow的n+ 1
等到fast.next = null时， slow就处于指定位置，进行skip操作
 */
public class Q19_Remove_Nth_Node_From_End_of_List {
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode slow  = dummy;
//        ListNode fast = dummy;
//        //start moving the first pointer so that the gap between first and second is n nodes apart
//        for (int i = 1; i <= n + 1; i++){
//            fast = fast.next;
//        }
//        //fast pointer gets to the position, now slow pointer starts
//        while (fast != null){
//            fast = fast.next;
//            slow = slow.next;
//        }
//        //skip the node
//        slow.next = slow.next.next;
//        return dummy.next;
//    }
//

    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode slow = head;
        ListNode fast = head;
        //move fast pointer n steps ahead;
        for (int i = 0; i < n; i++){
            if (fast.next == null){
                //if n is equal to the number of nodes, delete the head node
                if (i == n - 1){ //相当于走到了头
                    head = head.next;
                }
                return head;
            }
            fast = fast.next; //否则就继续挪
        }
        //until fast reach the end
        //now move both slow and fast pointer
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        //delink the nth node from last
        if (slow.next != null){
            slow.next = slow.next.next;
        }
        return head;
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
    public static void main(String[] args) {
        Q19_Remove_Nth_Node_From_End_of_List s = new Q19_Remove_Nth_Node_From_End_of_List();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        //ListNode resultRecursion = s.reverseList2(node1);
        ListNode result = s.removeNthFromEnd(node1, 8);

        //System.out.println(s.printList(resultRecursion));
        System.out.println(s.printList(result));
    }
}
