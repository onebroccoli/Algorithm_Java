/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.



Example 1:


Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
Example 2:

Input: n = 1
Output: [["Q"]]

laicode return index of the column number
Return

A list of ways of putting the N Queens
Each way is represented by a list of the Queen's y index
for x indices of 0 to (N - 1)
Example

N = 4, there are two ways of putting 4 queens:

[1, 3, 0, 2] --> the Queen on the first row is at y index 1,
the Queen on the second row is at y index 3,
the Queen on the third row is at y index 0 and
the Queen on the fourth row is at y index 2.

[2, 0, 3, 1] --> the Queen on the first row is at y index 2,
the Queen on the second row is at y index 0,
the Queen on the third row is at y index 3 and
the Queen on the fourth row is at y index 1.

 */

import java.util.ArrayList;
import java.util.List;

/*
assumtion: n > 0
validate the queen position in O(N) each time
result is list of lists with integers


 */
public class Q51_N_Queens {
    public List<List<Integer>> nqueens(int n){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        //cur is a list of size n, cur[i] is the column number,
        // i is the current row number, where queen on row i positioned
        List<Integer> cur = new ArrayList<Integer>();
        helper(n, cur, result);
        return result;

    }
    private void helper(int n, List<Integer> cur, List<List<Integer>> result){
        if (cur.size() == n){
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i = 0; i < n; i++){
            //check if putting a queen at column i at current row is valid
            if (valid(cur, i)){
                cur.add(i);
                helper(n, cur, result);
                cur.remove(cur.size() - 1); //backtracking, remove the adding column
            }
        }
    }

    //check if the new queen added at current row is valid
    //not valid:
    //  1) in List<Integer> cur, if column already chosen
    //  2) diagonal has queen, diff(column - column') == diff(row - row')
    private boolean valid(List<Integer> cur, int column){
        int row = cur.size();
        for (int i = 0; i < row; i++){
            if (cur.get(i) == column || Math.abs(cur.get(i) - column) == row - i){
                return false;
            }
        }
        return true;
    }

    private List<List<String>> format(List<List<Integer>> array, int n){
        //for i in arr [[1,3,0,2],[2,0,3,1]]
            //list = i
            //for j in list [1,3,0,2]
                //for index in n
                    //if index = j  //1
                        //print q
                    //else print .
        List<List<String>> result = new ArrayList<List<String>>();
        //[[]]
        for (int i = 0; i < array.size(); i++){
            List<Integer> intList = array.get(i);
            List<String> ans = new ArrayList<String>();

            //[ ]
            for (int j = 0; j < intList.size(); j++) {
                StringBuilder sb = new StringBuilder();
                for (int index = 0; index < n; index++) {
                    if (index == intList.get(j)) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                ans.add(sb.toString());
            }

            result.add(ans);
        }
        return result;
    }



    public static void main(String[] args){
        Q51_N_Queens s = new Q51_N_Queens();
        int a = 4;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result = s.nqueens(a);
        List<List<String>> result2 = new ArrayList<List<String>>();
        result2 = s.format(result, a);
        System.out.println(result);
    }
}


   /*
      //for leetcode answer needs to be formatted
    //eg. [1,3,0,2]
    //[.,Q,.,.],
    //[.,.,.,Q],
    //[Q,.,.,.],
    //[.,.,Q,.]

//    private List<List<String>> format(List<List<Integer>> array, int n){
//        //for i in arr [[1,3,0,2],[2,0,3,1]]
//            //list = i
//            //for j in list [1,3,0,2]
//                //for index in n
//                    //if index = j  //1
//                        //print q
//                    //else print .
//        List<List<String>> result = new ArrayList<List<String>>();
//        //[[]]
//        for (int i = 0; i < array.size(); i++){
//            List<Integer> intList = array.get(i);
//            List<String> ans = new ArrayList<String>();
//
//            //[ ]
//            for (int j = 0; j < intList.size(); j++) {
//                StringBuilder sb = new StringBuilder();
//                for (int index = 0; index < n; index++) {
//                    if (index == intList.get(j)) {
//                        sb.append("Q");
//                    } else {
//                        sb.append(".");
//                    }
//                }
//                ans.add(sb.toString());
//            }
//
//            result.add(ans);
//        }
//        return result;
//    }
     */