/*
700_Search_in_a_Binary_Search_Tree
You are given the root of a binary search tree (BST) and an integer val.
Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.

Example 1:

Input: root = [4,2,7,1,3], val = 2
Output: [2,1,3]

Example 2:

Input: root = [4,2,7,1,3], val = 5
Output: []


 */
public class Q700_Search_in_a_Binary_Search_Tree {

    //search and return the treenode only (Laicode)
    public TreeNode searchBST(TreeNode root, int key) {
        TreeNode cur = root;
        while (cur != null && cur.val != key){
            if (cur.val < key){
                cur = cur.right;
            } else if (cur.val >= key){
                cur = cur.left;
            }
        }
        return cur;
    }
}
