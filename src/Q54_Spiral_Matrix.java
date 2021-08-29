import java.util.ArrayList;
import java.util.List;

/*
Given an m x n matrix, return all elements of
the matrix in spiral order.

Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]


Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
 */
public class Q54_Spiral_Matrix {
    //Assumption: matrix is not null , has size of M*N, where M N >=0
    public List<Integer> spiral(int[][] matrix){
        List<Integer> list = new ArrayList<Integer>();
        int m = matrix.length;
        //handle case since if m == 0, matrix[0].length will throw ArrayIndexOutofBoundException
        if (m == 0){
            return list;
        }
        int n = matrix[0].length; //column
        int left = 0;
        int right = n - 1;
        int up = 0;
        int down = m - 1;
        //base case is little complicated comparing to N*N matrix
        //1. there is nothing left
        //2. there is one row let
        //3. there is one column left
        while (left < right && up < down){
            for (int i = left; i <= right; i++){
                list.add(matrix[up][i]);
            }
            for (int i = up + 1; i <= down - 1; i++){
                list.add(matrix[i][right]);
            }
            for (int i = right; i >=left; i--){
                list.add(matrix[down][i]);
            }
            for (int i = down - 1; i >= up +1; i--){
                list.add(matrix[i][left]);
            }
            left++;
            right--;
            up++;
            down--;
        }
        //1. if there is nothing left
        if (left > right || up > down){
            return list;
        }
        //2. if there is one column left
        if (left == right){
            for (int i = up; i <= down; i++){
                list.add(matrix[i][left]);
            }
        } else {
            //3. if there is one row left
            for (int i = left; i <=right;i++){
                list.add(matrix[up][i]) ;
            }
        }
        return list;
    }

    public static void main(String[] args){
        Q54_Spiral_Matrix s = new Q54_Spiral_Matrix();
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> result = s.spiral(matrix);
        System.out.println(result);
    }

}
