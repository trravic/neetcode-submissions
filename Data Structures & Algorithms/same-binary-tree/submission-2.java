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
    public boolean isSameTree(TreeNode p, TreeNode q){
        // Iterative BFS-Based 
        // Compare each levels 
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.add(p);
        q2.add(q);

        while(!q1.isEmpty() && !q2.isEmpty()){
            for(int i = q1.size() ; i > 0 ; i--){
                TreeNode nodeP = q1.poll();
                TreeNode nodeQ = q2.poll();

                if(nodeP == null && nodeQ == null)
                    continue;
                
                //2. any of nodes is null - not valid
                if(nodeP == null || nodeQ == null || nodeP.val != nodeQ.val)
                    return false;
                
                q1.add(nodeP.left);
                q1.add(nodeP.right);
                q2.add(nodeQ.left);
                q2.add(nodeQ.right);
            }
        }
        return true; // meaning both q's are empty - successful processing
    }
}

    /**
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

/**
    Recursive soln 

    1. chck if both nodes are equal
       At a node , move both left at same time , move both right at sam etime.add()
       at a node, u need to reach consensus - both are equal. 
       if something is false, you skip the flow. 


*/
