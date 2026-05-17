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
    public boolean isValidBST(TreeNode root) {
        return valid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean valid(TreeNode root, int left, int right){
        if(root == null)
            return true;
        
        if(!(left < root.val && root.val < right))
            return false;
        
        return valid(root.left, left, root.val) && 
                valid(root.right, root.val, right);
    }
}

/**

Brute Force - O(n^2) - to check every node again and again. wasteful processing 

Optimized - O(n) 

BST works in the specified range 

if u want place left node -> -INF, node.val 

if u want place right node -> node.val, +INF 

bt the about condition is for top root. 

lets say you have tree 

                    5
                /       \
               3         9
              /. \      /. \
             1    4.   7.   11


    if u see above BST, at node 3 search space 
    (-INF, INF) for 5 -> 
    -INF, 5 ) for 3 -> P 
    (-INF, 3) for 1 - passed
    (3, 5) for 4 -> passed  left < root.val < right for LST 

    -----------------
    5, INF) for 9 -- > P 
    5, 9  ) for 7 -- > P 
    9, INF) for 11 -- > P 


*/
