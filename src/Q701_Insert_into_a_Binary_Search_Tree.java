public class Q701_Insert_into_a_Binary_Search_Tree {

    //recursion:
    //TC: O(H) best: O(logn), worst O(N)
    //SC: O(H) best: O(logn) keep the recursion stack, worst O(N)
    public TreeNode insertIntoBST_Iter(TreeNode root, int key){
        if (root == null){
            return new TreeNode(key);
        }
        if (key < root.val){
            root.left = insertIntoBST_Iter(root.left, key);
        } else if (key > root.val){
            root.right = insertIntoBST_Iter(root.right,key);
        }
        return root;
    }

    //Iterative
    //TC: O(H) best O(logn), worst O(N)
    //SC: O(1)constant space
    public TreeNode insertIntoBST(TreeNode root, int key){
        if (root == null){
            return new TreeNode(key);
        }
        TreeNode cur = root;
        while (cur.val != key){
            if (cur.val < key){
                if (cur.right == null){
                    cur.right = new TreeNode(key);
                }
                cur = cur.right;
            } else {
                if (cur.left == null){
                    cur.left = new TreeNode(key);
                }
                cur = cur.left;
            }
        }
        return root;
    }

}
