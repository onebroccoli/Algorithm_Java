/*
Let's call an array arr a mountain if the following properties hold:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... arr[i-1] < arr[i]
arr[i] > arr[i+1] > ... > arr[arr.length - 1]
Given an integer array arr that is guaranteed to be a mountain,
return any i such that arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].



Example 1:

Input: arr = [0,1,0]
Output: 1
Example 2:

Input: arr = [0,2,1,0]
Output: 1
Example 3:

Input: arr = [0,10,5,2]
Output: 1
Example 4:

Input: arr = [3,4,5,1]
Output: 2
Example 5:

Input: arr = [24,69,100,99,79,78,67,36,26,19]
Output: 2


Constraints:

3 <= arr.length <= 104
0 <= arr[i] <= 106
arr is guaranteed to be a mountain array.


Follow up: Finding the O(n) is straightforward, could you find an O(log(n)) solution?
 */


/*
Solution:
the comparison A[i] < A[i+1] in a mountain array ooks like
[T,T,T,....False,False, False....]
1 or more boolean True, followed by 1 or more boolean False.
For example: the mountain array [1,2,3,4,1] ,
the comparisons A[i] < A[i + 1] would be [T,T,T,F]
we can binary search over this array of comparisons,
to find the largest index such that A[i] < A[i+1]

Time: O(logN), N is the length of array
Space: O(1)
 */
public class Q852_Peak_Index_in_a_Mountain_Array {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid + 1]){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
