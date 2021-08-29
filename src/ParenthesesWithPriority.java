import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
laicode
642. All Valid Permutations Of Parentheses III
Get all valid permutations of l pairs of (),
 m pairs of <> and n pairs of {},
 subject to the priority restriction: {} higher than <> higher than ().

Assumptions

    l, m, n >= 0

    l + m + n >= 0

Examples

    l = 1, m = 1, n = 0, all the valid permutations are ["()<>", "<()>", "<>()"].

    l = 2, m = 0, n = 1, all the valid permutations are [“()(){}”, “(){()}”, “(){}()”,
     “{()()}”, “{()}()”, “{}()()”].
 */
public class ParenthesesWithPriority {
    private static final char[] set = new char[]{'(', ')', '<', '>', '{', '}'};

    public List<String> validParenthesesIII(int l, int m, int n) {
        //assumption: l,m,n >0;
        int[] remain = new int[]{l, l, m, m, n, n};
        int targetLen = 2 * (l + m + n);
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new LinkedList<Integer>();
        List<String> result = new ArrayList<String>();
        helper(sb, stack, remain, targetLen, result);
        return result;
    }

    private void helper(StringBuilder sb, Deque<Integer> stack, int[] remain, int targetLen, List<String> result) {
        if (sb.length() == targetLen) {
            result.add(sb.toString());
            return;
        }

        for (int i = 0; i < remain.length; i++) {
            if (i % 2 == 0) {
                if (remain[i] > 0 && (stack.isEmpty() || stack.peekFirst() > i)) {
                    sb.append(set[i]);
                    stack.offerFirst(i);
                    remain[i]--;
                    helper(sb, stack, remain, targetLen, result);
                    sb.deleteCharAt(sb.length() - 1);
                    stack.pollFirst();
                    remain[i]++;
                }
            } else {
                if (!stack.isEmpty() && stack.peekFirst() == i - 1) {
                    sb.append(set[i]);
                    stack.pollFirst();
                    remain[i]--;
                    helper(sb, stack, remain, targetLen, result);
                    sb.deleteCharAt(sb.length() - 1);
                    stack.offerFirst(i - 1);
                    remain[i]++;
                }
            }
        }
    }

    public static void main(String[] args) {
        ParenthesesWithPriority s = new ParenthesesWithPriority();
        List<String> result = s.validParenthesesIII(2, 0, 1);
        System.out.println(result);
    }
}
