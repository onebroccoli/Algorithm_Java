import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an integer array nums, return all the triplets
[nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
 */
public class Q15_3sum {
    public List<List<Integer>> threeSum(int[] array, int target){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(array);
        for (int i = 0; i < array.length - 2; i++){
            if (i > 0 && array[i] == array[i - 1]){
                continue;
            }
            int left = i + 1;
            int right = array.length - 1;
            while (left < right){
                int tmp = array[left] + array[right];
                if (tmp + array[i] == target){
                    result.add(Arrays.asList(array[i], array[left], array[right]));
                    left++;
                }
                if (left < right && array[left] == array[left - 1]){
                    left++;
                } else if (tmp + array[i] < target){
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        Q15_3sum s = new Q15_3sum();
        int[] array = {1,1,2,3,4,5,6,3,5};
        int target = 11;
        List<List<Integer>> result = s.threeSum(array,target );
        System.out.println(result);
    }
}
