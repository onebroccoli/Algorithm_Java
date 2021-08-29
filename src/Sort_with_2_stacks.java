import java.util.Deque;
import java.util.LinkedList;

/*
280. Sort With 2 Stacks laicode
Given an array that is initially stored in one stack,
sort it with one additional stacks (total 2 stacks).

After sorting the original stack should contain the
sorted integers and from top to bottom the integers
are sorted in ascending order.

Assumptions:

The given stack is not null.
There can be duplicated numbers in the give stack.
Requirements:

No additional memory, time complexity = O(n ^ 2).
4 2 2 3 5
5 4 3 2 2

 */
public class Sort_with_2_stacks {
    public void sort(LinkedList<Integer> s1){
        if (s1 == null || s1.size() <= 1){
            return;
        }
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        sort(s1, s2);
    }
    private void sort(Deque<Integer> input, Deque<Integer> buffer){
        //input: unsorted elements
        //buffer: top part buffer, bottom part sorted elements
        //Step 1: sort in ascending order and store result in buffer
        while (!input.isEmpty()) {
            int curMin = Integer.MAX_VALUE;
            int count = 0;
            while (!input.isEmpty()) {
                int cur = input.pollFirst();
                if (cur < curMin) {
                    curMin = cur;
                    count = 1;
                } else if (cur == curMin) {
                    count++;
                }
                buffer.offerFirst(cur); //move all from input stack to buffer stack
            }
            while (!buffer.isEmpty() && buffer.peekFirst() >= curMin) {
                int tmp = buffer.pollFirst();
                if (tmp != curMin) {
                    input.offerFirst(tmp);
                }
            }
            //move global
            while (count > 0) {
                buffer.offerFirst(curMin);
                count--;
            }
        }
            //step2: move result from buffer to input, so it's in descending order
        while (!buffer.isEmpty()){
            input.offerFirst(buffer.pollFirst());
        }
//            4 2 2 3 5
//            5 4 3 2 2
    }

    public static void main(String[] args){
        Sort_with_2_stacks s = new Sort_with_2_stacks();
        LinkedList<Integer> list = new LinkedList<Integer>();
        int[] num = {4,2,2,3,5};
        for (int i : num){
            list.add(i);
        }
        s.sort(list);
        System.out.println(list);
    }

}
