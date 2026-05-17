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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return root;
        
        if(key > root.val){
            root.right = deleteNode(root.right, key);
        } else if(key < root.val){
            root.left = deleteNode(root.left, key);
        } else {
            // found at the node - root == key 
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;

            TreeNode successor = root.right;
            while(successor.left != null)
                successor = successor.left;
            
            successor.left = root.left;
            TreeNode res = root.right;
            root = null;
            return res;
        }
        return root;
    }
}

/**
Same intutition of Insert Into Binary Search tree problem. 


if node is found, you need to delete and rebalance it. 

Smart rebalance is to 

if youre deleting the node, find the rightMostGuy and replace it with deleted node. 

*/

/**
But this approach doesnt utilize the property of BST. but it will fit for BT 

    // Go by BFS Traversal 
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                TreeNode curr = q.poll();
                if(curr.val == key){
                    //deletion process
                    deletion(curr);
                    return root;
                } 

                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);

            }
        }
        return root;
    }

    void deletion(TreeNode curr){
        if(curr.right == null)
        {
            if(curr.left!=null)
                curr = curr.left;
            else 
                curr = null;
        } else {
            TreeNode temp = curr;
            curr = curr.right;
            while(curr.left != null){
                curr = curr.left;
            }
            temp.val = curr.val;
        }
    }


*/