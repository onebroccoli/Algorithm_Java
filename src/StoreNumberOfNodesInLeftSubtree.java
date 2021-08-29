/*
Given a binary tree, count the number of nodes
in each node’s left subtree, and store it in the numNodesLeft field.

Examples
                  1(6)
               /      \
           2(3)      3(0)
          /   \
      4(1)   5(0)
      /   \     \
   6(0)   7(0)   8(0)

The numNodesLeft is shown in parentheses.
 */


public class StoreNumberOfNodesInLeftSubtree {
    static class TreeNodeLeft{
        int key;
        TreeNodeLeft left;
        TreeNodeLeft right;
        //store number of nodes in the left subtree
        int numNodesLeft;
        public TreeNodeLeft(int key){
            this.key = key;
        }
    }

    public void numNodesLeft(TreeNodeLeft root){
        numNodes(root);
    }

    //return #of nodes in the subtree
    private int numNodes(TreeNodeLeft root){
        if (root == null){
            return 0;
        }
        //leftNum is the #of nodes in the subtree of root.left
        int leftNum = numNodes(root.left);
        //rightNum is the #of nodes in the subtree of root.right
        int rightNum = numNodes(root.right);
        root.numNodesLeft = leftNum;
        //return the total # of nodes in the subtree of root
        return leftNum + rightNum + 1;
    }
}
