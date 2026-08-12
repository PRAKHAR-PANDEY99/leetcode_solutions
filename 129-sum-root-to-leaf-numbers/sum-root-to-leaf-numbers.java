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
        TreeNode node;
        int cn;
        Pair(TreeNode node,int cn){
            this.node=node;
            this.cn=cn;
        }
    }
    public int sumNumbers(TreeNode root) {
        Stack<Pair> st=new Stack<>();
        st.push(new Pair(root,0));
        int sum=0;
        while(!st.isEmpty()){
            Pair pp=st.pop();
            TreeNode node=pp.node;
            int cn=pp.cn;
            int newcn=cn*10+node.val;
            if(node.left!=null){
                st.push(new Pair(node.left,newcn));
            }
            if(node.right!=null){
                st.push(new Pair(node.right,newcn));
            }
            if(node.left==null && node.right==null){
                sum=sum+cn*10+node.val;
            }

        }
        return sum;
        
        
    }
}