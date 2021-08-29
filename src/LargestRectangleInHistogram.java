import java.util.Deque;
import java.util.LinkedList;

/*
198. Largest Rectangle In Histogram
Given a non-negative integer array representing the
heights of a list of adjacent bars. Suppose each bar
has a width of 1. Find the largest rectangular area
that can be formed in the histogram.

Assumptions

The given array is not null or empty

Examples

{ 2, 1, 3, 3, 4 }, the largest rectangle area is 3 * 3 = 9
(starting from index 2 and ending at index 4)
 */

/*
TC: O(2n)
 */
public class LargestRectangleInHistogram {
    public int largest(int[] array) {
        //Assumption: array is not null, array.length >= 1
        //all the values in the array are non-negative
        int result = 0;
        //note that the stack contains the "index"
        //not the value of the array
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i <= array.length; i++){
            //we need a way of popping out all the elements in the stack
            //at last, so that we explicitly add a bar of height 0
            int cur = i == array.length ? 0 : array[i];
            while (!stack.isEmpty() && array[stack.peekFirst()] >= cur){ //when the height drops
                int height = array[stack.pollFirst()]; //right boundary of height determined
                //determine the left boundary of the largest rectangle
                //with height array[i]
                int left = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
                //determine the right boundry of the rectangle
                //with height of the popped element
                result = Math.max(result, height * (i - left));

            }
            stack.offerFirst(i);
        }
        return result;
    }

    public static void main(String[] args){
        LargestRectangleInHistogram s = new LargestRectangleInHistogram();
        int[] a = {1,3,4,5,2,5};
        int res = s.largest(a);
        System.out.println(res);
    }
}
