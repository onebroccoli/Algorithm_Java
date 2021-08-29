/*
Given a positive integer num, write a function which returns
True if num is a perfect square else False.

Follow up: Do not use any built-in library function such as sqrt.



Example 1:

Input: num = 16
Output: true
Example 2:

Input: num = 14
Output: false


Constraints:

1 <= num <= 2^31 - 1
 */

/*Solution:
For num > 2 the square root aa is always less than num/2 and greater than 1
Since x is an integer, the problem goes down to the search in the sorted set of integer numbers.
Binary search is a standard way to proceed in such a situation.
Algorithm

If num < 2, return True.

Set the left boundary to 2, and the right boundary to num / 2.

While left <= right:

Take x = (left + right) / 2 as a guess. Compute guess_squared = x * x and compare it with num:

If guess_squared == num, then the perfect square is right here, return True.

If guess_squared > num, move the right boundary right = x - 1.

Otherwise, move the left boundary left = x + 1.

If we're here, the number is not a prefect square. Return False.

*/
public class Q367_Valid_Perfect_Square {
    public boolean isPerfectSquare(int num) {
        if (num < 2){
            return true;
        }
        long left = 2; //这边要加long
        long right = num / 2;
        while (left <= right){
            long mid = left + (right - left) / 2;
            if (mid * mid == num){
                return true;
            } else if (mid * mid < num){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;


    }

}
