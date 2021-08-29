import java.util.*;

/*
651. Common Numbers Of Two Arrays II(Array version)
Find all numbers that appear in both of two unsorted arrays.

Assumptions

Both of the two arrays are not null.
In any of the two arrays, there could be duplicate numbers.
Examples

A = {1, 2, 3, 2}, B = {3, 4, 2, 2, 2}, return [2, 2, 3]
(there are both two 2s in A and B)
 */
public class CommonNumbersOfTwoArraysUnsortedWithDup {
    public List<Integer> common(int[] A, int[] B) {
        //assumption: there could be duplicated elements in the given arrays
        //hashmap
        List<Integer> common = new ArrayList<Integer>();
        HashMap<Integer, Integer> countA = new HashMap<Integer, Integer>();
        for (int num : A){
            Integer count = countA.get(num);
            if (count != null){
                countA.put(num, count + 1);
            } else {
                countA.put(num, 1);
            }
        }
        HashMap<Integer, Integer> countB = new HashMap<Integer, Integer>();
        for (int num : B){
            Integer count = countB.get(num);
            if (count != null){
                countB.put(num, count + 1);
            } else {
                countB.put(num, 1);
            }
        }
        Set<Map.Entry<Integer,Integer>> s = countA.entrySet();
        for (Map.Entry<Integer, Integer> entry: s){
            Integer countInB = countB.get(entry.getKey());
            if (countInB != null){
                int appear = Math.min(entry.getValue(), countInB);//选出现次数最小的，因为如果A出现两次， B出现1次，那common就只是1次
                for (int i = 0; i < appear; i++){
                    common.add(entry.getKey());
                }
            }
        }
        Collections.sort(common);
        return common;
    }


    public static void main(String[] args){
        CommonNumbersOfTwoArraysUnsortedWithDup s = new CommonNumbersOfTwoArraysUnsortedWithDup();
        int[] a = {9,19,16,25,8,5,10,20,16,25,23,20,17,14,24,2,7,6,11,6,15};
        int[] b = {9,19,3,1,9,1,25,8,16,10,16,13,10,21,20,23,13,8,13,7,24};
        List<Integer> result = s.common(a,b);
        System.out.println(result);

    }
}
