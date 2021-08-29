/*
Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.



Example 1:
     3
   /  \
  9   20
     /  \
    15   7


Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: inorder = [-1], postorder = [-1]
Output: [-1]


Constraints:

1 <= inorder.length <= 3000
postorder.length == inorder.length
-3000 <= inorder[i], postorder[i] <= 3000
inorder and postorder consist of unique values.
Each value of postorder also appears in inorder.
inorder is guaranteed to be the inorder traversal of the tree.
postorder is guaranteed to be the postorder traversal of the tree.
 */

import java.util.HashMap;
import java.util.Map;

/*
Solution:
     3
   /  \
  9   20
  /  /  \
 8  15   7
post order: left, right, root
inorder: left, root, right


postorder: [8,9,15,7,20,3]
inorder:   [8,9,3, 15, 20, 7]

round 1: root 3 ,   inorder 3左边是[8,9] left, [15,20,7] 是right


 */
public class Q106ConstructBinaryTreefromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder){
        if (inorder == null || postorder == null|| inorder.length != postorder.length){
            return null;
        }
        Map<Integer, Integer> map = indexMap(inorder);
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, map);
    }

    private Map<Integer, Integer> indexMap(int[] inorder){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return map;
    }

    private TreeNode helper(int[] inorder,  int[] postorder ,int inStart, int inEnd, int postStart, int postEnd, Map<Integer, Integer> map){
        if (inStart  > inEnd || postStart < 0){
            return null;
        }
        int rootIndex = map.get(postorder[postEnd]); //找到inorder里root的position
        TreeNode root = new TreeNode(postorder[postEnd]);
        root.left = helper(inorder, postorder, inStart, rootIndex - 1, postStart, postStart + rootIndex - inStart - 1, map);
        root.right = helper(inorder, postorder, rootIndex + 1, inEnd, postStart + rootIndex - inStart, postEnd - 1, map);
        return root;
    }
}
