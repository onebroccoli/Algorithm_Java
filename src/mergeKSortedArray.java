import java.util.Comparator;
import java.util.PriorityQueue;

/*
133. Merge K Sorted Array LAI
Merge K sorted array into one big sorted array in ascending order.

Assumptions

The input arrayOfArrays is not null, none of the arrays is null either.
 */
public class mergeKSortedArray {
    public int[] merge(int[][] arrayOfArrays) {
        //Assumptions: arrayOfArrays is not null, none of the array is null either
        PriorityQueue<Entry> minHeap = new PriorityQueue<Entry>(11, new MyComparator());
        int length = 0;
        for (int i = 0; i < arrayOfArrays.length; i++){
            int[] array = arrayOfArrays[i];
            length += array.length;
            if (array.length != 0){
                //use two index to record the position of each element
                //1. index of the array in the arrayOfArrays
                //2. index of element in the array
                minHeap.offer(new Entry(i, 0, array[0]));
            }
        }
        int[] result = new int[length];
        int cur = 0;
        while (!minHeap.isEmpty()){
            Entry tmp = minHeap.poll();
            result[cur++] = tmp.value;
            if (tmp.y + 1 < arrayOfArrays[tmp.x].length){
                //reuse the same Entry object but advance the index by 1
                tmp.y++;
                tmp.value = arrayOfArrays[tmp.x][tmp.y];
                minHeap.offer(tmp);
            }
        }
        return result;
    }

    static class MyComparator implements Comparator<Entry> {
        @Override
        public int compare(Entry e1, Entry e2){
            if (e1.value == e2.value){
                return 0;
            }
            return e1.value < e2.value ? -1: 1;
        }
    }
    static class Entry{
        //the row number
        int x;
        //the column number
        int y;
        //the corresponding value
        int value;
        Entry(int x, int y, int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
}
