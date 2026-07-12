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
    TreeNode dfs(TreeNode root,List<Integer> list){
        if(root==null) return null;
        TreeNode left=dfs(root.left,list);
        if(left!=null){
            list.add(left.val);
        }
        list.add(root.val);
        TreeNode right=dfs(root.right,list);
        if(right!=null){
            list.add(right.val);
        }
        return null;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        dfs(root,list);
        return list;
        
        
    }
}