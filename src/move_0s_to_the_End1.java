/*
Given an array of integers, move all the 0s to the right end of the array.

The relative order of the elements in the original array does not need to be maintained.

Assumptions:

The given array is not null.
Examples:

{1} --> {1}
{1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0} or {1, 1, 3, 0, 0} or {3, 1, 1, 0, 0}
 */

import java.util.Arrays;

/*
use 2 pointers
slow: left of the slow pointer is the processed elements
right of slow including slow needs to be set to 0

 */
public class
move_0s_to_the_End1 {
    public int[] moveZero(int[] array){
        int slow = 0;
        for (int fast = 0; fast < array.length; fast++){
            if (array[fast] != 0){
                array[slow] = array[fast];
                slow++;
            }
        }
        for (int i = slow; i < array.length; i++){
            array[i] = 0;
        }
        return array;
    }

    public static void main(String[] args){
        move_0s_to_the_End1 s = new move_0s_to_the_End1();
        int[] array = {1,0,2,0,3,4};
        int[] result = s.moveZero(array);
        System.out.println(Arrays.toString(result));
    }
}
