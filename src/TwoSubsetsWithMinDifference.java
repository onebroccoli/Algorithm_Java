/*
263. Two Subsets With Min Difference
Given a set of n integers, divide the set in two subsets of n/2
sizes each such that the difference of the sum of two subsets is as minimum as possible.

Return the minimum difference(absolute value).

Assumptions:

The given integer array is not null and it has length of >= 2.
Examples:

{1, 3, 2} can be divided into {1, 2} and {3}, the minimum difference is 0
 */

/*
Solution:
use globalMin, and a boolean array to keep track of which number is used
count the numbers used and update the curSum
when the numbers taken is array.length/2, stop
compare curSum, and totalSum - curSum,
the abs value of the difference between them is compared with globalMin
We are looking for curSum that is closest to totalSum/2

 */
public class TwoSubsetsWithMinDifference {
    public int minDifference(int[] array){
        int n = array.length;
        if (n == 2) {
            return Math.abs(array[0] - array[1]);
        }
        int totalSum = countSum(array);
        System.out.println(Integer.toString(totalSum));
        int[] minDiff = {Integer.MAX_VALUE};
        helper(array, totalSum, minDiff, 0, 0, 0);
        return minDiff[0];
    }
    private void helper(int[] array, int totalSum, int[] minDiff, int index, int count, int curSum){
        //terminate condition
        if (count == array.length / 2){
            minDiff[0] = Math.min(minDiff[0], Math.abs(curSum - (totalSum - curSum)));
            return;
        }
        if (index == array.length){
            return;
        }
        System.out.println("curSum = "+ Integer.toString(curSum) + "+ array[index] = " + Integer.toString(array[index]) +" = " + Integer.toString(curSum + array[index]));
        helper(array, totalSum, minDiff, index + 1, count + 1, curSum + array[index]);
        helper(array, totalSum, minDiff, index + 1, count, curSum);

    }
    /*
    tree:
    {1, 2, 3, 4} -- 0

     */

    public static void main(String[] args){
        TwoSubsetsWithMinDifference s = new TwoSubsetsWithMinDifference();
        int[] target = {1, 3, 2,4};
        int result = s.minDifference(target);
        System.out.println(result);
    }


    private int countSum(int[] array){
        int sum = 0;
        for (int x : array){
            sum += x;
        }
        return sum;
    }
}
