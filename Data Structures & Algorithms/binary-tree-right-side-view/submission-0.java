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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
            TreeNode rightSideNode = null;
            int size = q.size();
            while(size-- > 0){
                TreeNode node = q.poll();
                if(node!=null){
                    //Treat it as rightSideNode - if level has more last one will be actually overriden which is your right side node 
                    rightSideNode = node;
                    q.offer(node.left);
                    q.offer(node.right);
                }
            }
            if(rightSideNode != null){
                res.add(rightSideNode.val);
            }
        }
       return res;
    }
}
