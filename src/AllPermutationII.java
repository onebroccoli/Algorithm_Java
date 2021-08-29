import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given a string with possible duplicate characters,
return a list with all permutations of the characters.

Examples

Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
Set = "aba", all permutations are ["aab", "aba", "baa"]
Set = "", all permutations are [""]
Set = null, all permutations are []
 */

/*
Time O(N!): time complexity for all the nodes in the recursion tree, O(N!)
Space O(N^2): sum of space for all the nodes in one route in the recursion tree, root space: O(length), O(length-1)..... O(N^2)


 */
public class AllPermutationII {
    public List<String> permutations(String input){
        List<String> result = new ArrayList<String>();
        if (input == null){
            return result;
        }
        char[] array = input.toCharArray();//convert the string to array
        helper(array, 0, result);
        return result;
    }

    private void helper(char[] array, int index, List<String> result){
        if (index == array.length){ //when index reach the end of array, add to result
            result.add(new String(array)); //if it's number, then add(new ArrayList<>(array))
            return;
        }
        //the rule is just for current level, if certain element is picked,
        //cannot pick any of its duplicates
        //so we use a set to record all the distinct elements
        Set<Character> used = new HashSet<Character>();
        for (int i = index; i < array.length; i++){
            //user.add(array[i] will return false
            //if the value of array[i] is already in the set)
            if (used.add(array[i])){
                swap(array, i, index);
                //go for next level, index + 1;
                helper(array, index + 1, result);
                swap(array, index, i); //don't forget to do clear operation when backtracking
            }
        }
    }
    private void swap(char[] array, int left, int right){
        char tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    public static void main(String[] args){
        AllPermutationII s = new AllPermutationII();
        String a = "aba";
        List<String> res = s.permutations(a);
        System.out.println(res);

    }
}
