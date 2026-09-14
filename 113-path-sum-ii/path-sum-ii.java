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
    void dfs(TreeNode root,int sum,int targetSum,List<List<Integer>> list,List<Integer> l){
        if(root==null) return;
        if(root.left==null && root.right==null){
            if(root.val+sum==targetSum){
                l.add(root.val);
                list.add(new ArrayList<>(l));
                l.remove(l.size()-1);
                return;
            }
            return;
        }
        if(root.left!=null){
            l.add(root.val);
            dfs(root.left,sum+root.val,targetSum,list,l);
            l.remove(l.size()-1);
        }
        if(root.right!=null){
            l.add(root.val);
            dfs(root.right,sum+root.val,targetSum,list,l);
            l.remove(l.size()-1);
        }
        return;
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list=new ArrayList<>();
        dfs(root,0,targetSum,list,new ArrayList<>());
        return list;
        
        
    }
}