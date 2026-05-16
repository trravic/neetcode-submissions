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
    

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;

        while(curr != null){
            if(curr.left == null){
                res.add(curr.val);
                curr = curr.right;
            } else {
                // find the rightmost guy in left subtree 
                // and make connection. because youre iterating you need to go up at some point of time after hitting rock bottom. 

                //rightMostGuy is one step left of curr 
                TreeNode rightMostGuy = curr.left;

                while(rightMostGuy.right != null && rightMostGuy.right != curr) 
                {
                    rightMostGuy = rightMostGuy.right;
                }

                // make a connection 
                if(rightMostGuy.right == null){
                    rightMostGuy.right = curr;
                    curr = curr.left;
                }

                // think about the case if you keep on connecting it ll end up loop scenario. 
                // if you have processed the entire left subtree of curr, 
                //pls cutoff during the next iteration and say curr has been processed and youre good to move right

                if(rightMostGuy.right == curr){
                    rightMostGuy.right = null;
                    res.add(curr.val);
                    curr = curr.right;
                }
            }

        }

        return res;

    }
}