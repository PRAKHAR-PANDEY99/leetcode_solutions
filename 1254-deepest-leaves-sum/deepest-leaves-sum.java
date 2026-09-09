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
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null) return 0;
        if(root.left==null && root.right==null) return root.val;
        q.offer(root);
        int sum=0;
        int max=0;
        while(!q.isEmpty()){
            sum=0;
            int n=q.size();
            for(int i=0;i<n;i++){
                TreeNode p=q.poll();
                sum=sum+p.val;
                if(p.left!=null){
                    q.offer(p.left);
                }
                if(p.right!=null){
                    q.offer(p.right);
                }
            }
            max=sum;

        }
        return max;
    }
}