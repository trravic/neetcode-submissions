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
       // 1. If both are null, they are identical so far
        if (p == null && q == null) {
            return true;
        }
        
        // 2. If one is null and the other isn't, they aren't identical
        if (p == null || q == null) {
            return false;
        }
        
        // 3. If the values don't match, they aren't identical
        if (p.val != q.val) {
            return false;
        }
        
        // 4. Recursively check the left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right); 
    }
}
/**
    Recursive soln 

    1. chck if both nodes are equal
       At a node , move both left at same time , move both right at sam etime.add()
       at a node, u need to reach consensus - both are equal. 
       if something is false, you skip the flow. 


*/
