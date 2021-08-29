import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Laicode 641. All Subsets II of Size K
Set = "abc", K = 2, all the subsets are [“ab”, “ac”, “bc”].

Set = "abb", K = 2, all the subsets are [“ab”, “bb”].

Set = "abab", K = 2, all the subsets are [“aa”, “ab”, “bb”].

Set = "", K = 0, all the subsets are [""].

Set = "", K = 1, all the subsets are [].

Set = null, K = 0, all the subsets are [].
 */
public class SubsetsOfSizeKWithDuplicates {
    public List<String> subSetsIIOfSizeK(String set, int k){
        List<String> result = new ArrayList<String>();
        if (set == null){
            return result;
        }
        char[] arraySet = set.toCharArray();
        //Make sure the multi-set is sorted so we can dedup
        Arrays.sort(arraySet);
        StringBuilder sb = new StringBuilder();
        helper(arraySet, k, sb, 0, result);
        return result;
    }

    //index: at current level, determine if
    // the element at "index" should be included in the subset or not.
    private void helper(char[] set, int k, StringBuilder sb, int index, List<String> result){
        //termination condition
        if (sb.length() == k){
            result.add(sb.toString());
            return;
        }
        if (index == set.length){
            return;
        }
        helper(set, k, sb.append(set[index]), index + 1, result);
        sb.deleteCharAt(sb.length() - 1);
        //skip all the consecutive and duplicate elements
        while (index < set.length - 1 && set[index] == set[index + 1]){
            index++;
        }
        helper(set, k, sb, index + 1, result);
    }

    public static void main(String[] args){
        SubsetsOfSizeKWithDuplicates s = new SubsetsOfSizeKWithDuplicates();
        String set = "qbbc";
        int k = 2;
        List<String> result = s.subSetsIIOfSizeK(set, k);
        System.out.println(result);
    }
}
