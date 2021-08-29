import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/*
Given a string array words, return the maximum value of
length(word[i]) * length(word[j]) where the two words do
not share common letters. If no such two words exist, return 0.

Example 1:

Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
Output: 16
Explanation: The two words can be "abcw", "xtfn".
Example 2:

Input: words = ["a","ab","abc","d","cd","bcd","abcd"]
Output: 4
Explanation: The two words can be "ab", "cd".
Example 3:

Input: words = ["a","aa","aaa","aaaa"]
Output: 0
Explanation: No such pair of words.


Constraints:

2 <= words.length <= 1000
1 <= words[i].length <= 1000
words[i] consists only of lowercase English letters.
 */
/*
assumption: all letter in the words is from a-z in ASCII, and sorted in the length.
Graph3 class 有讲，看讲义

 */
public class Q318_Maximum_Product_of_Word_Lengths {
    public int largestProduct(String[] dict){
        //assumption: dict is not null and has length >= 2
        //there is no null string in the dict
        //the words in the dict only use characters a - z
        //get the bit mask is represented by the lowest 26 bits of an integer
        //each of the big represents one of the characters in a-z
        HashMap<String, Integer> bitMasks = getBitMasks(dict);
        //sort the dict by length of words in descending order
        Arrays.sort(dict, new Comparator<String>(){
            @Override
            public int compare(String s0, String s1){
                if (s0.length() == s1.length()){
                    return 0;
                }
                return s0.length() < s1.length() ? 1 : -1;
            }
        });
        int largest = 0;
        //note the order of constructing all the pairs
        //we make our best to try largest product
        for (int i = 1; i < dict.length; i++){
            for (int j = 0; j < i; j++){
                //early break if the product is already smaller than the current largest one
                int prod = dict[i].length() * dict[j].length();
                if (prod < largest){
                    break;
                }
                int iMask = bitMasks.get(dict[i]);
                int jMask = bitMasks.get(dict[j]);
                //if two words do not share any common characters
                //the bit masks "and" result should be 0 since
                //there is not any position such that in the two bit masks
                //they are all 1
                if ((iMask & jMask) == 0){
                    largest = prod;
                }
            }
        }
        return largest;
    }

    //get the bit mask for each of the words
    private HashMap<String, Integer> getBitMasks(String[] dict){
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String str : dict){
            int bitMask = 0;
            for (int i = 0; i < str.length(); i++){
                //the 26 characters a-z are mapped to 0-25th bit
                //to determine which bit it is for a character x
                //use (x-a)since their values are in a consecutive range
                //if character x exists in the word, we set the bit at corresponding index to 1
                bitMask |= 1 << (str.charAt(i) - 'a');
            }
            map.put(str, bitMask);
        }
        return map;
    }
}
