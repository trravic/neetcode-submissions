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
    public int max = 0;
    public int maxDepth(TreeNode root) {
        // Base case: an empty tree has a depth of 0
        if (root == null) {
            return 0;
        }
        
        // Ask for the depth of left and right subtrees
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        // The depth of the current node is 1 + the max of its children
        return 1 + Math.max(left, right);
    }

}
