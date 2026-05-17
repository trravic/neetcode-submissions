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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Iterative DFS 
        TreeNode curr = root;

        while(curr != null){
            if(p.val > curr.val && q.val > curr.val){
                curr = curr.right;
            } else if(p.val < curr.val && q.val < curr.val){
                curr = curr.left;
            } else {
                //deflection pt 
                // can also satisifes p.val < curr.val > q.val 
                // either p == curr.val || q.val also 
                return curr;
            }
        }
        return null; // null never would be returned because p and q always exists as per constraint

    }
    // TC : O(h) - mostly O(log h)

}

/**

LCA 
                            5
                         /      \
                        3         8 
                     /     \     /  \
                    1       4   7     9
                     \
                      2

                    P = 3 ; Q = 7 

                    return the lowest common anscestor
    Think on the cases first 
    1. P can be found on left subtree  Q can be found on right subtree
    2. Both can be found on the same subtree, 
            say for example if p = 1 and q = 7 , at every node, it can collect the information whether child is found 
            p child is found, q child is found at parent P = 5 - return it as ancestor 

    3. How well, p can itself be parent, and q can be found in any of the left subtree / right subtree 
    

    Btw, you forgot to use an important property BST 
    meaning  left side of subtree will be less than root 
            right side of subtree will be greater than root 

    max(p, q) < root.val 
        search in left subspace 
    min(p, q) > root.val 
        search in right subspace 
    else 
        return true; because (in constraint p and q will both exist in the BST.)

    


*/
