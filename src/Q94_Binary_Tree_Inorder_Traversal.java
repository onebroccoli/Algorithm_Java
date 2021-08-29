///*
//Given the root of a binary tree, return the inorder traversal of its nodes' values.
//
//
//
//Example 1:
//
//
//Input: root = [1,null,2,3]
//Output: [1,3,2]
//Example 2:
//
//Input: root = []
//Output: []
//Example 3:
//
//Input: root = [1]
//Output: [1]
//Example 4:
//
//
//Input: root = [1,2]
//Output: [2,1]
//Example 5:
//
//
//Input: root = [1,null,2]
//Output: [1,2]
//
//
//Constraints:
//
//The number of nodes in the tree is in the range [0, 100].
//-100 <= Node.val <= 100
//
//
//Follow up:
//
//Recursive solution is trivial, could you do it iteratively?
// */
//
///**
// * public class TreeNode {
// *   public int key;
// *   public TreeNode left;
// *   public TreeNode right;
// *   public TreeNode(int key) {
// *     this.key = key;
// *   }
// * }
// */
//import java.util.List;
//import java.util.Stack;
//import java.util.ArrayList;
//
///*
//Solution:
//Iterative:
//Space: O(N)
//Time: O(N)
// */
//public class Q94_Binary_Tree_Inorder_Traversal {
//    public List < Integer > inOrder(TreeNode root) {
//        List < Integer > res = new ArrayList < > ();
//        Stack < TreeNode > stack = new Stack < > ();
//        TreeNode curr = root;
//        while (curr != null || !stack.isEmpty()) {
//            while (curr != null) {
//                stack.push(curr);
//                curr = curr.left;
//            }
//            curr = stack.pop();
////            res.add(curr.key); //需要一个单独treenode class
//            curr = curr.right;
//        }
//        return res;
//    }
//}
//
// //   需要查一下为啥不对？
//// public class Solution {
////   public List<Integer> inOrder(TreeNode root) {
////     List<Integer> inorder = new ArrayList<Integer>();
////     Deque<TreeNode> stack = new LinkedList<TreeNode>();
//
////     TreeNode cur = root;
////     while (cur != null || stack.isEmpty()){
////       //always try go to the left side to see if there is any node
////       //should be traversed before the cur node, cur node is stored
////       //on stack since it has not been traversed yet.
////       while (cur != null){
////         stack.offerFirst(cur);
////         cur = cur.left;
////       }
////       //if can not go left, meaning all the nodes on the left side of
////       //the top node on stack have been traversed, the next traversing
////       //node should be the top node on stack.
////       cur = stack.pollFirst();
////       inorder.add(cur.key);
////       //the next subtree we need to traverse is right subtree
////       cur = cur.right;
////     }
////     return inorder;
////   }
////}
//
//}

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q94_Binary_Tree_Inorder_Traversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        helper(root.left, result);
        result.add(root.val);
        helper(root.right, result);

    }

    //left, root, right
    public List<Integer> inorderTraversal_iterative(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            //always try go to the left side to see if there is any node
            //should be traversed before the cur node, cur node is stored
            //on stack since it has not been traversed yet.
            while (cur != null) {
                stack.offerFirst(cur);
                cur = cur.left;
            }
            //if can not go left, meaning all the nodes on the left side of
            //the top node on stack have been traversed, the next traversing
            //node should be the top node on stack.
            cur = stack.pollFirst();
            result.add(cur.val);
            //the next subtree we need to traverse is right subtree
            cur = cur.right;
        }
        return result;

    }

}





