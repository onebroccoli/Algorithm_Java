/*
Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.


Example 1:


Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [0]
Output: [0]


Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100

 */

/*
Solution:
    1
   / \
  2   5
 / \   \
3   4   6
触底到6，
root = 6, prev[0] = null, 6.right = null， 6.left = null, prev[0] = 6
root = 5, prev[0] = 6,    5.right = 6,     5.left = null, prev[0] = 5
root = 4, prev[0] = 5,    4.right = 5,     2.left = null, prev[0] = 4
root = 3, prev[0] = 4,    3.right = 4,     3.left = null, prev[0] = 3
root = 2, prev[0] = 3,    2.right = 3,     2.left = null, prev[0] = 2
root = 1, prev[0] = 2,    1.right = 2,     1.left = null, prev[0] = 1
 */
public class Q114_Flatten_Binary_Tree_to_Linked_List {
    public void flatten(TreeNode root) {
        TreeNode[] prev = new TreeNode[1];
        helper(root, prev);
    }

    private void helper(TreeNode root, TreeNode[] prev){
        if (root == null){
            return;
        }
        helper(root.right, prev);
        helper(root.left, prev);
        root.right = prev[0];
        root.left = null;
        prev[0] = root;
    }

    public static void main(String[] args){
        Q114_Flatten_Binary_Tree_to_Linked_List s = new Q114_Flatten_Binary_Tree_to_Linked_List();
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        a.left = b;
        b.left = c;
        b.right = d;
        a.right = e;
        e.right = f;
        s.flatten(a);
        while (a.right != null){
            System.out.println((a.val));
            a = a.right;
        }

    }
}
