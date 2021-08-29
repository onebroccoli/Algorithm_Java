import java.util.Deque;
import java.util.LinkedList;

/*
laicode 198. Largest Rectangle In Histogram
leetcode 84. Largest Rectangle in Histogram

Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.



Example 1:


Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:


Input: heights = [2,4]
Output: 4


Constraints:

1 <= heights.length <= 105
0 <= heights[i] <= 104
 */
/*
Assumption: array is not null, array.length >=1
all the value in the array are non-negative

 */
public class Q84_Largest_Rectangle_in_Histogram {
    public int largestRectangleArea(int[] array){
        int result = 0;
        //stack contains the index not the value of array
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i <= array.length; i++){
            //we need a way of popping out all the elements in the stack
            //at last, so that we explicitly add a bar of height 0
            int cur = i == array.length ? 0: array[i];
            while (!stack.isEmpty() && array[stack.peekFirst()] >= cur){ //when the height drops
                int height = array[stack.pollFirst()]; //right boundary of height determined
                //determine the left boundary of the largest rectangle with height array[i]
                int left = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
                result = Math.max(result, height * (i - left));
            }
            stack.offerFirst(i);
        }
        return result;
    }



    public static void main(String[] args){
        Q84_Largest_Rectangle_in_Histogram s = new Q84_Largest_Rectangle_in_Histogram();
        int[] heights = {2,1,3,3,4};
        int result = s.largestRectangleArea(heights);
        System.out.println(result);
    }
}
