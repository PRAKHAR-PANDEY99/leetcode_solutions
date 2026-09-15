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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null) return list;
        q.offer(root);
        while(!q.isEmpty()){
            int n=q.size();
            List<Integer> l=new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode pp=q.poll();
                l.add(pp.val);
                if(pp.left!=null){
                    q.offer(pp.left);
                }
                if(pp.right!=null){
                    q.offer(pp.right);
                }  
            }
            list.add(l);
        }
        Collections.reverse(list);
        return list;
        
    }
}