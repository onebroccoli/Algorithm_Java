import java.util.ArrayList;
import java.util.List;

public class AllPermutations {
    public List<String> validParentheses(int n) {
        List<String> result = new ArrayList<String>();
        //final string contains 2n characters, n pairs
        char[] cur = new char[n * 2];
        StringBuilder sb = new StringBuilder();
        helper(n, 0, 0, sb, result);
        return result;

    }

    private void helper(int n, int l, int r, StringBuilder sb,  List<String> result){
        if (l == n && r == n){
            result.add(sb.toString());
            return;
        }

        //when we can add a left '(' ? when there is some '( 'we can still use
        //case1: add '(' on this level
        if (l < n){
            sb.append('(');
            helper(n, l + 1, r, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }

        //case 2: add ')' on this level
        if (l > r){
            sb.append(')');
            helper(n, l, r + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
