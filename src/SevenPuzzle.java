import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/*
681. Seven Puzzle Laicode
Given eight cards with number 0, 1, 2, ..7 on them,
the cards are placed in two rows with 4 cards in each row.
In each step only card 0 could swap with one of its adjacent(top, right, bottom, left) card. Your goal is to make all cards placed in order like this:

0 1 2 3

4 5 6 7

Find the minimum number of steps from the given state to the final state. If there is no way to the final state, then return -1.

The state of cards is represented by an array of integer, for example [0,1,2,3,4,5,6,7] where the first four numbers are in the first row from left to right while the others are placed in the second row from left to right.

Example:

Input: [4,1,2,3,5,0,6,7]       Output: 2

Explanation:

Initial state is:

4 1 2 3

5 0 6 7

First swap 0 with 5, then the state is:

4 1 2 3

0 5 6 7

Then swap 0 with 4, then we get the final state:

0 1 2 3

4 5 6 7


 */
public class SevenPuzzle {
    public int numOfSteps(int[] values) {
        String target = "01234567";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++){
            sb.append(values[i]);
        }
        Set<String> visited = new HashSet<>();
        //all the positions can be swapped to
        int[][] dirs = new int[][] {{1, 4}, {0,2,5}, {1,3,6}, {2,7}, {0,5}, {1,4,6}, {2,5,7}, {3,6}};
        Queue<String> queue = new ArrayDeque<>();
        String start = sb.toString();
        queue.offer(start);
        visited.add(start);
        int res = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                String cur = queue.poll();
                if (cur.equals(target)){
                    return res;
                }
                int zero = cur.indexOf('0');
                for (int dir : dirs[zero]){
                    String next = swap(cur, zero, dir);
                    if (visited.add(next)){
                        queue.offer(next);
                    }
                }
            }
            res++;
        }
        return -1;
    }
    private String swap(String str, int i, int j){
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }


    public static void main(String[] args){
        SevenPuzzle s = new SevenPuzzle();
        int[] a = {1,2,3,0,4,5,6,7};
        int result = s.numOfSteps(a);
        System.out.println(result);
    }
}
