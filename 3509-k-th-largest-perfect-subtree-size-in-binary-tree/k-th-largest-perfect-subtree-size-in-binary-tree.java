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
        boolean t;
        int n;
        Pair(boolean t,int n){
            this.t=t;
            this.n=n;
        }
    }
    Pair dfs(TreeNode root,List<Integer> list){
        if(root==null) {
            return new Pair(false,0);
        }
        if(root.left==null && root.right==null){
            list.add(1);
            return new Pair(true,1);
        }
        Pair left=dfs(root.left,list);
        Pair right=dfs(root.right,list);
        if(left.t==true && right.t==true && left.n==right.n){
            list.add(left.n+right.n+1);
            return new Pair(true,left.n+right.n+1);
        }
        return new Pair(false,-1);
    }
    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        List<Integer> list=new ArrayList<>();
        Pair p=dfs(root,list);
        Collections.sort(list,Collections.reverseOrder());
        if(list.isEmpty()){
            return -1;
        }
        if(list.size()<k){
            return -1;
        }
        return list.get(k-1);

    }
}