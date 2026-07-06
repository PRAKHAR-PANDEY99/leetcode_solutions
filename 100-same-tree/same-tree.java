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
    int x=0;
    int dfs(TreeNode p,TreeNode q){
        if(p==null && q==null) return 0;
        if(p==null && q!=null){
            x=1;
            return 0;
        }
        if(p!=null && q==null){
            x=1;
            return 0;
        }
        if(p.val!=q.val) x=1;
        int l=dfs(p.left,q.left);
        int r=dfs(p.right,q.right);
        return 0;

    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        dfs(p,q);
        if(x==0) return true;
        return false;

        
    }
}