/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    List<TreeNode> list=new ArrayList<>();
    List<TreeNode> list1=new ArrayList<>();
    void dfs(TreeNode root, TreeNode p, TreeNode q,List<TreeNode> l){
        if(root==null) return;
        l.add(root);
        if(root==p){
            list=new ArrayList<>(l);
        }
        if(root==q){
            list1=new ArrayList<>(l);
        }
        dfs(root.left,p,q,l);
        dfs(root.right,p,q,l);
        l.remove(l.size()-1);
        return;

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q,new ArrayList<>());
        int i=0;
        TreeNode ans=null;
        while (i < list.size() && i < list1.size()) {
            if (list.get(i) == list1.get(i))
                ans = list.get(i);
            else
                break;
            i++;
        }
        
        return ans;
    }
}