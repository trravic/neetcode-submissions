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
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode root, int maxSeenSoFar){
        if(root == null)
            return 0;
        
        int res = (root.val >= maxSeenSoFar) ? 1 : 0;
        maxSeenSoFar = Math.max(maxSeenSoFar, root.val);

        res += dfs(root.left, maxSeenSoFar);
        res += dfs(root.right, maxSeenSoFar);

        return res;
    }
}
/**
GoodNodes - given the root value, 

DFS based approach 

at each node, chck node.val >= maxSoFar -> count as good node, update maxSoFar 

recursive exploration 
1. left 
2. right 
with maxSeenSoFar at respective nodes. 


*/