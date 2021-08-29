import java.util.LinkedList;
import java.util.Queue;

/*
958. Check Completeness of a Binary Tree

Given the root of a binary tree, determine if it is a complete binary tree.

In a complete binary tree, every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.



Example 1:


Input: root = [1,2,3,4,5,6]
Output: true
Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left as possible.
Example 2:


Input: root = [1,2,3,4,5,null,7]
Output: false
Explanation: The node with value 7 isn't as far left as possible.

 */
public class Q958_Check_Completeness_of_a_Binary_Tree {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        //if the flag is set true,
        //there should not be any child node afterwards;
        boolean flag = false;
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            //if any of the child is not present, set the flag to true
            if (cur.left == null){
                flag = true;
            } else if (flag){
                //if flag is set but we still see cur has a left child,
                //the binary tree is not a completed one
                return false;
            } else {
                //if flag is not set and left child is present.
                queue.offer(cur.left);
            }
            //same logic applied to right child
            if (cur.right == null){
                flag = true;
            } else if (flag){
                return false;
            } else {
                queue.offer(cur.right);
            }
        }
        return true;
    }
}