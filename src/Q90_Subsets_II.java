/*
Given an integer array nums that may contain duplicates,
return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.



Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]


Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
String version:
Given a set of characters represented by a String, return a list containing all subsets of the characters. Notice that each subset returned will be sorted to remove the sequence.

Assumptions

There could be duplicate characters in the original set.
​Examples

Set = "abc", all the subsets are ["", "a", "ab", "abc", "ac", "b", "bc", "c"]
Set = "abb", all the subsets are ["", "a", "ab", "abb", "b", "bb"]
Set = "abab", all the subsets are ["", "a", "aa","aab", "aabb", "ab","abb","b", "bb"]
Set = "", all the subsets are [""]
Set = null, all the subsets are []

 */
public class Q90_Subsets_II {
    public List<String> subSets(String set) {
        List<String> result = new ArrayList<String>();
        if (set == null){
            return result;
        }
        char[] array = set.toCharArray();
        //make sure the multi-set is sorted so that we can deduplicate.
        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();
        helper(array, sb, 0, result);
        return result;
    }

    //index: at current level, determine if the element at "index" should be included in the subset or not
    private void helper(char[] array, StringBuilder sb, int index, List<String> result){
        if (index == array.length){
            result.add(sb.toString());
            return;
        }
        //case1: add the character
        sb.append(array[index]);
        helper(array, sb, index + 1, result);
        sb.deleteCharAt(sb.length() - 1);

        //case2: not add when duplicates
        //skip all the consecutive and duplicate elements
        while (index < array.length - 1 && array[index] == array[index + 1]){
            index ++;
        }
        helper(array, sb, index + 1, result);
    }

    public static void main(String[] args){
        Q90_Subsets_II s = new Q90_Subsets_II();
        String a = "abbac";
        List<String> result = s.subSets(a);
        System.out.println(result);
    }
}
