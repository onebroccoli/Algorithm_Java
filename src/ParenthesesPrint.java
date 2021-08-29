/*
Given an integer n, print/output all possible ways of writing n pairs of if blocks with correct indentation.

Say n=2 output should be

if {

}

if {

}

<newline>

if {

  if {// here should exist two spaces before each inner block

  }

}

 */

/*
1. use DFS to do the permutation of parentheses,
2. 2n (n is #of pairs) levels in the recursion tree, one curly brace each level
3. 每层每个node分几个叉出来，2，2 states to put on each level, either left or right curly brace on each level

Time: O(2^2N * n) worst case n is print
Space: O(2N) height of the tree.
 */

public class ParenthesesPrint {
    public void printBlocks(int n){
        if (n <= 0){
            return;
        }
        char[] cur = new char[n * 2];
        helper(n, n, 0, cur);
    }

    private void helper(int left, int right, int index, char[] cur){
        //base case
        if (left == 0 && right == 0){
            print(cur);
            return;
        }
        if (left > 0) {
            cur[index] = '{';
            helper(left - 1, right, index + 1, cur);
        };
        if (right > left){
            cur[index] = '}';
            helper(left, right - 1, index + 1, cur);
        }
    }

    private void print(char[] cur){
        int space = 0;
        for (int i = 0; i < cur.length; i++){
            if (cur[i] == '{'){
//                System.out.println("current space: " + space);
                printSpace(space);
                System.out.println("if {");
                space += 2;
            } else {
                space -= 2;
//                System.out.println("current space: " + space);
                printSpace(space);
                System.out.println( "}");
            }
        }
        System.out.println();
    }

    private void printSpace(int n){
        while (n > 0){
            System.out.print(" ");
            n--;
        }
    }

    public static void main(String[] args){
        ParenthesesPrint s = new ParenthesesPrint();
        int n = 3;
        s.printBlocks(n);
    }
}
