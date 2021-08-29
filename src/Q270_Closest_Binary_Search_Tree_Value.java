/*
Given the root of a binary search tree and a target value, return the value in the BST that is closest to the target.

Example 1:
    4
   / \
  2   5
 /\
1 3

Input: root = [4,2,5,1,3], target = 3.714286
Output: 4

Example 2:

Input: root = [1], target = 4.428571
Output: 1


Constraints:

The number of nodes in the tree is in the range [1, 104].
0 <= Node.val <= 109
-109 <= target <= 109

 */
public class Q270_Closest_Binary_Search_Tree_Value {
    public int closest(TreeNode root, double target) {
        //assumptions: the given binary search tree is not null
        int result = root.val;
        //the closest number has to be on the pathof finding
        //the target value in the BST
        while (root != null){
            if (root.val == target){
                return root.val;
            } else {
                if (Math.abs(root.val - target) < Math.abs(result - target)){
                    result = root.val;
                }
                if (root.val < target){
                    root = root.right;
                } else {
                    root = root.left;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        Q270_Closest_Binary_Search_Tree_Value s = new Q270_Closest_Binary_Search_Tree_Value();
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(5);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(3);
        a.left = b;
        a.right = c;
        b.left = e;
        b.right = d;
        double target = 4.6;
        int result = s.closest(a, target);
        System.out.println(result);

    }
}
