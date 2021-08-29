
/*
Given a non-negative integer x, compute and return the square root of x.
Since the return type is an integer, the decimal digits are truncated,
and only the integer part of the result is returned.


Example 1:

Input: x = 4
Output: 2
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.


Constraints:

0 <= x <= 231 - 1

*/

/*
solution: start from 4, the sqrt of a number is always larger or equals to itself divided by 2
so we start from 2 and 2/n and do binary search to find the mid number that the square of it is closest to x

Time: O(logn)
Space: O(1)
*/


public class Q69_Sqrtx {
    public int mySqrt(int x) {
        //corner case 0 跟1 返回本值
        if (x < 2) return x;
        long num;
        int left = 2, right = x / 2;
        while (left <= right){
            int mid = left + (right - left) / 2;
            num = (long)mid * mid;
            if (num == x){
                return mid;
            } else if (num > x){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}

