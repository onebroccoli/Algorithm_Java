/*
[Longest subarray contains only 1s]

Given an array of integers that contains only 0s and 1s
and a positive integer k, you can flip at most k 0s to 1s,
return the longest subarray that contains only integer 1 after flipping.

Assumptions:

1. Length of given array is between [1, 20000].

2. The given array only contains 1s and 0s.

3. 0 <= k <= length of given array.

Example 1:

Input: array = [1,1,0,0,1,1,1,0,0,0], k = 2

Output: 7

Explanation: flip 0s at index 2 and 3, then the array becomes
[1,1,1,1,1,1,1,0,0,0], so that the length of longest subarray
that contains only integer 1 is 7.

Example 2:

Input: array = [1,1,0,0,1,1,1,0,0,0], k = 0

Output: 3

Explanation: k is 0 so you can not flip any 0 to 1, then the length of longest subarray that contains only integer 1 is 3.


 */

/*
use two pointers fast and slow
1. if nums[fast] == 1, then fast move over +1,  update longest (max longest, fast-slow)
2. if nums[fast] == 0
    1) if count < k, means still can flip, count++, fast++, update longest
    2) if count reaches, slow++, if nums[slow++] == 0, then count--, 为fast挪到下一个0打基础
 */
public class LongestSubarrayContains1s {
    public int longestConsecutiveOnes(int[] nums, int k){
        int slow = 0;
        int fast = 0;
        int count = 0;
        int longest = 0;
        while (fast < nums.length){
            if (nums[fast] == 1){
                fast++;
                longest = Math.max(longest, fast - slow);
                continue;
            }
            if (count < k){ //nums[fast] == 0 && count < k
                count++;
                fast++;
                longest = Math.max(longest,fast - slow);
                continue;
            }
            if (nums[slow] == 0){
                count--;
            }
            slow++;
        }
        return longest;
    }

    public static void main(String[] args){
        LongestSubarrayContains1s s = new LongestSubarrayContains1s();
//        int[] a = {1,1,0,0,1,1,1,0,0,0};
//        int res = s.longestConsecutiveOnes(a, 2);

        int[] a = {0,0,1,0,0,0,1,1,1,1,0,1};
        int res = s.longestConsecutiveOnes(a, 2); //expected 7

//        int[] a = {1,1,0,0,0,1,1,1,1,1,0,1,1,1,1,0,1,0,0,0,1,0,0,0,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,1,0,1,0,0,1,1,0,1,1,0,0,1,1,0,0,1,0,0,0,0,1,0,0,0,1,0,0,1,0,1,0,1,1,1,0,0,0,1,0,1,0,1,1,1,0,0,1,1,0,1,0,1,0,0,0,0,0,0,0,0,1,0,1,1,1,0,1,1,1,1,1,0,0,1,1,1,1,1,0,0,0,1,0,1,0,0,0,0,0,0,1,1,0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,0,1,1,1,1,0,1,1,1,0,1,0,1,0,1,0,0,1,0,0,0,0,1,1,0,1,1,1,0,0,1,1,1,1,1,0,0,1,1,0,0,0,1,0,0,0,0,1,0,1,0,1,0,1,1,0,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,1,0,1,0,1,0,0,1,1,1,1,0,0,0,1,0,0,0,0,1,1,0,0,0,0,0,1,0,1,0,1,0,0,0,1,1,0,1,0};
//        int res = s.longestConsecutiveOnes(a, 62); //expected 140
//

        System.out.println(res);
    }
}
