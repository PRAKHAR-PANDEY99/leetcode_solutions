class Solution {
    int x = 0;

    void dfs(TreeNode node, List<Long> list) {
        if (node == null || x == 1) return;

        if (node.val <= list.get(0) || node.val >= list.get(1)) {
            x = 1;
            return;
        }

        // Left subtree
        List<Long> left = new ArrayList<>(list);
        left.set(1, (long) node.val);
        dfs(node.left, left);

        // Right subtree
        List<Long> right = new ArrayList<>(list);
        right.set(0, (long) node.val);
        dfs(node.right, right);
    }

    public boolean isValidBST(TreeNode root) {
        List<Long> list = new ArrayList<>();
        list.add(Long.MIN_VALUE);
        list.add(Long.MAX_VALUE);

        dfs(root, list);

        return x == 0;
    }
}