/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the left and right subtrees of
every node differ in height by no more than 1.


 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Q110_Balanced_Binary_Tree{
    public boolean isBalanced(TreeNode root){
        if (root == null){
            return true;
        }
        //call funtion height, if == -1, then false, != -1 then true;
        return (height(root) != -1);
    }

//build method height to calculate the height of the tree
    private int height(TreeNode root){
        int leftHeight;
        int rightHeight;
        if (root == null){
            return 0;
        }
        leftHeight = height(root.left);
        if (leftHeight == -1){
            return -1;
        }
        rightHeight = height(root.right);
        if (rightHeight == -1){
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
