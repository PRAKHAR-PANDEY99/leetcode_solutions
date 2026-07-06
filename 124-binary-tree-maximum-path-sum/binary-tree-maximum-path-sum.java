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
     int x=Integer.MIN_VALUE;
     int dfs(TreeNode root){
        if(root==null) return 0;
        int lft=Math.max(0,dfs(root.left));
        int rgt=Math.max(0,dfs(root.right));
        x=Math.max(x,lft+rgt+root.val);
        return root.val+ Math.max(lft,rgt);
    }
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return x;

    }
}