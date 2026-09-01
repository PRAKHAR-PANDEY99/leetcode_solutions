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
    void dfs(TreeNode root,List<Integer> list){
        if(root==null) return;
        dfs(root.left,list);
        list.add(root.val);
        dfs(root.right,list);
        return;
    }
    TreeNode dfss(List<Integer> list,int low,int high){
        if(low>high) return null;
        if(low==high){
            TreeNode root = new TreeNode(list.get(low));
            return root;
        }
        int mid=(low+high)/2;
        TreeNode root=new TreeNode(list.get(mid));
        root.left=dfss(list,low,mid-1);
        root.right=dfss(list,mid+1,high);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        dfs(root,list);
        return dfss(list,0,list.size()-1);

        
    }
}