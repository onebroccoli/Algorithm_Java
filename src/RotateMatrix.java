/*
125. Rotate Matrix
Rotate an N * N matrix clockwise 90 degrees.

Assumptions

The matrix is not null and N >= 0
Examples

{ {1,  2,  3}

  {8,  9,  4},

  {7,  6,  5} }

after rotation is

{ {7,  8,  1}

  {6,  9,  2},

  {5,  4,  3} }
 */

public class RotateMatrix {
    public void rotate(int[][] matrix) {
        //method 1: split into levels and for each level split it into four partitions
        //assumptions: matrix is not null and has size of N*N, N >= 0
        //先做N*N， 再做(N-1)*(N-1).....1*1
        //转完，新的行号一定==原先列号
        //右边有0列的列是N-1列
        //右边有X列的是N-1-X 列
        //所以a[i][j] 翻转后： a[j][n-1-i]
        //a[j][n-1-i]翻转后： a[n-1-i][n-1-j]
        //a[n-1-i][n-1-j]翻转后： a[n-1-j][n-1-n+1+i] = a[n-1-j][i]
        //a[n-1-j][i] 翻转后：a[i][n-1-n+1+j] = a[i][j]
        //要先把左上角的存成tmp, 然后右上-1> 右下-2> 左下-3> 左上， tmp-> 右上
        int n = matrix.length;
        if (n <= 1){
            return;
        }
        int round  = n / 2;
        for (int level = 0; level < round; level++){
            int left = level;
            int right = n - 2 - level;
            for (int i = left; i <= right; i++){
                int tmp = matrix[left][i];
                //推导
                // matrix[left][i] = matrix[i][n - 1- left]; //左上--> 右上
                // matrix[i][n - 1- left] = matrix[n - 1 - left][n - 1 - i];//右上 --> 右下
                // matrix[n - 1 - left][n - 1 - i] = matrix[n - 1- i][left];//右下 --> 左下
                // matrix[n - 1- i][left] = matrix[left][i]; //左下 --> 左上

                matrix[left][i] = matrix[n - 1- i][left]; //左上 = 左下
                matrix[n - 1- i][left] = matrix[n - 1 - left][n - 1 - i]; //左下 = 右下
                matrix[n - 1 - left][n - 1 - i] = matrix[i][n - 1- left]; //右下 = 右上
                matrix[i][n - 1- left] = tmp; //右上 = tmp
            }
        }
    }
}
