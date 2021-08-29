/*
Given an array nums containing n distinct numbers in the
range [0, n], return the only number in the range that
is missing from the array.

Follow up: Could you implement a solution using only
O(1) extra space complexity and O(n) runtime complexity?



Example 1:

Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
Example 2:

Input: nums = [0,1]
Output: 2
Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
Example 3:

Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
Example 4:

Input: nums = [0]
Output: 1
Explanation: n = 1 since there is 1 number, so all numbers are in the range [0,1]. 1 is the missing number in the range since it does not appear in nums.


Constraints:

n == nums.length
1 <= n <= 104
0 <= nums[i] <= n
All the numbers of nums are unique.
 */

import java.util.HashSet;

public class Q268_Missing_Number {
    //Solution 1: HashSet
    public int missingNumber1(int[] nums){
        if (nums == null || nums.length == 0){
            return -1;
        }
        int n = nums.length + 1; // expected array size
        HashSet<Integer> set = new HashSet<Integer>();
        for (int number : nums){
            set.add(number);
        }
        for (int i = 1; i < n; i++) {
            if (!set.contains(i)){
                return i;
            }
        }

        return n;
    }
    //method2: math
    public int missingNumber2(int[] nums) {
        int n = nums.length; //注意这里是[0, n] 所以是length不是length + 1
        int sum = (1 + n) * n / 2;
        for (int num : nums){
            sum -= num;
        }
        return sum;
    }

    //Method2: long, handle the overflow
   public int missingNumber2Long(int[] array){
     int n = array.length + 1;
     long targetSum = (n + 0L) * (n + 1) / 2;
     long actualSum = 0L;
     for (int num : array){
       actualSum += num;
     }
     return (int) (targetSum - actualSum);
   }


    public static void  main(String[] args){
    Q268_Missing_Number s = new Q268_Missing_Number();
    int[] a = {3,0,1};
    int[] b = {1,2,3};
    int result = s.missingNumber2(a);
    int result2 = s.missingNumber1(b);
    System.out.println("{3,0,1} solution:");
    System.out.println(result);
    System.out.println("{1,2,3} solution:");
    System.out.println(result2);


    }
}
