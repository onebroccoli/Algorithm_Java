/*
Given a sorted array of distinct integers and a target value,
return the index if the target is found.
If not, return the index where it would be if it were inserted in order.



Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4
Example 4:

Input: nums = [1,3,5,6], target = 0
Output: 0
Example 5:

Input: nums = [1], target = 0
Output: 0


Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104
 */
/*
Solution:
1. initialize the left and right pointers
2. compare the middle element of the array to the target value
    * if the same, return mid
    *if target is not here:
        - if target < nums[mid], continue to search on the left subarray, right = mid - 1
        - else continue to search on the right subarray, left = mid + 1
 */


public class Q35_Search_Insert_Position {
    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length ==0){
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}


