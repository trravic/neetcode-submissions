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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if(root == null)  return "#";
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null){
                res.append("# ");
            } else {
                res.append(node.val).append(" ");
                q.add(node.left);
                q.add(node.right);
            }
        }

        return res.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(" ");
        if(vals[0].equals("#")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        int i = 1;

        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(!vals[i].equals("#")){
                curr.left = new TreeNode(Integer.parseInt(vals[i]));
                q.add(curr.left);
            }
            i++;
            if(!vals[i].equals("#")){
                curr.right = new TreeNode(Integer.parseInt(vals[i]));
                q.add(curr.right);
            }
            i++;
        }

        return root; 
    }
}
