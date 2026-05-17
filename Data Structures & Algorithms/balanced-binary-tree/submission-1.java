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
        return dfs(root)[0] == 1;
    }
    /**
       dfs[2] - { validity, heightOfSubtree}
    */
    int[] dfs(TreeNode root){
        if(root == null)
            return new int[]{1, 0};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        boolean balanced = (left[0]==1 && right[0]==1) &&
                      (Math.abs(left[1] - right[1]) <= 1);
        
        int height = 1 + Math.max(left[1], right[1]);

        return new int[] {balanced ? 1 : 0, height};
    }
}

/**

 submission1 - Below submission is O(n^2) - check other submission 
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

/**
 submission2 - Below submission TC - O(n) - Sc: O(h)

 optimiazation - BruteForce wasteful processing on every node 
 instead you can do at one-pass while going top-down

 do two things at once at every node 
 1. calc the left + right subtree heights 
 2. if diff > 1 : mark the subtree is valid or not. 

 these 2 things conveys important meanings. 

 when you hit rock bottom and traversing up it helps you to decide whether to calculate the other portion of tree 
 based on validity of current node. 

 1. if its valid, compute the other portion of height. else direct return false.add()

    

*/
