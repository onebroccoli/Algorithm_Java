/*
60 laicode height of binary tree
Find the height of binary tree.

Examples:

        5

      /    \

    3        8

  /   \        \

1      4        11

The height of above binary tree is 3.

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
public class Height_of_Binary_Tree {
    public int findHeight(TreeNode root){
        if (root == null){
            return 0;
        }
        int heightLeft = findHeight(root.left);
        int heightRight = findHeight(root.right);
        int current = Math.max(heightLeft, heightRight) + 1;
        return current;
    }
}
