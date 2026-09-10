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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int  s=0;
        int ans=0;
        int max=Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int n=q.size();
            s=s+1;
            int sum=0;
            for(int i=0;i<n;i++){
                TreeNode p=q.poll();
                if(p.left!=null){
                    q.offer(p.left);
                }
                if(p.right!=null){
                    q.offer(p.right);
                }
                sum=sum+p.val;
            }
            if(sum>max){
                max=sum;
                ans=s;
            }

        }
        return ans;
        
    }
}