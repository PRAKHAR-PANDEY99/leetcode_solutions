class Solution {

    void dfs(TreeNode root1, TreeNode root2) {
        root1.val += root2.val;
        if (root1.left == null && root2.left != null) {
            root1.left = root2.left;
        } else if (root1.left != null && root2.left != null) {
            dfs(root1.left, root2.left);
        }
        if (root1.right == null && root2.right != null) {
            root1.right = root2.right;
        } else if (root1.right != null && root2.right != null) {
            dfs(root1.right, root2.right);
        }
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null) return root2;
        if (root2 == null) return root1;

        dfs(root1, root2);
        return root1;
    }
}