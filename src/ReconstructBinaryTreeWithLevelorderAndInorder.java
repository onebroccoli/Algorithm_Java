import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
laicode 215. Reconstruct Binary Tree With Levelorder And Inorder
Given the levelorder and inorder traversal sequence of a binary tree, reconstruct the original tree.

Assumptions

The given sequences are not null and they have the same length
There are no duplicate keys in the binary tree
Examples

levelorder traversal = {5, 3, 8, 1, 4, 11}

inorder traversal = {1, 3, 4, 5, 8, 11}

the corresponding binary tree is

        5

      /    \

    3        8

  /   \        \

1      4        11

How is the binary tree represented?

We use  level order traversal sequence with a special symbol "#" denoting the null node.

For Example:

The sequence [1, 2, 3, #, #, 4] represents the following binary tree:

    1

  /   \

 2     3

      /

    4
 */
public class ReconstructBinaryTreeWithLevelorderAndInorder {
    public TreeNode reconstruct(int[] inorder, int[] levelorder){
        //Assumptions: level and inorder are not null
        //there is no duplicates in the binary tree
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i); //get position of treenode
        }
        List<Integer> temp = new ArrayList<Integer>();
        for (int num : levelorder){
            temp.add(num);
        }
        return helper(temp, map);
    }

    private TreeNode helper(List<Integer> levelorder, Map<Integer, Integer> map){
        if (levelorder.isEmpty()){
            return null;
        }
        TreeNode root = new TreeNode(levelorder.remove(0));
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int num : levelorder){
            if (map.get(num) < map.get(root.val)){
                left.add(num);
            } else {
                right.add(num);
            }
        }
        root.left = helper(left, map);
        root.right = helper(right, map);
        return root;

    }
}
