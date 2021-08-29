import java.util.Comparator;
import java.util.PriorityQueue;

/*
Given an n x n matrix where each of the rows and columns are sorted in ascending order, return the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.



Example 1:

Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
Example 2:

Input: matrix = [[-5]], k = 1
Output: -5
 */
public class Q378_Kth_Smallest_Element_in_a_Sorted_Matrix {
    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        //Best First Search, need a minheap on the value of each cells
        PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(k, new Comparator<Cell>(){
            @Override
            public int compare(Cell c1, Cell c2){
                if (c1.value == c2.value){
                    return 0;
                }
                return c1.value < c2.value ? -1 : 1;
            }
        });
        //all the generated cells will be marked true
        //to avoid being generated more than once
        boolean[][] visited = new boolean[rows][columns];
        minHeap.offer(new Cell(0, 0, matrix[0][0]));
        visited[0][0] = true;
        //iterate k-1 rounds, and Best First Search the smallest k-1 cells
        for (int i = 0; i < k - 1; i++){
            Cell cur= minHeap.poll();
            //the neighbor cell will be inserted back to the minheap only if
            //1. it is not out of boundary
            //2. it has not been generated before
            //because for each cell it could be generated twice
            if (cur.row + 1 < rows && !visited[cur.row + 1][cur.column]){
                minHeap.offer(new Cell(cur.row + 1, cur.column, matrix[cur.row + 1][cur.column]));
                visited[cur.row + 1][cur.column] = true;
            }
            if (cur.column + 1 < columns && !visited[cur.row][cur.column + 1]){
                minHeap.offer(new Cell(cur.row, cur.column + 1, matrix[cur.row][cur.column + 1]));
                visited[cur.row][cur.column + 1] = true;
            }
        }
        return minHeap.peek().value;
    }

    static class Cell{
        int row;
        int column;
        int value;
        Cell(int row, int column, int value){
            this.row = row;
            this.column = column;
            this.value = value;
        }
    }
}
