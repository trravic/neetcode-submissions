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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // edge case 
        if(subRoot == null)
            return true;

        if(root == null)
            return false; // meaning subroot has some value, bt parent is null 
        
        return compareSubRootExistsInRoot(subRoot, root) || isSubtree(root.left,subRoot)
                                                         || isSubtree(root.right,subRoot);

        // you need to call isSubTree inorder to check from every node. 
        // Tc : O(n) - for every node if match found, O(m) => O(n*m)                                                
    }

    boolean compareSubRootExistsInRoot(TreeNode subRoot, TreeNode root){
        if(subRoot == null && root == null){
            // possibility on recursion if both are found and bottom is done. 
            return true;
        }

        if(root != null && subRoot != null && subRoot.val == root.val){
            boolean leftVal = compareSubRootExistsInRoot(subRoot.left, root.left);
            boolean rightVal = compareSubRootExistsInRoot(subRoot.right, root.right);
            return leftVal && rightVal;
        }

        return false; // if value mismatches

    }
    
}
/**
    carry the root and subroot 

    if both references matches, 
        move the root.left, subroot.left == reference match 
        move the root.right, subroot.right == reference match 

    if not matches, return false. 

*/
