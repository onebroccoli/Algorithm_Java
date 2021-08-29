/*
 Distance between two given nodes in a given binary search tree.
  Assuming:

there is no parent pointer.

both nodes belong to the tree.

           15

        /          \

      5           20

     /    \

   3      10

 /   \      /

1   4    8

          /   \

         7     9



distance(3, 8) = 3

distance(5, 7) = 3

distance(1, 9) = 5



class TreeNode {

int val;

TreeNode left;

TreeNode right;

}
 */

/*
Solution:
first calculate LCA for two nodes
then use recursion to go through recursion tree to find the distance
add the path : node 1 to LCA + node 2 to LCA
TC: O(N)
SC: O(height)
*/
public class distanceInBST {
    public int distanceBST(TreeNode root,int p, int q){
        if (p == q) {
            return 0;
        }
        TreeNode ancestor = LCA(root, p, q);
        return distance(ancestor, p) + distance(ancestor, q); //add the path node1 to LCA and node2 to LCA

    }

    //given two nodes, find their lowewst common ancestor
    public TreeNode LCA(TreeNode root,int p, int q){
        //corner cases
        if (root == null) {
            return null;
        }
        if (root.val == p || root.val == q) {
            return root;
        }
        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }

    public int distance(TreeNode node,int val){
        if (node == null) {
            return -1;
        }
        if (node.val == val) {
            return 0;
        }
        int leftDistance = distance(node.left, val);
        int rightDistance = distance(node.right, val);
        int distance = Math.max(leftDistance, rightDistance);
        return distance >= 0 ? distance + 1 : -1;
    }
}