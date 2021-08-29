/*
Given two nodes in a binary tree, find their lowest common ancestor.

Assumptions

There is no parent pointer for the nodes in the binary tree

The given two nodes are guaranteed to be in the binary tree

     1
   /  \
  2    3
 /\   / \
4 5   6 7

LCA(4,5) = 2
LCA(4,6) = 1
LCA(3,4) = 1
LCA(2,4) = 2
 */
public class LowestCommonAncestorI {
    //return:
    //null : if there is no one or two in the subtree
    //non null:
    //1) if there is only one node of one/two in the subtree, just return one/two itself
    //2) if both one/two in the subtree, return LCA
    //      * one is two's ancestor, return one
    //      * two is one's ancestor, return two
    //      * otherwise, return the lowest node with one and two in the two different subtrees.
    public TreeNode LCAI(TreeNode root, TreeNode one, TreeNode two){
        if (root == null){
            return null;
        }
        //if root is one or two, we can jgnore the later recursion
        if (root == one || root == two){
            return root;
        }
        TreeNode l = LCAI(root.left, one, two);
        TreeNode r = LCAI(root.right, one, two);
        if (l != null && r != null){
            return root;
        }
        return l == null ? r : l;
    }
    public static void main(String[] args){
        LowestCommonAncestorI s = new LowestCommonAncestorI();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        TreeNode result = s.LCAI(root, new TreeNode(1),new TreeNode(4));
        System.out.println(result);


    }
}
