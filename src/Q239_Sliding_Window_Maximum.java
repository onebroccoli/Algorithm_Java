import java.util.*;

/*
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.



Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]
Example 3:

Input: nums = [1,-1], k = 1
Output: [1,-1]
Example 4:

Input: nums = [9,11], k = 2
Output: [11]
Example 5:

Input: nums = [4,-2], k = 2
Output: [4]


Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length
 */
/*

 */
public class Q239_Sliding_Window_Maximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //assumption: array is not null or not empty
        //k >= 1 and k <= a.length
        int[] result = new int[nums.length - k + 1];
//        List<Integer> max = new ArrayList<Integer>();

        //use a descending deque to solve the problem
        //store the index instead of the actual value in the deque
        //make sure:
        //1. deque only contains index in the current sliding window
        //2. for any index, the previous index with smaller value is discarded from the deque
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            //discard any index with smaller value than index i

            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                int b = nums[deque.peekLast()];
                deque.pollLast();
            }
            ;

            //it is possible the head element is out of current sliding window
            //so we might need to discard it as well
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            deque.offerLast(i);
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
//                max.add(nums[deque.peekFirst()]);
            }
        }
        return result;
    }
//    public List<Integer> maxSlidingWindow(int[] nums, int k) {
//        //assumption: array is not null or not empty
//        //k >= 1 and k <= a.length
//        List<Integer> max = new ArrayList<Integer>();
//        //use a descending deque to solve the problem
//        //store the index instead of the actual value in the deque
//        //make sure:
//        //1. deque only contains index in the current sliding window
//        //2. for any index, the previous index with smaller value is discarded from the deque
//        Deque<Integer> deque = new LinkedList<Integer>();
//        for (int i = 0; i < nums.length; i++) {
//            //discard any index with smaller value than index i
//            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
//                deque.pollLast();
//            }
//            ;
//
//            //it is possible the head element is out of current sliding window
//            //so we might need to discard it as well
//            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
//                deque.pollFirst();
//            }
//            deque.offerLast(i);
//            if (i >= k - 1) {
//                max.add(nums[deque.peekFirst()]);
//            }
//        }
//        return max;
//    }

    public static void main(String[] args){
        Q239_Sliding_Window_Maximum s = new Q239_Sliding_Window_Maximum();
        int[] array =  {1, 2, 3, 2, 4, 2, 1};
        int k = 3;
        int[] result = s.maxSlidingWindow(array,k);
//        List<Integer> result = s.maxSlidingWindow(array, k );
        System.out.println(Arrays.toString(result));
    }
}
