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
    static int dfs(TreeNode root,List<Integer> list){
        if(root==null ) return 0;
        int l=dfs(root.left,list);
        int r=dfs(root.right,list);
        if(list.get(0)<=(l+r)){
            list.set(0,l+r);
        } 
        return 1+Math.max(l,r);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        list.add(0);
        if(root==null) return 0;
        int k=dfs(root,list);
        return list.get(0);

    }
}