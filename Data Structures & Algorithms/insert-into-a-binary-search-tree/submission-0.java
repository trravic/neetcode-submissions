/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)
            return new TreeNode(val);
        
        if(val > root.val){
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }

    public TreeNode insertIntoBST2Approach(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode cur = root;
        while (true) {
            if (val > cur.val) {
                if (cur.right == null) {
                    cur.right = new TreeNode(val);
                    return root;
                }
                cur = cur.right;
            } else {
                if (cur.left == null) {
                    cur.left = new TreeNode(val);
                    return root;
                }
                cur = cur.left;
            }
        }
    }


}
/**

Insert into BST 

Note: There may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion.
 You can return any of them.

The note is the clue 

                                    5 
                                /       \
                               3         9
                              /  \         \
                             1   4

Insert 6 

chck root value - > decide the traverse space based on lesser/greater 

6 is greater 5 - Move right 

6 is smaller than 9 but no children is there - so direct insert to left 


                                    5 
                                /       \
                               3         9
                              /  \      /
                             1   4.    6 

if youre asked to insert 7 now, you can traverse thru 6 and insert below it. 

Crux : always you can find the best place of the curr node whose child is empty ( left or right) - you can find that spot and insert it 



*/