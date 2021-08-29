import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
Laicode 179. All Valid Permutations Of Parentheses II
Get all valid permutations of l pairs of (),
m pairs of <> and n pairs of {}.

Assumptions

l, m, n >= 0
l + m + n > 0
Examples

l = 1, m = 1, n = 0, all the valid permutations are ["()<>", "(<>)", "<()>", "<>()"]


 */
public class ParenthesesAllValid {
    private static final char[] set = new char[] {'(', ')', '<', '>', '{', '}'};

    public List<String> validParentheses(int l, int m, int n){
        //assumption: l, m, n >= 0;
        int[] remain = new int[] {l, l, m, m, n, n};
        int targetLen = 2 * (l + m + n);
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new LinkedList<Character>();
        List<String> result = new ArrayList<String>();
        helper(sb, stack, remain, targetLen, result);
        return result;
    }

    private void helper(StringBuilder sb, Deque<Character> stack, int[] remain, int targetLen, List<String> result){
        //termination condition, when == targetLen, means all the parentheses are used, append to result
        if (sb.length() == targetLen){
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i < remain.length; i++){
            //case 1: i even number,  when to add the left side""(", "<", "{": i%2 == 0
            if (i % 2 == 0){
                if (remain[i] > 0){
                    sb.append(set[i]);
                    stack.offerFirst(set[i]);
                    remain[i]--;
                    helper(sb, stack, remain, targetLen, result);
                    sb.deleteCharAt(sb.length() - 1);
                    stack.pollFirst();
                    remain[i]++; }
            //case 2: i odd number, 1)stack not empty, 2)stack.peekFirst() == set[i - 1]
            } else {
                if (!stack.isEmpty() && stack.peekFirst() == set[i -1]){
                    sb.append(set[i]);
                    stack.pollFirst();
                    remain[i]--;
                    helper(sb, stack, remain, targetLen, result);
                    sb.deleteCharAt(sb.length() - 1);
                    stack.offerFirst(set[i - 1]);
                    remain[i]++;
                }
            }
        }
    }
    public static void main(String[] args){
        ParenthesesAllValid s = new ParenthesesAllValid();
        List<String> result = s.validParentheses(2,2,2);
        System.out.println(result);
    }
}
