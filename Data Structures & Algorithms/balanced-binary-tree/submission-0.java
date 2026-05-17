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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        // at a node - find the max  height of LeftSubTree
        int leftSubTree = calcHeight(root.left);
        int rightSubTree = calcHeight(root.right);

        int possibleAtRoot = Math.abs(leftSubTree-rightSubTree);

        // chck at root level + solve the problem at root's left subtree + solve the problem again on root's right subtree

        return possibleAtRoot <=1 && isBalanced(root.left) && isBalanced(root.right);

    }

    int calcHeight(TreeNode root){
        // purpose is to calculate the maximum height - of branch - branch means it can take turns. 
        if(root == null)
            return 0;
        
        return 1 + Math.max(calcHeight(root.left), calcHeight(root.right));
    }
}

/**
for each node, calculate the left height and right height 

node_height = left_height > right_height ? left_height - right_left : right_left - left_height;

return node_height <= 1 ? true : false;

If you take naive example - you might think with only root - 1 traversal is enough - O(n) - bt this is not the case 

naive example : 

        1 
      /   \              from 1 - left max height - 1 | right max height - 2 --> right-left = 1 - valid 
     2     3            
          /
        4

take this example - realize the difference between BT and BST 

        1 
      /   \             from root - its perfectly balanced
     2.    3           you ll compute from top - down right. you need every part of tree to be valid
    /       \          at such cases - at node (2) - left height = 2 = right height = 0 -- invalid 
   4.        5         Tc : O(n^2) Sc : O(n^2)
  /           \
 6             7
  

*/