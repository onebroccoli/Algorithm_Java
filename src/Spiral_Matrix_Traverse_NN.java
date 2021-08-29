import java.util.ArrayList;
import java.util.List;

/*

121. Spiral Order Traverse I laicode
Traverse an N * N 2D array in spiral order clock-wise starting
 from the top left corner. Return the list of traversal sequence.

Assumptions

The 2D array is not null and has size of N * N where N >= 0
Examples

{ {1,  2,  3},

  {4,  5,  6},

  {7,  8,  9} }

the traversal sequence is [1, 2, 3, 6, 9, 8, 7, 4, 5]
 */
public class Spiral_Matrix_Traverse_NN {
    public List<Integer> spiral(int[][] matrix) {
        //base case: only 0, 1 element left
        List<Integer> result = new ArrayList<Integer>();
        recursiveTraverse(matrix, 0, matrix.length, result);
        return result;
    }

    private void recursiveTraverse(int[][] matrix, int offset, int size,  List<Integer> result) {
        if (size == 0) {
            return;
        }
        if (size == 1) {
            result.add(matrix[offset][offset]);
            return;
        }
        //size -1 because only point to size - 1 number for each side
        for (int i = 0; i < size - 1; i++) {
            result.add(matrix[offset][offset + i]); // go right
        }
        for (int i = 0; i < size - 1; i++) {
            result.add(matrix[offset + i][offset + size - 1]); //go down
        }
        for (int i = size - 1; i >= 1; i--) {
            result.add(matrix[offset + size - 1][offset + i]); //go left
        }
        for (int i = size - 1; i >= 1; i--) {
            result.add(matrix[offset + i][offset]);//go up
        }
        recursiveTraverse(matrix, offset + 1, size - 2, result);
    }

    public static void main(String[] args){
        Spiral_Matrix_Traverse_NN s = new Spiral_Matrix_Traverse_NN();
//        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        List<Integer> result = s.spiral(matrix);
        System.out.println(result);
    }

}
