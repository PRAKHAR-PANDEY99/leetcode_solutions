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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            TreeNode n=new TreeNode(val);
            return n;
        }
        TreeNode node=root;
        int x=0;
        while(root!=null){
            if(root.val<val){
                if(root.right==null){
                    TreeNode n=new TreeNode(val);
                    root.right=n;
                    return node;
                }
                root=root.right;
            }
            else{
                if(root.left==null){
                    TreeNode n=new TreeNode(val);
                    root.left=n;
                    return node;
                }
                root=root.left;
            }
        }
        return node;
    }
}