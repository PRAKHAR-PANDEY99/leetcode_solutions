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
    public TreeNode bstFromPreorder(int[] preorder) {
        Stack<TreeNode> st=new Stack<>();
        TreeNode root= new TreeNode(preorder[0]);
        st.push(root);
        for(int i=1;i<preorder.length;i++){
            if(st.peek().val>preorder[i]){
                TreeNode l=new TreeNode(preorder[i]);
                st.peek().left=l;
                st.push(l);     
            }
            else{
                TreeNode nn=new TreeNode(preorder[i]);
                while(!st.isEmpty() && st.peek().val<preorder[i]){
                    TreeNode last=st.pop();
                    if(!st.isEmpty() && st.peek().val>preorder[i]){
                        last.right=nn;
                        st.push(nn);
                        break;
                    }
                    if(st.isEmpty()){
                        last.right=nn;
                        st.push(nn);
                    }

                }
            }


        }
        return root;
        
    }
}