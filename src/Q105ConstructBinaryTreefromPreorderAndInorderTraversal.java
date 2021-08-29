import java.util.HashMap;
import java.util.Map;

/*

Reconstruct Binary Tree With Preorder And Inorder
Laicode 213
Given the preorder and inorder traversal sequence of a binary tree, reconstruct the original tree.
Assumptions
The given sequences are not null and they have the same length
There are no duplicate keys in the binary tree
Examples
preorder traversal = {5, 3, 1, 4, 8, 11}
inorder traversal = {1, 3, 4, 5, 8, 11}
the corresponding binary tree is
        5
      /    \
    3        8
  /   \        \
1      4        11
How is the binary tree represented?
We use the pre order traversal sequence with a special symbol "#" denoting the null node.
For Example:
The sequence [1, 2, #, 3, 4, #, #, #] represents the following binary tree:
    1
  /   \
 2     3
      /
    4


不是很明白[1, 2, #, 3, 4, #, #, #] 为什么后面有###三个#
test case: Input: new int[]{1,2,3,4,11,6}, new int[]{3,1,2,6,4,11}
 */

/*
preorder的第一个节点一定是根节
preorder: root, left, right
inorder: left, root, right

1. mark the first one as root
2. find the position in the inorder sequence
3. all the left of root in the sequence is left subtree, all the right of the root in the sequence is right subtree

eg
    3
   / \
  9  20
 /  / \
8  15  7
preorder = [3,9,8, 20,15, 7]
inorder =  [8,9,3, 15,20, 7]

build Map: key: treenode value, Value: index(position in the sequence)

1. 先找到3是第一轮root
2. 在inorder里找到root(3)的位置inRoot， 左边【8，9】就是left subtree, 右边【15，20，7】就是right subtree
3. 就可以把preorder弄成left = preLeft + 1, right =
 */
public class Q105ConstructBinaryTreefromPreorderAndInorderTraversal {
    public TreeNode reconstruct(int[] inorder, int[] preorder) {
        //utilizing the inOrder sequence to determine the size of left/right subtrees
        //assumption: pre, in are not null, there is no duplicates in the binary tree,
        // the length of pre and inorder are guaranteed to be the same
        Map<Integer, Integer> map = indexMap(inorder); //use inOrder to build dictionary,key:treenode value, value: position
        return helper(preorder, inorder, 0, 0,  inorder.length - 1, map);
    }
    private Map<Integer, Integer> indexMap(int[] inorder){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return map;
    }

    private TreeNode helper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd, Map<Integer, Integer> map){
        if (preStart >= preorder.length || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = map.get(preorder[preStart]); //get root 在inorder 里的位置
        root.left = helper(preorder, inorder, preStart + 1, inStart, rootIndex - 1, map);//[inStart, rootIndex - 1] 左子树
        root.right = helper(preorder, inorder, preStart + rootIndex - inStart + 1,  rootIndex + 1, inEnd, map);//[rootIndex + 1, inEnd]右子树; preStart加上右边有多少个左子树数字， （rootIndex - inStart + 1)
        return root;
    }
//    private TreeNode helper(int[] preOrder, Map<Integer, Integer> inIndex, int inLeft, int inRight, int preLeft, int preRight){
//        if (inLeft > inRight){
//            return null;
//        }
//        TreeNode root = new TreeNode(preOrder[preLeft]);
//        //get the position of the root in inOrder sequence, so that we
//        //will know the size of the left/right subtrees
//        int inMid = inIndex.get(root.val);
//        root.left = helper(preOrder, inIndex, inLeft, inMid - 1, preLeft + 1, preLeft + inMid - inLeft);
//        root.right = helper(preOrder, inIndex, inMid + 1, inRight, preRight + inMid - inRight + 1, preRight);
//        return root;
//    }
}
