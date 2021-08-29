import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
25. K Smallest In Unsorted Array laicode
Find the K smallest numbers in an unsorted integer array A. The returned numbers should be in ascending order.

Assumptions

A is not null
K is >= 0 and smaller than or equal to size of A
Return

an array with size K containing the K smallest numbers in ascending order
Examples

A = {3, 4, 1, 2, 5}, K = 3, the 3 smallest numbers are {1, 2, 3}

 */
public class K_Smallest_In_Unsorted_Array {
    public int[] KSmallest(int[] array, int k) {
        //use max heap, maintain k heap , if larger than heap.pop(), then do nothing, if smaller , pop
        if (array.length == 0 || k == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                //do not use "==" here!
                if (o1.equals(o2)) {
                    return 0;
                }
                return o1 > o2 ? -1 : 1;
            }
        });
        for (int i = 0; i < array.length; i++) {
            if (i < k) {
                //offer the first k elements into max heap
                //NOTICE: if you want to utilize heapify(),
                //the only thing you can do is to call a certain constructor of PriorityQueue.
                maxHeap.offer(array[i]);
            } else if (array[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(array[i]);
            }
        }
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = maxHeap.poll();
        }
        return result;
    }
    public static void main(String[] args){
        K_Smallest_In_Unsorted_Array s = new K_Smallest_In_Unsorted_Array();
        int[] array = {1,4,2,5,7,8,0,-1};
        int target = 3;
        int[] result = s.KSmallest(array, target);
        System.out.println(Arrays.toString(result));
    }
}
