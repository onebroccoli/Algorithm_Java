/*
laicode 211
这题是BST！

Given the postorder traversal sequence of a binary search tree, reconstruct the original tree.

Assumptions

The given sequence is not null
There are no duplicate keys in the binary search tree
Examples

postorder traversal = {1, 4, 3, 11, 8, 5}

the corresponding binary search tree is

        5

      /    \

    3        8

  /   \        \

1      4        11

How is the binary tree represented?

We use the pre order traversal sequence with a special symbol "#" denoting the null node.

For Example:

The sequence [1, 2, #, #, 3, 4, #, #, #] represents the following binary tree:

    1

  /   \

 2     3

      /

    4
 */

/*
1. construct the root node of BST, which woule be the last key in the postorder sequence
2. Find index i of the last key in the postorder sequence which is smaller than the root node
3. recurse for right subtree with keys in the postorder sequence that appears after the i'th index (excluding the last index)
4. recurse for left subtree with keys in the postorder sequence that appears before i'th index (including the i'th index)

eg.
     15
  /     \
 10     20
/  \   / \
8 12  16 25

postorder: {8,12,10,16,25,20,15}
1. 15 becomes the root node
2. since 10 is the last key in the postorder sequence which is smaller than root node,
    the left subtree contains {8, 12,10}
    the right subtree contains {16,25,20}
 */
public class ReconstructBinarySearchTreeWithPostorderTraversal {
    public TreeNode reconstruct(int[] post){
        //Assumptions: postorder is not null
        //there is no duplicate in the BST
        //traversing position of the post order
        //we traverse and construct the binary search tree
        //from the postOrder right to left
        int[] index = new int[]{post.length - 1};//build an array with postorder length
        return helper(post, index, Integer.MIN_VALUE);
    }
    private TreeNode helper(int[] postorder, int[] index, int min){
        //Since it is a BST, the min is the acctually the root
        //we are using the root value to determine the boundary of left /right subtree
        if (index[0] < 0 || postorder[index[0]] <= min){
            return null;
        }
        TreeNode root = new TreeNode(postorder[index[0]--]);
        root.right = helper(postorder, index, root.val);
        root.left = helper(postorder, index, min);
        return root;
    }

    public static void main(String[] args){
        TreeNode a = new TreeNode(15);
        TreeNode b = new TreeNode(10);
        TreeNode c = new TreeNode(20);
        TreeNode d = new TreeNode(8);

        TreeNode e = new TreeNode(12);
        TreeNode f = new TreeNode(16);
        TreeNode g = new TreeNode(25);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;

        ReconstructBinarySearchTreeWithPostorderTraversal s = new ReconstructBinarySearchTreeWithPostorderTraversal();
        int[] post = {8,12,10,16,25,20,15};
        TreeNode ans = s.reconstruct(post);
        System.out.print(ans.val);

    }
}
