import java.util.ArrayList;
import java.util.List;

/*
91. Decode Ways
A message containing letters from A-Z can be encoded into
numbers using the following mapping:

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode an encoded message, all the digits must be grouped
then mapped back into letters using the reverse of the mapping
above (there may be multiple ways). For example, "11106" can be mapped into:

"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)
Note that the grouping (1 11 06) is invalid because "06" cannot
be mapped into 'F' since "6" is different from "06".

Given a string s containing only digits, return the number of ways to decode it.

The answer is guaranteed to fit in a 32-bit integer.



Example 1:

Input: s = "12"
Output: 2
Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: s = "226"
Output: 3
Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
Example 3:

Input: s = "0"
Output: 0
Explanation: There is no character that is mapped to a number starting with 0.
The only valid mappings with 0 are 'J' -> "10" and 'T' -> "20", neither
of which start with 0.
Hence, there are no valid ways to decode this since all digits need to be mapped.
Example 4:

Input: s = "06"
Output: 0
Explanation: "06" cannot be mapped to "F" because of the leading zero
("6" is different from "06").


Constraints:

1 <= s.length <= 100
s contains only digits and may contain leading zero(s).


e.g. Given input String  "1121"

It can be decoded as

[ "AABA",

  "AAU",

  "ALA",

  "KBA",

  "KU"

]
 */
/*
Solution:
permutation: use DFS
assumptions: input is valid, not empty or null

 */
public class Q91_Decode_Ways {

    public List<String> numDecodings(String input) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(result, sb, input, 0);
        return result;
    }

    private void helper(List<String> result, StringBuilder sb, String input, int index) {
        //base case
        if (index == input.length()) {
            result.add(sb.toString());
            return;
        }
        //decode case1: 1 digit
        int number = input.charAt(index) - '0';
        if (number >= 1 && number <= 9) {
            //1 -> A
            char cur = (char) (number - 1 + 'A');
            sb.append(cur);
            helper(result, sb, input, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        //decode case 2: 2 digits
        if (index + 1 < input.length()) {
            number = (input.charAt(index) - '0') * 10 + (input.charAt(index + 1) - '0');
            if (number >= 10 && number <= 26) {
                char cur = (char) (number - 1 + 'A');
                sb.append(cur);
                helper(result, sb, input, index + 2);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }


    public static void main(String[] args){
        Q91_Decode_Ways s = new Q91_Decode_Ways();
        String a = "1121";
//        String a = "111111111111111111111111111111111111111111111";
        List<String> result = s.numDecodings(a);
        System.out.println(result);
    }
}

