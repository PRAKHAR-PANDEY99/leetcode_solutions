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
    TreeNode dfs(int[] inorder,int instart,int inend,int[] postorder,int poststart,int postend,HashMap<Integer,Integer> map){
        if(instart>inend || poststart>postend) return null;
        TreeNode root=new TreeNode(postorder[postend]);
        int inroot=map.get(root.val);
        int numsleft=inroot-instart;
        root.left=dfs(inorder,instart,inroot-1,postorder,poststart,poststart+numsleft-1,map);
        root.right=dfs(inorder,inroot+1,inend,postorder,poststart+numsleft,postend-1,map);
        return root;

    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode root=dfs(inorder,0,inorder.length-1,postorder,0,postorder.length-1,map);
        return root;


        
    }
}