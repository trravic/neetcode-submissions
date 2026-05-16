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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        
        int leftSubTreeHeight = maxHeight(root.left);
        int rightSubTreeHeight = maxHeight(root.right);

        int diameter = leftSubTreeHeight + rightSubTreeHeight;

        int sub = Math.max(diameterOfBinaryTree(root.left), 
                            diameterOfBinaryTree(root.right));
        return Math.max(sub, diameter);
    }

    int maxHeight(TreeNode root){

        if(root == null)
            return 0;
        return 1 + Math.max(maxHeight(root.left), maxHeight(root.right));
    }


    // For nodes 
        /**
                1 
                    2 
                3       4
            5

            Explanation: 3 is the length of the path [1,2,3,5] or [5,3,2,4].

            for any given node, find the height of left subtree 
                                find the height of right subtree 
                                dia = left + right
                                maintain the maximum dia for each and every node . 
        */
}
