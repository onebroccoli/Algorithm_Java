import java.util.Arrays;

/*
118. Array Deduplication IV

Given an unsorted integer array, remove adjacent
duplicate elements repeatedly, from left to right.
For each group of elements with the same value do not keep any of them.

Do this in-place, using the left side of the original array.
Return the array after deduplication.

Assumptions

The given array is not null
Examples

{1, 2, 3, 3, 3, 2, 2} → {1, 2, 2, 2} → {1}, return {1}
 */
/*
Solution:
using the left part of original array as stack
and top element's index is slow
if stack is empty (slow =-1)
we just push the element into the stack, or if the element
is not the same as the top element of the stack, we can push

 */

/*
Solution:
     1 2 2 2 1 3
s = -1, f =
 */
public class ArrayDeduplication4_unsorted_adjacent {
    public int[] dedup(int[] array){
        if (array == null || array.length <= 1){
            return array;
        }
        int slow = -1;
        for (int fast = 0; fast < array.length; fast++){
            if (slow == -1 || array[slow] != array[fast]){
                array[++slow] = array[fast];
            } else {
                //otherwise,  we ignore all consecutive duplicate and
                //remove the top element of the stack
                while (fast + 1 < array.length && array[fast + 1] == array[slow]){
                    fast++;
                }
                slow--; //back to the previous element in the "stack"
            }
        }
        return Arrays.copyOfRange(array, 0, slow + 1);
    }

    public static void main(String[] args) {
        ArrayDeduplication4_unsorted_adjacent s = new ArrayDeduplication4_unsorted_adjacent();
        int[] a = {1, 2, 2, 2, 1, 3}; //==> {3}
        int[] result = s.dedup(a);
        for (int i : result) {
            System.out.println(i);
        }
    }

    /*
    1 2 2 2 1 3
    slow = -1, fast = 0, array[-1+1] = array[0]
    slow = 0, fast = 1, array[0+1] = array[1]
    slow = 1, fast = 2 --> use while loop 直到fast = 4， slow--
    slow = 0, fast = 4 --> slow--
    slow = -1, fast = 5 --> array[-1 + 1] = array[5] ==>slow = 0
    return: [0, slow+1)
     */
}
