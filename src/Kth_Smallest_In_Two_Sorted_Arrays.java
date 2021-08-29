/*
202. Kth Smallest In Two Sorted Arrays lai

Given two sorted arrays of integers, find the Kth smallest number.
Assumptions
The two given arrays are not null and at least one of them is not empty
K >= 1, K <= total lengths of the two sorted arrays
Examples
A = {1, 4, 6}, B = {2, 3}, the 3rd smallest number is 3.
A = {1, 2, 3, 4}, B = {}, the 2nd smallest number is 2.

 */
public class Kth_Smallest_In_Two_Sorted_Arrays {
    public int kth(int[] a, int[]b, int k){
        //assumptions: a b is not null, at least one of them is not empty,
        //k <=a.length + b.length, k >= 1
        return kth(a, 0, b, 0, k);
    }

    //in the subarray of a starting from index aLeft, and
    //subarray of b starting from index bLeft, find the kth smallest
    //element among these two subarrays.
    private int kth(int[] a, int aLeft, int[] b, int bLeft, int k){
        //base cases:
        //1. we already eliminate all the elements in a
        //2. we already eliminate all the elements in b
        //3. when k is reduced to 1, don't miss this base case
        //the reason why we have this as base case is in the following logic we need k>=2 to make it work
        if (aLeft >= a.length){
            return b[bLeft + k - 1];
        }
        if (bLeft >= b.length){
            return a[aLeft + k - 1];
        }
        if (k == 1){
            return Math.min(a[aLeft], b[bLeft]);
        }
        //we compare the k/2 th element in a's subarray
        //and the k/2 th element in b's subarray
        //to determine which k/2 partition can be surely included
        //in the smallest k elements
        int aMid = aLeft + k / 2 - 1;
        int bMid = bLeft + k / 2 - 1;
        int aVal = aMid >= a.length ? Integer.MAX_VALUE : a[aMid];
        int bVal = bMid >= b.length ? Integer.MAX_VALUE : b[bMid];
        if (aVal <= bVal){
            return kth(a, aMid + 1, b, bLeft, k - k / 2);
        } else {
            return kth(a, aLeft,  b, bMid + 1, k - k / 2);
        }
    }
}
