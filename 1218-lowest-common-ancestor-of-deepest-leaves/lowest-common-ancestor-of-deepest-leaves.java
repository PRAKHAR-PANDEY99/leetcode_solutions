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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        HashMap<TreeNode,TreeNode> map=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        List<TreeNode> list=new ArrayList<>();
        while(!q.isEmpty()){
            int n=q.size();
            list=new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode p=q.poll();
                list.add(p);
                if(p.left!=null){
                    map.put(p.left,p);
                    q.offer(p.left);
                }
                if(p.right!=null){
                    map.put(p.right,p);
                    q.offer(p.right);
                }
            }
        }
        if(list.size()==1) return list.get(0);
        TreeNode first=list.get(0);
        TreeNode second=list.get(list.size()-1);
        while(first.val!=second.val){
            if(map.get(first).val==map.get(second).val){
                return map.get(first);
            }
            first=map.get(first);
            second=map.get(second);
        }
        return first;
        
    }
}