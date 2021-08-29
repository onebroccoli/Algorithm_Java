/*
140. Maximum Path Sum Binary Tree III
Given a binary tree in which each node contains an integer number. Find the maximum possible subpath sum(both the starting and ending node of the subpath should be on the same path from root to one of the leaf nodes, and the subpath is allowed to contain only one node).

Assumptions

The root of given binary tree is not null
Examples

   -5

  /    \

2      11

     /    \

    6     14

           /

        -3

The maximum path sum is 11 + 14 = 25

How is the binary tree represented?

We use the level order traversal sequence with a special symbol "#" denoting the null node.

For Example:

The sequence [1, 2, 3, #, #, 4] represents the following binary tree:

    1

  /   \

 2     3

      /

    4
 */
public class MaxPathSumBinaryTreeIII {
    public int maxPathSum(TreeNode root) {
        //assumption: root is not null
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        helper(root, max);
        return max[0];
    }
    private int helper(TreeNode root, int[] max){
        if (root == null){
            return 0;
        }
        int left = helper(root.left, max);
        int right = helper(root.right, max);
        int sin = Math.max(Math.max(left, right), 0) + root.val;
        max[0] = Math.max(max[0], sin);
        return sin;
    }
}
