import java.util.ArrayList;
import java.util.List;

/*
#laicode 66 All Valid Permutations Of Parentheses I
Given N pairs of parentheses “()”, return a list with all the valid permutations.

Assumptions：

N > 0
Examples

N = 1, all valid permutations are ["()"]
N = 3, all valid permutations are ["((()))", "(()())", "(())()", "()(())", "()()()"]

 */

/*
Solution:
2n levels, each level split two branches ( and ) parentheses
Time: O(2^N)
Space: O(N) 2n levels of call stack , stringbuilder is also n
 */
public class Q22_Generate_Parentheses {
    public List<String> validParentheses(int n){
        List<String> result = new ArrayList<>();
        //final string contains 2n characters, n pairs
        char[] temp = new char[n * 2];
        StringBuilder sb = new StringBuilder();
        dfs(n, 0, 0, sb, result);
        return result;
    }

    private void dfs(int n, int left, int right, StringBuilder sb, List<String> result){
        if (left == n && right == n){ //all the parentheses have been positioned
            result.add(sb.toString());
            return;
        }
        //
        if (left < n){
            sb.append("(");
            dfs(n, left + 1, right, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (left > right){
            sb.append(")");
            dfs(n, left, right + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args){
        Q22_Generate_Parentheses s = new Q22_Generate_Parentheses();
        int n = 2;
        List<String> result = s.validParentheses(n);
        System.out.println(result);
    }
}
