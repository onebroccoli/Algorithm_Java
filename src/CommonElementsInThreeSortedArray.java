import java.util.ArrayList;
import java.util.List;

/*
171. Common Elements In Three Sorted Array LAI
Find all common elements in 3 sorted arrays.

Assumptions

The 3 given sorted arrays are not null
There could be duplicate elements in each of the arrays
Examples

A = {1, 2, 2, 3}, B = {2, 2, 3, 5}, C = {2, 2, 4}, the common elements are [2, 2]
 */
public class CommonElementsInThreeSortedArray {
    public List<Integer> common(int[] a, int[] b, int[] c){
        //assumptions: abc are not null
        List<Integer> common = new ArrayList<Integer>();
        int ai = 0;
        int bi = 0;
        int ci = 0;
        while (ai < a.length && bi < b.length && ci < c.length){
            if (a[ai] == b[bi] && b[bi] == c[ci]){
                common.add(a[ai]);
                ai++;
                bi++;
                ci++;
            } else if (a[ai] <= b[bi] && a[ai] <= c[ci]){
                ai++;
            } else if (b[bi] <= a[ai] && b[bi] <= c[ci]){
                bi++;
            } else {
                ci++;
            }
        }
        return common;
    }

    public static void main(String[] args){
        CommonElementsInThreeSortedArray s = new CommonElementsInThreeSortedArray();
        int[] a = {1,3,4,5,6,7};
        int[] b = {2,4,9};
        int[] c = {2,3,4,5,10};
        List<Integer> result = s.common(a,b,c);
        System.out.println(result);
    }
}
