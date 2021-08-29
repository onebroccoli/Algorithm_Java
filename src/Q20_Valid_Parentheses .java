/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.


Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
Example 4:

Input: s = "([)]"
Output: false
Example 5:

Input: s = "{[]}"
Output: true


Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.

 */

/*
Solution: use stack
 */

import java.util.ArrayDeque;
import java.util.Deque;

class Q20_Valid_Paentheses{
    public boolean isValid(String s){
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            //Always push the left parenthesis into stack
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                //when meet a right parenthesis compare with the top of the stack
                if (!stack.isEmpty()) {
                    char c = stack.pop();
                    if ((c == '(' && s.charAt(i) == ')') ||
                            (c == '{' && s.charAt(i) == '}') ||
                            (c == '[' && s.charAt(i) == ']')) continue;
                }
                return false;
            }
        }
        return stack.isEmpty(); //when the entire stack is processed, a valid one should leave stack empty
    }

    public static void main(String[] args){
        Q20_Valid_Paentheses s = new Q20_Valid_Paentheses();
//        String a = "(({[))]}";
        String a = "(({[]}))";
        boolean result = s.isValid(a);
        System.out.println(result);
    }
}

