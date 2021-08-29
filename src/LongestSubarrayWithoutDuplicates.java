import java.util.HashSet;
import java.util.Set;

/*
Given a string, find the longest substring without any
repeating characters and return the length of it.
The input string is guaranteed to be not null.

For example, the longest substring without repeating
letters for "bcdfbd" is "bcdf", we should return 4 in this case.
 */

/*
build hashset to store all the characters being processed so far
1. slow, fast pointer, iterate through the string for each character
2. if input.atChar(fast) already exists, fast stop, hashset remove the character, slow++
3. if not exist, add to hashset, fast++
4. update longest to the max of (longest, fast-slow)
 */
public class LongestSubarrayWithoutDuplicates {
    public int longest(String input){
        Set<Character> distinct = new HashSet<>();
        int slow = 0;
        int fast = 0;
        int longest = 0;
        while (fast < input.length()){
            if (distinct.contains(input.charAt(fast))){
                //if there is duplicate character, need to move the slow pointer.
                distinct.remove(input.charAt(slow));
                slow++;
            } else {
                //if there is no duplicate character, can slide fast pointer and we have
                //a new sliding window of (slow, fast) containing all distinct characters
                distinct.add(input.charAt(fast++));
                longest = Math.max(longest, fast - slow);
            }
        }
        return longest;
    }

    public static void main(String[] args){
        LongestSubarrayWithoutDuplicates s = new LongestSubarrayWithoutDuplicates();
        String a = "bcdfwcbe";
        int result = s.longest(a);
        System.out.println(result);

    }

}
