/*
103. Longest Consecutive 1s Laicode
Given an array containing only 0s and 1s, find the length of the
longest subarray of consecutive 1s.

Assumptions

The given array is not null
Examples

{0, 1, 0, 1, 1, 1, 0}, the longest consecutive 1s is 3.
 */
public class LongestConsecutive1s {
    public int longest(int[] array){
        if (array == null || array.length == 0){
            return 0;
        }
        int result = 0;
        int cur = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] == 1){
                if (i == 0 || array[i - 1] == 0){
                    cur = 1;
                } else {
                    cur++;
                }
                result = Math.max(result, cur);
            }
        }
        return result;
    }
    public static void main(String[] args){
        LongestConsecutive1s s = new LongestConsecutive1s();
        int[] array = {0,1,1,0,1,1};
        int result = s.longest(array);
        System.out.println(result);
    }
}
