/*

373. Find K Pairs with Smallest Sums
You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u, v) which consists of one element from the first array and one element from the second array.

Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.



Example 1:

Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]]
Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
Example 2:

Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
Output: [[1,1],[1,1]]
Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
Example 3:

Input: nums1 = [1,2], nums2 = [3], k = 3
Output: [[1,3],[2,3]]
Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]


Constraints:

1 <= nums1.length, nums2.length <= 104
-109 <= nums1[i], nums2[i] <= 109
nums1 and nums2 both are sorted in ascending order.
1 <= k <= 1000
 */

import java.util.PriorityQueue;

/*
Laicode https://app.laicode.io/app/problem/27
27. Kth Smallest Sum In Two Sorted Arrays
Given two sorted arrays A and B, of sizes m and n respectively.
Define s = a + b, where a is one element from A and b is one element from B.
Find the Kth smallest s out of all possible s'.

Assumptions

A is not null and A is not of zero length, so as B
K > 0 and K <= m * n
Examples

A = {1, 3, 5}, B = {4, 8}

1st smallest s is 1 + 4 = 5
2nd smallest s is 3 + 4 = 7
3rd, 4th smallest s are 9 (1 + 8, 4 + 5)
5th smallest s is 3 + 8 = 11
 */
//laicode need kth smallest, leetcode need k pairs smallest
/*
no need to create a class, because index(i,j) is what we need.
hashset can be used to reduce space, but still a class is not necessary
use Set<Integer> and transform index(i,j) to one dimentional index i*n + j, put that index in the hashset.
determine if the new index is in the hashset is easy.
if a class is used, then both equals() method and hashCode() have to be overwritten which is too complicated

 */
//public class Q373_Find_K_Pairs_with_Smallest_Sums {
//    public int kthSum(int[] A, int[] B, int k){
//        if (k == 1){
//            return A[0] + B[0];
//        }
//        int m = A.length;
//        int n = B.length;
//        if (k == m * n){
//            return A[m - 1] + B[n - 1];
//        }
//        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>(){
//            @Override
//            public int compare(int[] a, int[] b){
//                return Integer.compare(A[a[0]] + B[a[1]], A[b[0]] + B[b[1]]);
//            }
//        });
//        boolean[][] visited = new boolean[m][n];
//        visited[0][0]  = true;
//        int[][] dirs = {{1,0},{0,1}};
//
//    }
//}
