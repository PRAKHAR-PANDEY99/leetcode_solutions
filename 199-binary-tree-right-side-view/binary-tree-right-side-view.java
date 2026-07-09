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
    class Pair{
        TreeNode node;
        int col;
        Pair(TreeNode node,int col){
            this.node=node;
            this.col=col;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        Queue<Pair> q=new LinkedList<Pair>();
        TreeMap<Integer,Integer> map=new TreeMap<>();
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        q.add(new Pair(root,0));
         while(!q.isEmpty()){
            Pair p=q.poll();
            map.put(p.col,p.node.val);
            if(p.node.left!=null){
                q.add(new Pair(p.node.left,p.col+1));
            }
            if(p.node.right!=null){
                q.add(new Pair(p.node.right,p.col+1));
            }
            
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
        
    }
}