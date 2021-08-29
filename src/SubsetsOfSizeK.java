import java.util.ArrayList;
import java.util.List;

/*
640. All Subsets of Size K  laicode
Given a set of characters represented by a String,
return a list containing all subsets of the characters whose size is K.

Assumptions

There are no duplicate characters in the original set.

​Examples

Set = "abc", K = 2, all the subsets are [“ab”, “ac”, “bc”].

Set = "", K = 0, all the subsets are [""].

Set = "", K = 1, all the subsets are [].
 */
public class SubsetsOfSizeK {
    public List<String> subSetsOfSizeK(String set, int k){
        List<String> result = new ArrayList<String>();
        if (set == null){
            return result;
        }
        char[] array = set.toCharArray();
        //record the current subset
        StringBuilder sb = new StringBuilder();
        helper(array, k, sb, 0, result);
        return result;
    }
    //at each level, determine the character at the position "index" to be picked or not
    private void helper(char[] array, int k, StringBuilder sb, int index, List<String> result){
        //termination condition:
        //when we haved picked k elements, we add the subset to the result and return
        if (sb.length() == k){
            result.add(sb.toString());
            return;
        }
        //when we finishes determining for all the characters pick or not, we must return
        if (index == array.length){
            return;
        }
        //1. not pick the character at index
        helper(array, k, sb, index + 1, result);
        //2.pick the character at index
        sb.append(array[index]);
        helper(array, k, sb, index + 1, result);
        //remember to remove the added character when back tracking to the previous level
        sb.deleteCharAt(sb.length() - 1);

    }

    public static void main(String[] args){
        SubsetsOfSizeK s  = new SubsetsOfSizeK();
        String a = "abc";
        int k = 2;
        List<String> result = s.subSetsOfSizeK(a,k);
        System.out.println(result);
    }
}
