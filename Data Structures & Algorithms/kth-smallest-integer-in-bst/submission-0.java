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
    public int kthSmallest(TreeNode root, int k) {
        //List<Integer> arr = new ArrayList<>();
        int[] arr = new int[2]; // {k, ans}
        arr[0] = k;
        dfs2(root, arr);
        return arr[1];

        //return arr.get(k-1);
    }

    //optimized approach - traverse only O(k) times 

    void dfs2(TreeNode root, int[] tmp){
        if(root == null)
        return;

        dfs2(root.left, tmp);

        if(tmp[0] == 0) return;
        
        tmp[0] -= 1;

        if(tmp[0] == 0) {
            tmp[1] = root.val;
            return ;
        }

        dfs2(root.right, tmp);

    }

    //Below approach is O(n)
    void dfs(TreeNode root, List<Integer> arr){
        if(root == null)
            return; 
        
        dfs(root.left, arr);
        arr.add(root.val);
        dfs(root.right, arr);
    }
}


/**

Since the tree is a Binary Search Tree (BST),
 we can leverage its structure and perform an in-order traversal, 
 where we first visit the left subtree, then the current node, and finally the right subtree. 
 Why? Because we need the k-th smallest integer, and by visiting the left subtree first,
 we ensure that we encounter smaller nodes before the current node

 We keep a counter variable cnt to track the position of the current node in the ascending order of values.
  When cnt == k, we store the current node's value in a global variable and return. 
  This allows us to identify and return the k-th smallest element during the in-order traversal.



*/