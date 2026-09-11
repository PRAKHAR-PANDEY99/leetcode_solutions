class Solution {
    class Pair {
        TreeNode n;
        int depth;
        Pair(TreeNode n, int depth) {
            this.n = n;
            this.depth = depth;
        }
    }
    Pair dfs(TreeNode root, int depth) {
               if (root == null) {
    return new Pair(null, depth - 1);
}
        if (root.left == null && root.right == null) {
            return new Pair(root, depth);
        }
        Pair left = dfs(root.left, depth + 1);
        Pair right = dfs(root.right, depth + 1);
        if (left.depth > right.depth) {
            return left;
        }
        if (right.depth > left.depth) {
            return right;
        }
        return new Pair(root, left.depth);
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root, 0).n;
    }
}