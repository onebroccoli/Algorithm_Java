import java.util.Arrays;

/*
Given a sorted integer array, remove duplicate elements.
For each group of elements with the same value keep only one of them.
Do this in-place, using the left side of the original array and
maintain the relative order of the elements of the array.
Return the array after deduplication.

Assumptions

The array is not null
Examples

{1, 2, 2, 3, 3, 3} → {1, 2, 3}
 */
public class ArrayDeduplication1_Sorted {
    public int[] dedup(int[] array){
        //assumption: array is not null
        if (array.length <= 1){
            return array;
        }
        //slow pointer: [0, slow-1] are elements that are processed and should be kept
        //fast pointer: index of elements that is being processed
        int slow = 1;
        for (int fast = 1; fast < array.length; fast++){
            if (array[fast] != array[slow - 1]) {
                array[slow] = array[fast];
                slow++;
            }
        }
        return Arrays.copyOfRange(array, 0, slow);
    }

    public static void main(String[] args){
        ArrayDeduplication1_Sorted s = new ArrayDeduplication1_Sorted();
        int[] a =  {1,1,2,3};
        int[] result = s.dedup(a);
        for (int i : result){
            System.out.println(i);
        }

    }
}
