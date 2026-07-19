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
    int x=1;
    void dfs(TreeNode root,HashSet<Integer> map,int k){
        if(root==null) return;
        if (map.contains(k - root.val)) {
            x=0;
            return;
        }
        map.add(root.val);
        dfs(root.left,map,k);
        dfs(root.right,map,k);
        return;

    }
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> map=new HashSet<>();
        dfs(root,map,k);
        if(x==0) return true;
        return false;

        
    }
}