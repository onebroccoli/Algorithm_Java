import java.util.ArrayList;
import java.util.List;
/*
given an integer n, print all possible ways of writing n pairs of if blocks with correct indentation
say n =2  output should be:
if {
}
if {
}
<new line>
if{
, if { //here should exist two spaces before each inner block
}
}
['{}{}{}','{{{}}}','{{}}{}']
 */

/*

 */
public class PermutationOfParenthesesWithSpace {
    public List<String> validParentheses(int n) {
        List<String> result = new ArrayList<String>();
        //final string contains 2n characters, n pairs
        char[] cur = new char[n * 2];
        StringBuilder sb = new StringBuilder();
        helper(n, 0, 0, sb, result);
        return result;

    }

    private void helper(int n, int l, int r, StringBuilder sb, List<String> result) {
        if (l == n && r == n) {
            result.add(sb.toString());
            return;
        }

        //when we can add a left '(' ? when there is some '( 'we can still use
        //case1: add '(' on this level
        if (l < n) {
            sb.append("{");
            helper(n, l + 1, r, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }

        //case 2: add ')' on this level
        if (l > r) {
            sb.append('}');
            helper(n, l, r + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private List<List<String>> postProcess(List<String> array) {
        final int NUM_SPACES_PER_LEVEL = 2;
        List<List<String>> result = new ArrayList<List<String>>();
        for (String ans : array) {
            ArrayList<String> tmp = new ArrayList<String>();
            int level = 0;

            for (int j = 0; j < ans.length(); j++) {
                if (ans.charAt(j) == '{') {
                    tmp.add(" ".repeat(level*NUM_SPACES_PER_LEVEL) + "if{");
                    level +=1;
                    continue;
                }
                if (ans.charAt(j) == '}') {
                    level -=1;
                    tmp.add(" ".repeat(level*NUM_SPACES_PER_LEVEL) + "}");
                    continue;
                }
            }
            result.add(tmp);
        }
        return result;
    }

    public static void main(String[] args) {
        PermutationOfParenthesesWithSpace s = new PermutationOfParenthesesWithSpace();
        List<String> permutation = s.validParentheses(3);
        List<List<String>> result = s.postProcess(permutation);
        for (List<String> answer : result) {
            for (int j = 0; j < answer.size(); j++) {
                System.out.println(answer.get(j));
            }
            System.out.println("\n");
        }
    }
}



