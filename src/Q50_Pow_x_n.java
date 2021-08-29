/*
Implement pow(x, n), which calculates x raised to
the power n (i.e. xn).



Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25


Constraints:

-100.0 < x < 100.0
-231 <= n <= 231-1
-104 <= xn <= 104

 */
/*
Solution:
(X^n)^2 = X^(2*n),
if A is result of X^(n/2), if n is even, X^n = A*A
if n is odd, then X^n = A * A * x
the approach can be easily implemented using recursion

Time: O(logn)
Space: O(logn) for each computation, we need to store the result of x^(n/2)
we need to do the computation for O(logn) times,
so the space complexity is O(logn)
 */
public class Q50_Pow_x_n {
    public double myPow(int x, int n){
        if (x == 0) {
            if (n <= 0) {
                return -1; //error
            } else {
                return 0;
            }
        }
        if (n >= 0){
            return fastPow(x ,n);
        } else {
            return 1 / (double)fastPow(x, -n);
        }
    }

    public double fastPow(int x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }

    }

    public static void main(String[] args){
        Q50_Pow_x_n s = new Q50_Pow_x_n();
        int a = 0;
        int b = 0;
        double result = s.myPow(a, b);
        System.out.println(result);
    }
}
