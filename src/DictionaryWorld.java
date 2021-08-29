import java.util.HashSet;
import java.util.Set;

/*
Given a word and a dictionary, determine if
it can be composed by concatenating words from the given dictionary.

Assumptions

The given word is not null and is not empty
The given dictionary is not null and is not empty
and all the words in the dictionary are not null or empty
Examples

Dictionary: {“bob”, “cat”, “rob”}

Word: “robob” return false

Word: “robcatbob” return true since it can be composed by
"rob", "cat", "bob"
 */

/*
Solution:
Input is not null or empty
dict is not null and dict is not empty
all the strings in dict are not null or empty
M[i] : index (i - 1) in input, also can represent the substring (0, i);
 */
public class DictionaryWorld {
    public boolean canBreak(String input, String[] dict) {
        Set<String> dictSet = toSet(dict);
        boolean[] M = new boolean[input.length() + 1];
        M[0] = true;
        for (int i = 1; i < M.length; i++){ //i: 1 letter to length(n) letter

            for (int j = 0; j < i; j++){ //j: left big secion
//                System.out.println("i: " + i);
//                System.out.println("j: " + j);
//                System.out.println();
//                System.out.println("dictionary contain: "+ input.substring(j, i) + " ? " );
//                System.out.print(dictSet.contains(input.substring(j, i)));

                //check the subproblem and the rest of the word
                if (M[j] && dictSet.contains(input.substring(j, i))){
                    //substring begins at index j and extrnds to index i - 1
                    M[i] = true;
                    break;
                }
            }
        }
        return M[input.length()];
    }

    private Set<String> toSet(String[] input){
        Set<String> set = new HashSet<>();
        for (String s : input){
            set.add(s);
        }
        return set;
    }
    public static void main(String[] args){
        DictionaryWorld s = new DictionaryWorld();
        String a = "robeobapple";
        String[] dict = {"rob","bob","apple"};
        boolean result = s.canBreak(a, dict);


//        String b = "rob";
//        String[] dict = {"rob","bob","apple"};
//        boolean result = s.canBreak(b, dict);
        System.out.println(result);

    }



}
