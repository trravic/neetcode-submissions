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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q!=null)
            return false;
        if(p != null && q == null)
            return false;
    
        if(p == null && q == null)
            return true;
        if(p.val == q.val){
            boolean leftVal = isSameTree(p.left, q.left);
            boolean rightVal = isSameTree(p.right, q.right);
            return leftVal && rightVal;
        }

        return false;

    }
}
/**
    Recursive soln 

    1. chck if both nodes are equal
       At a node , move both left at same time , move both right at sam etime.add()
       at a node, u need to reach consensus - both are equal. 
       if something is false, you skip the flow. 


*/
