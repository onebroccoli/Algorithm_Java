import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
134. Merge K Sorted Lists LAI

Merge K sorted lists into one big sorted list in ascending order.

Assumptions

ListOfLists is not null, and none of the lists is null.
 */
/*
SOLUTION:
 */
//public class mergeKSortedLists {
//    public ListNode merge(List<ListNode> listOfLists){
//    //assumptions: listofLists is not null, none of the lists is null
//        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(11, new MyComparator());
//        ListNode dummy = new ListNode(0);
//        ListNode cur = dummy;
//        for (ListNode node : listOfLists){
//            if (node != null){
//                minHeap.offer(node);
//            }
//        }
//        while (!minHeap.isEmpty()){
//            cur.next = minHeap.poll();
//            if (cur.next.next != null){
//                minHeap.offer(cur.next.next);
//            }
//            cur = cur.next;
//        }
//        return dummy.next;
//
//
//    }
//    static class MyComparator implements Comparator<ListNode> {
//        @Override
//        public int compare(ListNode o1, ListNode o2){
//            if (o1.value == o2.value){
//                return 0;
//            }
//            return o1.value < o2.value ? -1 : 1;
//        }
//    }
//}
