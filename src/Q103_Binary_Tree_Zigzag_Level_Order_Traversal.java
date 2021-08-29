import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).



Example 1:
   3
  / \
9   20
    / \
   15  7

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100

 */
//public class Q103_Binary_Tree_Zigzag_Level_Order_Traversal {
//    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
//
//    }
//}
/*


Solution:
Use deque, for each row,
Even row number: pollLast from deque, insert into one side of the deque, insert from right to left, so when read,
Odd row number: pollFirst from deque, offerLast into the other side of deque (left to right)

*********************
   3
  / \
9   20
    / \
   15  7
root,layer = 0, deque = 3, pollLast list = [3]; deque [9, 20] offerFirst(right[20]), offerFirst(left[9])
       *  head  <-- 9,20||    tail
     layer = 1, pollFirst 9,  list = [3, 9]
     layer = 1, pollFirst 20, list = [3, 9, 20], offerLast(left[15]), offerLast(right[7]), deque (15, 7)
       *  head   ||15, 7 -->   tail
     layer = 2, pollLast 7, List = [3, 9, 20, 7]
                pollLst 15, List = [3, 9, 20, 7, 15]

Case2:
       5
     /  \
    3   10
   /     \
  2      11
 /        \
1         13
 */


public class Q103_Binary_Tree_Zigzag_Level_Order_Traversal {
    public List<Integer> zigZag(TreeNode root) {
        if (root == null){
            return new LinkedList<Integer>();
        }
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        List<Integer> list = new LinkedList<Integer>();
        deque.offerFirst(root);
        int layer = 0; //layer = 0 means even layer, layer = 1 means odd layer
        while (!deque.isEmpty()){
            //the size of current level should be extracted at the first place
            //because the size of the deque is changing all the time
            int size = deque.size();
            for (int i = 0; i < size; i++){
                if (layer == 0){
                    //at even layer, from right to left
                    TreeNode tmp = deque.pollLast();
                    list.add(tmp.val);
                    if (tmp.right != null){
                        deque.offerFirst(tmp.right);
                    }
                    if (tmp.left != null){
                        deque.offerFirst(tmp.left);
                    }
                } else {
                    //at odd layer, from left to right
                    TreeNode tmp = deque.pollFirst();
                    list.add(tmp.val);
                    if (tmp.left != null){
                        deque.offerLast(tmp.left);
                    }
                    if (tmp.right != null){
                        deque.offerLast(tmp.right);
                    }
                }
            }
            layer = 1 - layer;
        }
        return list;
    }

    public static void main(String[] args){
        Q103_Binary_Tree_Zigzag_Level_Order_Traversal s = new Q103_Binary_Tree_Zigzag_Level_Order_Traversal();
//        TreeNode a = new TreeNode(3);
//        TreeNode b = new TreeNode(9);
//        TreeNode c = new TreeNode(20);
//        TreeNode d = new TreeNode(15);
//        TreeNode e = new TreeNode(7);
//        a.left = b;
//        a.right = c;
//        c.left = d;
//        c.right = e;
//        List<Integer> result = s.zigZag(a);
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(10);
        TreeNode d = new TreeNode(2);
        TreeNode e = new TreeNode(11);
        TreeNode f = new TreeNode(1);
        TreeNode g = new TreeNode(13);
        a.left = b;
        a.right = c;
        b.left = d;
        c.right = e;
        d.left = f;
        e.right = g;
        List<Integer> result = s.zigZag(a);
        System.out.println(result);


    }

}



