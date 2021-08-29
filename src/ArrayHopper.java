/*
Given an array A of non-negative integers, you are initially
positioned at index 0 of the array. A[i] means the maximum jump
distance from that position (you can only jump towards the end
of the array). Determine if you are able to reach the last index.

Assumptions

The given array is not null and has length of at least 1.
Examples

{1, 3, 2, 0, 3}, we are able to reach the end of array(jump to
index 1 then reach the end of the array)

{2, 1, 1, 0, 2}, we are not able to reach the end of array
 */
public class ArrayHopper {
    public boolean canJump(int[] array){
        if (array.length == 1){ //assumption: array is not null and is not empty
            return true;
        }
        boolean[] M = new boolean[array.length];
        for (int i = array.length - 2; i >= 0; i--){
            //if from index i, it is already possible to jum to the end of the array
            if (i + array[i] >= array.length - 1){
                M[i] = true;
            } else {
                //if any of the reachable indices from index i is reachable to the end of the array
                for (int j = array[i]; j >= 1; j--){
                    if (M[j + i]) {
                        M[i] = true;
                        break;
                    }
                }
            }
        }
        return M[0];


    }

    public static void main(String[] args){
        ArrayHopper s = new ArrayHopper();
        int[] input = {1,2,1,0,5};
        boolean result = s.canJump(input);
        System.out.println(result);
    }
}
