/*
Find the Kth smallest number s such that s = 3 ^ x * 5 ^ y * 7 ^ z, x > 0
and y > 0 and z > 0, x, y, z are all integers.

Assumptions

K >= 1
Examples

the smallest is 3 * 5 * 7 = 105
the 2nd smallest is 3 ^ 2 * 5 * 7 = 315
the 3rd smallest is 3 * 5 ^ 2 * 7 = 525
the 5th smallest is 3 ^ 3 * 5 * 7 = 945

 */

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/*
BFS
initial: x = y = z = 1
expansion rule: x+1, y, z ; x, y+1, z; x, y, z+1
termination: when kth element is popped out of the heap,
must do deduplication when generating a new state

Time: O(k log(k))
 */
public class Kth_Smallest_with_only_3_5_7_as_factor {
    public long kth(int K){
        //assumption: k>=1
        PriorityQueue<Long> minHeap = new PriorityQueue<>(K);
        Set<Long> visited = new HashSet<>();
        //we use the actual product value to represent the states
        //<x,y,z> the valye is 3^x * 5^y * 7^z and the initial state is <1,1,1>
        minHeap.offer(3 * 5 * 7L);
        visited.add(3 * 5 * 7L);
        while (K > 1){
            long current = minHeap.poll();
            //for the state <x+1, y, z> the actual value is *3
            if (visited.add(3 * current)){
                minHeap.offer(3 * current);
            }
            //for the state <x, y + 1, z) the actual value is * 5
            if (visited.add(5 * current)){
                minHeap.offer(5 * current);
            }
            //for the state <x, y + 1, z) the actual value is * 7
            if (visited.add(7 * current)){
                minHeap.offer(7 * current);
            }
            K--;
        }
        return minHeap.peek();
    }
}
