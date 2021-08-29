/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.



Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section)
is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9

Example3: Laicode
{ 2, 1, 3, 2, 4 }, the amount of water can be trapped is 1 + 1 = 2
(at index 1, 1 unit of water can be trapped and index 3, 1 unit of water can be trapped)


Constraints:

n == height.length
0 <= n <= 3 * 104
0 <= height[i] <= 105
 */



/*
        0 1 2 3 4  5
            l   r
        4 2 0 6 2  5
round1: lmax = 4, rmax = 5, left[0] = 4, right[5] = 5, 4<5, result = 0+(4-4) = 0, lmax = 4, left++[1],
round2: lmax = 4, rmax = 5, left[1] = 2, right[5] = 5, 2<5, result = 0+(4-2) = 2, lmax = 4, left++[2]
round3: lmax = 4, rmax = 5, left[2] = 0, right[5] = 5, 0<5, result = 2+(4-0) = 6, lmax = 4, left++[3]
round4: lmax = 4, rmax = 5, left[3] = 6, right[5] = 5, 6>5, result = 6+0     = 6, rmax = 5, right--[4]
round5: lmax = 4, rmax = 5, left[3] = 6, right[4] = 2, 6>2, result = 6+(5-2) = 9, rmax = 5, right--[3]
 */

public class Q42_Trapping_Rain_Water {
    public int maxTrapped(int[] array){
        if (array == null || array.length == 0){
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        int leftMax = array[left];
        int rightMax = array[right];
        int result = 0;
        while (left < right){
            if (array[left] <= array[right]){
                result += Math.max(0, leftMax - array[left]); //算出leftMax跟当前柱子的差值就是存水量，result加上
                leftMax = Math.max(leftMax, array[left]); //update leftMax
                left++;
            } else {
                result += Math.max(0, rightMax - array[right]);
                rightMax = Math.max(rightMax, array[right]);
                right--;
            }

        }
        return result;
    }
    public static void main(String[] args){
        Q42_Trapping_Rain_Water s = new Q42_Trapping_Rain_Water();
        int[] array = {4,2,0,3,2,5};
        int result = s.maxTrapped(array);
        System.out.println(result);
    }
}
