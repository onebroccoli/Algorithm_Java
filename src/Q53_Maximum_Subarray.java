/*
Given an unsorted integer array, find the subarray
that has the greatest sum. Return the sum.

Assumptions

The given array is not null and has length of at least 1.
Examples

{2, -1, 4, -2, 1}, the largest subarray sum is 2 + (-1) + 4 = 5

{-2, -1, -3}, the largest subarray sum is -1
 */

public class Q53_Maximum_Subarray {
    public int maxSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        //subarray must contain at least one element
        int result = array[0];
        int cur = array[0];
        //dp[i] means the largest sum of subarray ending at index i
        //dp[i - 1] <= 0 :  dp[i] = array[i]
        //dp[i-1] > 0    :  dp[i] = dp[i-1] + array[i]
        for (int i = 1; i < array.length; i++) {
            cur = Math.max(cur + array[i], array[i]);
            result = Math.max(result, cur);
        }
        return result;
    }
}