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
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        if(root==null) return root;
        while(!q.isEmpty()){
            TreeNode p=q.poll();
            if(p.left!=null){
                TreeNode k=p.left;
                p.left=p.right;
                p.right=k;
            }
            else if(p.right!=null){
                TreeNode k=p.right;
                p.right=p.left;
                p.left=k;

            }
            if(p.left!=null){
                q.offer(p.left);
            }
            if(p.right!=null){
                q.offer(p.right);
            }
        }
        return root;
        
    }
}