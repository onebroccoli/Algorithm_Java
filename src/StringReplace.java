import java.util.ArrayList;

/*
Given an original string input, and two strings S and T,
from left to right replace all occurrences of S in input with T.

Assumptions

input, S and T are not null, S is not empty string
Examples

input = "appledogapple", S = "apple", T = "cat", input becomes "catdogcat"
input = "laicode", S = "code", T = "offer", input becomes "laioffer"
注意： replace的string有可能短，也有可能长！
 */
public class StringReplace {
    //Method 1: not using any String/StringBuilder utility, using char[] to do it inplace
    public String replaceI(String input, String s1, String s2){
        //Assumption: input, s1, s2 are not null, s1 is not empty
        char[] array = input.toCharArray();
        if (s1.length() >= s2.length()){
            return replaceShorter(array, s1, s2);
        }
        return replaceLonger(array, s1, s2);
    }

    //handle s1>=s2
    public String replaceShorter(char[] input, String s1, String s2){
        //we use input char array since the number of characters needed is less
        //fast and slow pointers both from left to right direction
        int slow = 0;
        int fast = 0;
        while (fast < input.length){
            //when we find a match of s1 on the substring starting from the fast pointer
            //copy the s2 at slow pointer
            if (fast <= input.length - s1.length() && equalSubstring(input, fast, s1)){
                copySubstring(input, slow, s2);
                slow += s2.length();
                fast += s1.length();
            } else {
                input[slow] = input[fast];
                slow++;
                fast++;
            }
        }
        return new String(input, 0, slow);



    }

    //handle s1<s2
    //notice: we will need a longer array in the case, and if the requirement is
    //in place, usually you can assume you are given a long enough
    //char array already, the original input string resides
    //on part of the char array starting from index 0.
    //in this solution, we actually allocate a larger array on demand, and
    //the purpose of the solution is to demonstrate how to do it in place
    public String replaceLonger(char[] input, String s1, String s2){
        //get all the matches end positions in the input char array of string s1
        ArrayList<Integer> matches = getAllMatches(input, s1);
        //calculate the new length needed
        char[] result = new char[input.length + matches.size() * (s2.length() - s1.length())];
        //fast and slow pointers both from right to left direction
        //slow: position when traversing from the new length
        //fast: position when traversing the old length
        //allocate a larger array on demand and the purpose of the solution is to demonstrate how
        // to do it in place
        int lastIndex = matches.size() - 1;
        int fast = input.length - 1;
        int slow = result.length - 1;
        while (fast >= 0){
            //only if we still have some match and slow is in the position of
            //rightmost matching end position, we should copy it
            if (lastIndex >= 0 && fast == matches.get(lastIndex)){
                copySubstring(result, slow - s2.length() + 1, s2);
                slow -= s2.length();
                fast -= s1.length();
                lastIndex--;
            } else {
                result[slow] = input[fast];
                slow--;
                fast--;
            }
        }
        return new String(result);
    }
    //check if the substring from fromIndex is the same as s1
    private boolean equalSubstring(char[] input, int fromIndex, String s){
        for (int i = 0; i < s.length(); i++){
            if (input[fromIndex + i] != s.charAt(i)){
                return false;
            }
        }
        return true;
    }

    //copy string s2 to result at fromIndex
    private void copySubstring(char[] result, int fromIndex, String s2){
        for (int i = 0; i < s2.length(); i++){
            result[fromIndex + i] = s2.charAt(i);
        }
    }

    //get all the matches of s1 end positions in input string
    private ArrayList<Integer> getAllMatches(char[] input, String s){
        ArrayList<Integer> matches = new ArrayList<Integer>();
        int i = 0;
        while (i <= input.length - s.length()){
           if (equalSubstring(input, i , s)){
               //record the match substring's end index instead of start index for later convenience.
               matches.add(i + s.length() - 1);
               i += s.length();
           } else {
               i++;
           }
        }
        return matches;
    }

    public static void main(String[] args){
        StringReplace s = new StringReplace();
        String a1 = "student";
        String s1 = "den";
        String s2 = "ooo";
        String result = s.replaceI(a1, s1, s2);
        System.out.println(result);
    }
}
