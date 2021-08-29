public class Q450_Delete_Node_In_a_BST {
    public TreeNode deleteTree(TreeNode root, int key){
        if (root == null){
            return null;
        }
        if (root.val == key){
            if (root.left == null){
                return root.right;
            } else if (root.right == null){
                return root.left;
            }
            //if root.right.left == null, 把root.left 挪到root.right.left
            else if (root.right.left == null){
                root.right.left = root.left;
                return root.right;
            } else {
                TreeNode newRoot = deleteSmallest(root.right);
                newRoot.left = root.left;
                newRoot.right = root.right;
                return newRoot;
            }
        }
        if (root.val > key){
            root.left = deleteTree(root.left, key);
        } else if (root.val < key){
            root.right = deleteTree(root.right, key);
        }
        return root;
    }
    private TreeNode deleteSmallest(TreeNode root){
        while (root.left.left != null){
            root = root.left;
        }
        TreeNode smallest = root.left;
        root.left = root.left.right;
        return smallest;
    }
}
