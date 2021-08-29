import java.util.Arrays;

/*
laicode 116. Array Deduplication II
Given a sorted integer array, remove duplicate elements.
For each group of elements with the same value keep at most
two of them. Do this in-place, using the left side of the
original array and maintain the relative order of the elements of the array.
Return the array after deduplication.


Assumptions

The given array is not null
Examples

{1, 2, 2, 3, 3, 3} → {1, 2, 2, 3, 3}


 */
public class ArrayDeduplication2_Sorted_k {
    public int[] dedup(int[] array) {
        //slow: [0, slow - 1] elements that are processed and should be kept
        //fast: index of element being processed
        //s = 2, f = 2
        //case1: a[f] == a[s-2]. f++
        if (array.length <= 2){
            return array;
        }
        int slow = 2;
        for (int fast = 2; fast < array.length; fast++){
            if (array[fast] == array[slow - 2]){
                continue;
            }
            array[slow] = array[fast];
            slow++;
        }
        return Arrays.copyOfRange(array, 0, slow);
    }

    public static void main(String[] args) {
        ArrayDeduplication2_Sorted_k s = new ArrayDeduplication2_Sorted_k();
        int[] a = {1, 2, 2, 2, 3};
        int[] result = s.dedup(a);
        for (int i : result) {
            System.out.println(i);
        }

    }
}
