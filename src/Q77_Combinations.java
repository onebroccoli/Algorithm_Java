/*
Given two integers n and k, return all possible
combinations of k numbers out of 1 ... n.

You may return the answer in any order.



Example 1:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
Example 2:

Input: n = 1, k = 1
Output: [[1]]


Constraints:

1 <= n <= 20
1 <= k <= n

 */

/*
Time: O(k*CkN) where CkN is number of combinations to build
    append/pop(add,removeLast) operations are constant-time ones and the only
    consuming part is to append the built combination of length k to the output.
Space: O(CkN) to keep all combinations for an output.
 */
import java.util.LinkedList;
import java.util.List;

public class Q77_Combinations {
    List<List<Integer>> output = new LinkedList();
    int n;
    int k;

    public List<List<Integer>> combine(int n, int k){
        this.n = n;
        this.k = k;
        helper(1, new LinkedList<Integer>());
        return output;
    }

    public void helper(int index, LinkedList<Integer> curr){
        //if combination is complete:
        if (curr.size() == k){
            output.add(new LinkedList(curr));
        }
        for (int i = index; i < n + 1; i++){
            //add i into the current combination
            curr.add(i);
            helper(i + 1, curr);
            curr.removeLast();
        }
    }

    public static void  main(String[] args){
        Q77_Combinations s = new Q77_Combinations();
        int n = 4;
        int k = 3;
        System.out.println(s.combine(n, k));
    }

}
