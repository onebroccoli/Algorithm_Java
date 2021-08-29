/*
117. Array Deduplication III
Given a sorted integer array, remove duplicate elements.
For each group of elements with the same value do not keep
any of them. Do this in-place, using the left side of the
original array and and maintain the relative order of the
elements of the array. Return the array after deduplication.

Assumptions

The given array is not null
Examples

{1, 2, 2, 3, 3, 3} → {1 2 3}
 */

import java.util.Arrays;

public class ArrayDeduplication3_Unsorted {
    public int[] dedup(int[] array){
        //assumption: array is not null
        if (array == null || array.length <= 1){
            return array;
        }

        //use flag to see if there is any duplicates of array[slow]
        boolean flag = false;
        int slow = 0;
        for (int fast = 1; fast < array.length; fast++){
            //case 1: if there is duplicate, set flag and do nothing
            if (array[fast] == array[slow]){
                flag = true;
                //array[fast] != array[slow]
                //case2.1 flag = true: fast 走到了终于不重复的值
            } else if (flag == true){
                array[slow] = array[fast];
                //reset flag to false since we start processing another element
                flag = false;
            } else {
                //case2.2 flag = false
                //if array[fast] != array[slow] && flag is not set
                // means there is no duplicate of array[slow] and
                // should be included in the valid subarray
                array[++slow] = array[fast];
            }
        }
        return Arrays.copyOfRange(array, 0, flag ? slow : slow + 1);
    }

    //{1 2 2 2 1 3 3} ==> {1 1 3}


    public static void main(String[] args) {
        ArrayDeduplication3_Unsorted s = new ArrayDeduplication3_Unsorted();
        int[] a = {1, 2, 2, 2, 1, 3, 3};
        int[] result = s.dedup(a);
        for (int i : result) {
            System.out.println(i);
        }

    }
}
