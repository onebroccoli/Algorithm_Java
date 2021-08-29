import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a set of characters represented by a String,
return a list containing all subsets of the characters.

Assumptions

There are no duplicate characters in the original set.
​Examples

Set = "abc", all the subsets are [“”, “a”, “ab”, “abc”, “ac”, “b”, “bc”, “c”]
Set = "", all the subsets are [""]
Set = null, all the subsets are []
 */
public class Q78_Subsets {
    public List<String> subsetsString(String set){
        List<String> result = new ArrayList<>();
        if (set == null){
            return result;
        }
        char[] arraySet = set.toCharArray();
        //record the current subset
        StringBuilder sb = new StringBuilder();
        helper(arraySet, sb, 0, result);
        return result;
    }

    private void helper(char[] set, StringBuilder sb, int index, List<String> result){
        //terminate condition: when finish determining for all characters pick or not, we have a complete subset
        if (index == set.length){
            result.add(sb.toString());
            return;
        }
        //no space
        sb.append(set[index]);
        helper(set, sb, index + 1, result);
        //with space
        sb.append('x');
        sb.append(set[index]);
        helper(set, sb, index + 1, result);
        sb.deleteCharAt(sb.length() - 2); //remember to remove the added character when backtracking to previous level
    }

    public List<List<Integer>> subsetsInteger(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null){
            return result;
        }
//        List<Integer> cur = new ArrayList<>();
        helperInteger(nums, new ArrayList<>(), 0, result);
        return result;
    }

    public void helperInteger(int[] nums, List<Integer> cur, int index, List<List<Integer>> result){
        if (index == nums.length){
            List<Integer> copyList = new ArrayList<>();
            // create new instance of each element of list and add to the result
            //不能直接add因为后面backtracking的时候remove后，result里只存的reference也会被清掉
            for (Integer n : cur)
            {

                copyList.add(n);
            }
            result.add(copyList);
            return;
        }
        //not pick up the int at index
        helperInteger(nums, cur, index + 1, result);

        //pick up the int at index
        cur.add(nums[index]);
        helperInteger(nums, cur, index + 1, result);
        cur.remove(cur.size() - 1);
    }

    public static void main(String[] args){
        Q78_Subsets s = new Q78_Subsets();
        String a = "abc";
        System.out.println("input is: " + a);
        List<String> result1 = s.subsetsString(a);
        System.out.println(result1);

        int[] b = {1,2,3};
        System.out.println("input is: " + Arrays.toString(b));
        List<List<Integer>> result2 = s.subsetsInteger(b);
        System.out.println(result2);


    }
}
