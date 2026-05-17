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
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    int dfs(TreeNode root){
        if(root == null)
            return 0;

        int leftMax = Math.max(0, dfs(root.left));
        int rightMax = Math.max(0, dfs(root.right));

        int currentPathSum = root.val + leftMax + rightMax;

        maxSum = Math.max(currentPathSum, maxSum);

        return root.val + Math.max(leftMax, rightMax);
    }
}

/***

                            -15
                         /      \ 
                       10         20 
                                /    \
                               15     5 
                              /
                            -5

        
        at node -5 
        if (root == null)
            return root.val;  

        at every node, 
            chk maxisum, root.val + leftSum + rightSum 
            and pass either of the branch (root.val + leftSum )  or (root.val + rightSum)
                                          ( root.val + max(leftSum, rightSum))


        It will traverse to 10 , L =0 , r = 0 , res = 10 

*/