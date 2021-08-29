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
/*
Solution:
1. because no duplicate, we use hashset to check
if the short array has element in longer array
2. sort the common element array

TC: O(m + n + klogk)
    * m is the size of longer array,
    * n is the size of shorter array
    * k is # of common elements
    * Since Cuckoo hashing has the worst lookup O(1) time,
        we assume HashSet and HashMap lookup is O(1) time
SC: O(m) longer array
 */
public class CommonNumbersOfTwoArraysUnsortedWithoutDup {
public List<Integer> common(int[] a, int[] b){
    List<Integer> res = new ArrayList<>();
    if (a == null || b == null || a.length == 0 || b.length == 0){
        return res;
    }
    if (a.length > b.length){
        res = helper(b, a);
    } else {
        res = helper(b, a);
    }
    return res;
}
private List<Integer> helper(int[] a, int[] b){
    List<Integer> res = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    for (int x : a){
        set.add(x);
    }
    for (int x : b){
        if (set.contains(x)){
            res.add(x);
        }
    }
    Collections.sort(res);
    return res;
}

    public static void main(String[] args){
        CommonNumbersOfTwoArraysUnsortedWithoutDup s = new CommonNumbersOfTwoArraysUnsortedWithoutDup();
        int[] a = {1, 3, 4, 5};
        int[] b = {1, 3};
        List<Integer> res = s.common(a, b);
        System.out.println(res);
    }
}
