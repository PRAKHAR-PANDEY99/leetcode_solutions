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
    int c=0;
    class Pair{
        int sum;
        int count;
        Pair(int sum,int count){
            this.sum=sum;
            this.count=count;
        }
    }
    Pair dfs(TreeNode root){
            if(root.left==null && root.right==null){
                c=c+1;
                return new Pair(root.val,1);
            }
            Pair left=new Pair(0,0);
            if(root.left!=null){
                left=dfs(root.left);
            }
            Pair right=new Pair(0,0);
            if(root.right!=null){
                right=dfs(root.right);
            }
            if(Math.round((root.val +left.sum+right.sum)/(left.count+right.count+1))==root.val){
                c=c+1;
            }
            return new Pair(root.val+left.sum+right.sum,left.count+right.count+1);
        }
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return c;
        
    }
}