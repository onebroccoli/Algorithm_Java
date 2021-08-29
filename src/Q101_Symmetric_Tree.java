/*
Given the root of a binary tree, check whether it is a mirror of itself
(i.e., symmetric around its center).



Example 1:


Input: root = [1,2,2,3,4,4,3]
Output: true
Example 2:


Input: root = [1,2,2,null,3,null,3]
Output: false


Constraints:

The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100


Follow up: Could you solve it both recursively and iteratively?
 */
public class Q101_Symmetric_Tree {
    public boolean isSymmetric(TreeNode root){
        if (root == null){
            return true;
        }
        return isSymmetric(root.left, root.right);
    }
    private boolean isSymmetric(TreeNode one, TreeNode two){
        //1. True: if both left and right are null
        //2. False:
        //  1)one of left and right subtree is null
        //  2)key not equal    }
        if (one == null && two == null) {
            return true;
        } else if (one == null || two == null){
            return false;
        } else if (one.val != two.val){
            return false;
        }
        //check the symmetric condition, left = right, right = left both need to be met.
        return isSymmetric(one.left, two.right) && isSymmetric(one.right, two.left);
    }
}
